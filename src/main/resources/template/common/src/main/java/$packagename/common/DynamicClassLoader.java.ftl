package ${packageName}.common;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态加载class文件
 *
 */
public class DynamicClassLoader extends ClassLoader {

    // 文件最后修改时间
    private long lastModified;

    // 加载class文件的classpath
    private String classPath;

    /**
     * 检测class文件是否被修改
     *
     * @param filename
     * @return
     */
    private boolean isClassModified(String name) {
        File file = getFile(name);
        if (file.lastModified() > lastModified) {
            return true;
        }
        return false;
    }

    public Class<?> loadClass(String classPath, String name) throws ClassNotFoundException {
        this.classPath = classPath;
        if (isClassModified(name)) {
            return findClass(name);
        }
        return null;
    }

    /**
     * 获取class文件的字节码
     *
     * @param name 类的全名
     * @return
     */
    private byte[] getBytes(String name) {
        byte[] buffer = null;
        FileInputStream in = null;
        try {
            File file = getFile(name);
            lastModified = file.lastModified();
            in = new FileInputStream(file);
            buffer = new byte[in.available()];
            in.read(buffer);
            return buffer;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer;
    }

    /**
     * 获取class文件的真实路径
     *
     * @param name
     * @return
     */
    private File getFile(String name) {
        String simpleName = "";
        String packageName = "";
        if (name.indexOf(".") != -1) {
            simpleName = name.substring(name.lastIndexOf(".") + 1);
            packageName = name.substring(0, name.lastIndexOf(".")).replaceAll("[.]", "/");
        } else {
            simpleName = name;
        }
        File file = new File(MessageFormat.format("{0}/{1}/{2}.class", classPath, packageName, simpleName));
        return file;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] byteCode = getBytes(name);
        return defineClass(null, byteCode, 0, byteCode.length);
    }


    public static void complier(String javaSourcePath,String classpath) throws IOException {
        List<String> javaSourceList = new ArrayList<String>();
        getFileList(new File(javaSourcePath), javaSourceList);
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        boolean result = false;
        for (int i = 0; i < javaSourceList.size(); i++) {
            //result = javaCompiler.run(null, null, null, "-d", javaClassPath, javaSourceList.get(i));
            String filename = javaSourceList.get(i);
            StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> fileObjects = fileManager.getJavaFileObjects(filename);
            List<String> optionList = new ArrayList<String>(); // set compiler's classpath to be same as the runtime's
            optionList.addAll(Arrays.asList("-classpath",classpath));
            JavaCompiler.CompilationTask cTask = javaCompiler.getTask(null, fileManager, null, optionList, null, fileObjects);
            result = cTask.call();
            fileManager.close();
            System.out.println(result ? "Compile Successfully : " + javaSourceList.get(i) : "Compile Error : " + javaSourceList.get(i));
        }
    }

    private static void getFileList(File file, List<String> fileList) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    getFileList(files[i], fileList);
                } else {
                    if(files[i].getName().indexOf(".java")>-1)
                        fileList.add(files[i].getPath());
                }
            }
        }
    }

    public static File getLastJarPackageFile(String filePath) {
        File file = new File(filePath);
        File resultFile = null;
        if(file.isDirectory()){
            long tempastModified  = 0;
            File [] lists = file.listFiles();
            if(lists!=null){
                for(int i=0; i<lists.length; i++) {
                    File tempFile = lists[i];
                    if(tempFile.isDirectory())
                        continue;
                    if(tempFile.getName().endsWith(".jar")){
                        if(tempFile.lastModified() > tempastModified){
                            tempastModified = tempFile.lastModified();
                            resultFile = tempFile;
                        }
                    }
                }
            }
        }
        return resultFile;
    }
}