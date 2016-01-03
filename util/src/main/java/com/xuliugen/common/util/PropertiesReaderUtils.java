package com.xuliugen.common.util;

import java.io.*;
import java.util.Properties;

/**
 * 从类路径资源、磁盘文件和输入流中读取属性配置。
 */
public class PropertiesReaderUtils {

    private PropertiesReaderUtils() {
    }

    public static Properties readPropertiesFromClasspath(String propertiesFile) {
        InputStream in = PropertiesReaderUtils.class.getResourceAsStream(propertiesFile);
        return readPropertiesFromInputStream(new BufferedInputStream(in));
    }

    public static Properties readPropertiesFromFile(String propertiesFile) {
        try {
            InputStream in = new FileInputStream(new File(propertiesFile));
            return readPropertiesFromInputStream(new BufferedInputStream(in));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + propertiesFile + " not found.", e);
        }
    }

    public static Properties readPropertiesFromInputStream(InputStream in) {
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Cannot load properties.", e);
        }
        return properties;
    }

}
