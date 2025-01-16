package com.kjgs.启动执行包;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class 获取所有功能名 {

    public static List<String> 内置功能名集合 = new ArrayList<>();
    public static List<String> 整合功能名集合 = new ArrayList<>();

    public static void getMethods() {
        try {
            内置功能名集合 = getClassNamesForPackage("com.kjgs.功能.内置功能");
            整合功能名集合 = getClassNamesForPackage("com.kjgs.功能.整合功能");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getClassNamesForPackage(String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".", "/");
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> directories = new ArrayList<>();

        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            directories.add(new File(resource.getFile()));
        }

        ArrayList<String> classNames = new ArrayList<>();
        for (File directory : directories) {
            for (File file : directory.listFiles()) {
                if (file.getName().endsWith(".class")) {
                    String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                    classNames.add(className);
                }
            }
        }

        return classNames;
    }

    public static void main(String[] args) {
        try {
            List<String> classNames = getClassNamesForPackage("com.example.mypackage");
            for (String className : classNames) {
                System.out.println(className);
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

}
