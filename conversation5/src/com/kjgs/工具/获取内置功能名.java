package com.kjgs.工具;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class 获取内置功能名 {

    public static List<String> 内置功能类名 = getClassNames("com.kjgs.功能.内置功能");
    public static List<String> getClassNames(String packageName) {
        List<String> classNames = new ArrayList<>();
        String packagePath = packageName.replace(".", "/");
        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    findClassNamesInFile(packageName, filePath, classNames);
                } else if ("jar".equals(protocol)) {
                    JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                    JarFile jarFile = jarURLConnection.getJarFile();
                    Enumeration<JarEntry> jarEntries = jarFile.entries();
                    while (jarEntries.hasMoreElements()) {
                        JarEntry jarEntry = jarEntries.nextElement();
                        String entryName = jarEntry.getName();
                        if (entryName.startsWith(packagePath) && entryName.endsWith(".class")) {
                            String className = entryName.replace("/", ".").replace(".class", "");
                            classNames.add(className);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classNames;
    }

    private static void findClassNamesInFile(String packageName, String filePath, List<String> classNames) {
        File file = new File(filePath);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                findClassNamesInFile(packageName, f.getAbsolutePath(), classNames);
            }
        } else {
            String className = file.getName();
            if (className.endsWith(".class")) {
                className = className.replace(".class", "");
                classNames.add(className);
            }
        }
    }

    public static void main(String[] args) {
        List<String> classNames = getClassNames("com.kjgs.功能.act");
        for (String className : classNames) {
            System.out.println(className);
        }
    }
}