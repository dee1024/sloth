package com.github.coolcooldee.sloth.utils;

import java.io.File;

/**
 * Created by sloth on 16/6/26.
 */
public abstract class FileUtil {

    public static void mkdir(String path) {
        File fd = null;
        try {
            fd = new File(path);
            if (!fd.exists()) {
                fd.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fd = null;
        }
    }

    public static boolean isExists(String filePath) {
        boolean result = false;
        File fd = null;
        try {
            fd = new File(filePath);
            if (fd.exists()) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            fd = null;
        }
        return result;

    }


}
