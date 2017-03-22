package org.hero.soul.core.util;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;

import org.hero.soul.core.constant.PathConstants;

@SuppressWarnings("rawtypes")
public class PackageUtils {

    /**
     * 将当前路径转换成系统匹配的路径后再获取包下所有类名
     */
    public static String[] getNamesBySystemPath(String oldPath) {
        return getNames(getSystemPath(oldPath));
    }

    /**
     * 将当前路径转换成系统匹配的路径后再获取包下所有类名
     */
    public static Class[] getClazzsBySystemPath(String oldPath) {
        return getClazzs(getSystemPath(oldPath));
    }

    /**
     * 将原来的路径变量，修改为系统路径 
     * oldPath: org.doom 
     * org\doom org/doom 
     * windows:org\doom
     * unix: org/doom
     */
    public static String getSystemPath(String oldPath) {
        return oldPath.replaceAll("[./\\\\]", "\\" + File.separatorChar);
    }

    /**
     * 功能描述: 返回所有包下所有类名称
     */
    public static String[] getNames(String pachagePath) {
        try {
            ClassLoader loader = new ClassLoader() {
            };
            Enumeration<URL> resourceUrls = loader.getResources(pachagePath);
            while (!resourceUrls.hasMoreElements()) {
                return null;
            }
            URL url = resourceUrls.nextElement();
            File pfile = new File(url.toURI());
            System.out.println(pfile.getPath());
            if (!pfile.exists()) {
                System.out.println("文件不存在");
            }
            if (pfile.isDirectory()) {
                System.out.println("目录，且结构为：");
                String[] list = pfile.list();
                String[] names = new String[list.length];
                int i = 0;
                for (String name : list) {
                    System.out.println(name);
                    if (name.endsWith(PathConstants.SUFFIX_CLASS)) {
                        names[i] = name.substring(0, name.length() - PathConstants.SUFFIX_CLASS.length());
                        i++;
                    }
                }

                return Arrays.copyOf(names, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 功能描述: 获取类
     */
    public static Class[] getClazzs(String pachagePath) {
        try {
            ClassLoader loader = new ClassLoader() {
            };
            Enumeration<URL> resourceUrls = loader.getResources(pachagePath);
            while (!resourceUrls.hasMoreElements()) {
                return null;
            }
            URL urll = resourceUrls.nextElement();
            File pfile = new File(urll.toURI());
            if (!pfile.exists()) {
                System.out.println("文件不存在");
            }
            if (pfile.isDirectory()) {
                System.out.println("目录，且结构为：");
                String[] list = pfile.list();

                String[] names = new String[list.length];
                int i = 0;
                for (String name : list) {
                    if (name.endsWith(PathConstants.SUFFIX_CLASS)) {
                        names[i] = name.substring(0, name.length() - PathConstants.SUFFIX_CLASS.length());
                        i++;
                    }
                }
                names = Arrays.copyOf(names, i);
                Class[] clazzs = new Class[i];
                for (int j = 0; j < names.length; j++) {
                    String className = pachagePath + File.separatorChar + names[j];
                    className = className.replace(File.separatorChar, '.');
                    clazzs[j] = Class.forName(className);
                }
                return clazzs;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
