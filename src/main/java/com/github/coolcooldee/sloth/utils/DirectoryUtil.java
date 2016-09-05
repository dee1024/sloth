package com.github.coolcooldee.sloth.utils;

import com.github.coolcooldee.sloth.Application;
import com.google.common.io.CharStreams;

import java.io.*;
import java.net.URL;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by sloth on 16/6/22.
 */
public abstract class DirectoryUtil {

    // 文件所在的层数
    private static int fileLevel;

    /**
     * 生成输出格式
     *
     * @param pathname  输出的文件名或目录名
     * @param level 输出的文件名或者目录名所在的层次
     * @return 输出的字符串
     */
    private static String createPrintStr(String pathname, int level) {
        // 输出的前缀
        String printStr = "";
        // 按层次进行缩进
        for (int i = 0; i < level; i++) {
            printStr = printStr + "│   ";
        }
        printStr = printStr + "├── " + pathname;
        return printStr;
    }

    /**
     * 输出初始给定的目录
     *
     * @param dirPath 给定的目录
     */
    private static void printDir(String dirPath) {
        // 将给定的目录进行分割
        String[] dirNameList = dirPath.split("\\\\");
        // 设定文件level的base
        fileLevel = dirNameList.length;
        // 按格式输出
        for (int i = 0; i < dirNameList.length; i++) {
            System.out.println(createPrintStr(dirNameList[i], i));
        }
    }

    /**
     * 输出给定目录下的文件，包括子目录中的文件
     *
     * @param dirPath 给定的目录
     */
    public static void readFile(String dirPath) {

        Set<String> ignoreDirNamesSet = new HashSet<>();
        ignoreDirNamesSet.add(".idea");
        ignoreDirNamesSet.add("target");

        // 建立当前目录中文件的File对象
        File file = new File(dirPath);
        // 取得代表目录中所有文件的File对象数组
        File[] list = file.listFiles();
        // 遍历file数组
        for (int i = 0; i < list.length; i++) {
            if (list[i].isDirectory()) {

                if (ignoreDirNamesSet.contains(list[i].getName())) {
                    continue;
                }

                System.out.println(createPrintStr(list[i].getName(), fileLevel));
                fileLevel++;
                // 递归子目录
                readFile(list[i].getPath());
                fileLevel--;
            } else {
                System.out.println(createPrintStr(list[i].getName(), fileLevel));
            }
        }
    }

    /**
     * 获取给定目录下的文件，包括子目录中的文件
     *
     * @param dirPath 给定的目录
     */
    public static String readFile2String(String dirPath) {

        StringBuffer sb = new StringBuffer();
        Set<String> ignoreDirNamesSet = new HashSet<>();
        ignoreDirNamesSet.add(".idea");
        ignoreDirNamesSet.add("target");

        // 建立当前目录中文件的File对象
        File file = new File(dirPath);
        // 取得代表目录中所有文件的File对象数组
        File[] list = file.listFiles();
        // 遍历file数组
        for (int i = 0; i < list.length; i++) {
            if (list[i].isDirectory()) {

                if (ignoreDirNamesSet.contains(list[i].getName())) {
                    continue;
                }

                sb.append(createPrintStr(list[i].getName(), fileLevel)+"\n");
                fileLevel++;
                // 递归子目录
                sb.append(readFile2String(list[i].getPath()));
                fileLevel--;
            } else {
                sb.append(createPrintStr(list[i].getName(), fileLevel)+"\n");
            }
        }

        return sb.toString();
    }


    /**
     * 输出给定目录下的文件，包括子目录中的文件
     */
    public static void copyFolder(File src, File dest, final Set<String> ignoreFileSuffixs) {

        CodeSource codeSource = Application.class.getProtectionDomain().getCodeSource();
        String location = codeSource.getLocation().getPath();

        if(location.endsWith(".jar")){
            String relativeSrcPath = "template/common/pagetemplate/static/";
            if (src != null) {
                URL jar = codeSource.getLocation();
                ZipInputStream zip = null;
                try {
                    zip = new ZipInputStream(jar.openStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                while(true) {
                    ZipEntry zipEntry = null;
                    try {
                        zipEntry = zip.getNextEntry();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    if (zipEntry == null)
                        break;
                    String name = zipEntry.getName();
                    if (name.startsWith(relativeSrcPath)&&(name.endsWith(".js")||name.endsWith(".css") || name.endsWith(".html"))) {

                        try {
                            InputStream inputStream=Application.class.getClass().getResourceAsStream("/"+name);
                            String text = CharStreams.toString(new InputStreamReader(inputStream, "UTF-8"));
                            //System.out.println(text);
                            String filePath = dest.getPath() + name.replace(relativeSrcPath,"/");
                            File newFile = new File(filePath);
                            if(!newFile.exists()){
                                newFile.createNewFile();
                            }

                            FileOutputStream fos = new FileOutputStream(newFile);
                            fos.write(text.getBytes());
                            fos.flush();
                            inputStream.close();
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return;
        }


        if (src.isDirectory()) {
            if (!dest.exists()) {
                FileUtil.mkdir(dest.getPath());
            }
            String files[] = src.list();
            for (String file : files) {

                boolean flag = false;
                for (String ignoreFileSuffix : ignoreFileSuffixs) {
                    if (file.endsWith(ignoreFileSuffix)) {
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    continue;
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                // 递归复制
                copyFolder(srcFile, destFile, ignoreFileSuffixs);
            }
        } else {
            InputStream in = null;
            try {
                in = new FileInputStream(src);
                OutputStream out = new FileOutputStream(dest);

                byte[] buffer = new byte[1024];

                int length;

                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
                in.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }




    /***
     * 获取指定目录下的所有的文件（不包括文件夹），采用了递归
     *
     * @param obj
     * @return
     */
    public static ArrayList<File> getListFiles(Object obj) {
        File directory = null;
        if (obj instanceof File) {
            directory = (File) obj;
        } else {
            directory = new File(obj.toString());
        }
        ArrayList<File> files = new ArrayList<File>();
        if (directory.isFile()) {
            files.add(directory);
            return files;
        } else if (directory.isDirectory()) {
            File[] fileArr = directory.listFiles();
            for (int i = 0; i < fileArr.length; i++) {
                File fileOne = fileArr[i];
                files.addAll(getListFiles(fileOne));
            }
        }
        return files;
    }

}
