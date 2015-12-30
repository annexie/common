package com.xuliugen.common.util;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {

    // 在unix上是/，在windows上是\
    public static String FILE_SEPERATOR = System.getProperty("file.separator");

    // 在unix上是:，在windows上是;
    public static String PATH_SEPERATOR = System.getProperty("path.separator");

    // 在unix上是\n，在windows上是\r\n
    public static String LINE_SEPERATOR = System.getProperty("line.separator");

    public static String UTF8_CHARSET_NAME = "UTF-8";

    public static String DEFAULT_CHARSET_NAME = UTF8_CHARSET_NAME;

    public static Map<String, String> FILE_TYPES = Collections
            .unmodifiableMap(new HashMap<String, String>() {
                /**
                 *
                 */
                private static final long serialVersionUID = -1239725062318096051L;

                {
                    // http://docs.amazonwebservices.com/ses/latest/DeveloperGuide/MIMETypes.html
                    put("xml", "text/xml");
                    put("txt", "text/plain");
                    put("csv", "text/csv");
                    put("html", "text/html");
                    put("htm", "text/html");
                    put("gif", "image/gif");
                    put("jpeg", "image/jpeg");
                    put("jpg", "image/jpeg");
                    put("jpe", "image/jpeg");
                    put("png", "image/png");

                    put("pdf", "application/pdf");
                    put("rtf", "application/rtf");
                    put("doc", "application/msword");
                    put("docx",
                            "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                    put("xls", "application/vnd.ms-excel");
                    put("xlsx",
                            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                    put("ppt", "application/vnd.ms-powerpoint");
                    put("pptx",
                            "application/vnd.openxmlformats-officedocument.presentationml.presentation");
                    put("zip", "application/zip");

                    put("mp3", "audio/mpeg");
                    put("wav", "audio/wav");
                    put("avi", "video/avi");
                }
            });

    public static String file_type(String name) {
        name = name.toLowerCase();
        final int idx = name.lastIndexOf(".");
        if (idx == -1) {
            return null;
        }
        name = name.substring(idx + 1);
        return FILE_TYPES.get(name);
    }

    /***
     * 读取某文件，转换成List<String>
     * @param path
     * @return
     * @throws Exception
     */
    public static List<String> read_array(String path) throws Exception {
        final List<String> items = new ArrayList<String>();
        final File file = new File(path);
        final Reader read = new FileReader(file);
        final BufferedReader reader = new BufferedReader(read);
        String line = null;
        while ((line = reader.readLine()) != null) {
            items.add(line.trim());
        }
        reader.close();
        return items;
    }

    public static boolean save_url(String rurl, String path) {
        URL url;
        URLConnection cont;
        try {
            url = new URL(rurl);
            cont = url.openConnection();
            cont.setDoInput(true);
            cont.setUseCaches(false);
            return save(path, cont.getInputStream());
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public static byte[] read(String path) throws Exception {
        final File file = new File(path);
        final InputStream is = new FileInputStream(file);
        final long length = file.length();
        final byte[] bytes = new byte[(int) length];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        is.close();

        if (offset < bytes.length) {

            throw new IOException("Could not completely read file "
                    + file.getName());
        }
        return bytes;
    }

    public static String read(File file) {
        return read(file, DEFAULT_CHARSET_NAME, 0);
    }

    public static String read(File file, int skipLines) {
        return read(file, DEFAULT_CHARSET_NAME, skipLines);
    }

    public static String read(File file, String encode, int skipLines) {
        try {
            final StringBuilder fileData = new StringBuilder(1000);
            final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), encode));
            String line = "";
            for (int i = 0; i < skipLines; i++) {
                reader.readLine(); // 跳过设定的行数
            }
            while ((line = reader.readLine()) != null) {
                fileData.append(line).append("\r\n");
            }
            reader.close();
            return fileData.toString();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String read(String path, String encode) {
        try {
            final StringBuilder fileData = new StringBuilder(1000);
            final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(new File(path)),
                            encode));
            final char[] buf = new char[1024];
            int numRead = 0;
            while ((numRead = reader.read(buf)) != -1) {
                fileData.append(buf, 0, numRead);
            }
            reader.close();
            return fileData.toString();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean write(String path, String content, String encode) {
        OutputStreamWriter outWriter = null;
        try {
            final FileOutputStream fileOutStream = new FileOutputStream(path);
            outWriter = new OutputStreamWriter(fileOutStream, encode);
            outWriter.write(content);
            outWriter.flush();
            outWriter.close();

        } catch (final Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 创建目录
     * @param pathname
     * @return
     */
    public static boolean mkdirs(String pathname) {
        final File file = new File(pathname);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return true;
    }

    public synchronized static boolean assert_path(String path) {
        final String[] ps = StringUtils.split(path, "/");
        File tmpF = null;
        for (int i = 0; i < ps.length; i++) {
            String tmpP = ps[0];
            for (int j = 1; j <= i; j++) {
                tmpP += "/" + ps[j];
            }
            tmpF = new File(tmpP);
            if (!tmpF.exists()) {
                tmpF.mkdir();
            }
        }
        tmpF = null;
        return true;
    }

    public static void delete(String path) {
        final File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void rename(String path, String newPath) {
        final File file = new File(path);
        if (file.exists()) {
            file.renameTo(new File(newPath));
        }
    }

    public static boolean write(String path, String content) {
        final File file = new File(path);
        try {
            final FileWriter w = new FileWriter(file);
            w.write(content, 0, content.length());
            w.flush();
            w.close();
        } catch (final IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static boolean save(String path, byte[] in) {
        final File file = new File(path);
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(file));
            bos.write(in);
            bos.flush();
            bos.close();
            return true;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean save(String path, InputStream in) {
        final File file = new File(path);
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(file));
            bis = new BufferedInputStream(in);
            int c;
            while ((c = bis.read()) != -1) {
                bos.write(c);
                bos.flush();
            }
            bos.close();
            bis.close();
            return true;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean exist(String path, String name) {
        final File dir = new File(path);
        final File files[] = dir.listFiles();
        for (final File file : files) {
            if (file.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> path(String[] dirs) {
        final List<String> paths = new ArrayList<String>();
        for (final String dir : dirs) {
            paths.addAll(path(new File(dir)));
        }
        return paths;
    }

    public static List<String> path(File f) {
        final List<String> paths = new ArrayList<String>();
        final File files[] = f.listFiles();
        for (final File file : files) {
            if (file.isDirectory()) {
                paths.addAll(path(file));
            } else {
                paths.add(file.getPath());
            }
        }
        return paths;
    }

    /**
     * 生成压缩文件 工具 weizi 2012-08-29
     * @param files   需要压缩的文件路径集合（需要指定绝对路径）
     * @param zipName 生成压缩文件的名称（需要指定绝对路径）
     * @return
     */
    public static boolean createZip(List<String> files, String zipName) {
        ZipOutputStream zos = null;
        BufferedInputStream bis = null;
        final boolean flag = true;
        try {
            zos = new ZipOutputStream(new FileOutputStream(zipName));
            zos.setMethod(ZipOutputStream.DEFLATED);// 设置压缩方法

            final byte[] buf = new byte[1024];
            int len;
            String fileName = "";
            for (final String file : files) {

                bis = new BufferedInputStream(new FileInputStream(
                        new File(file)), 1024);
                if (file.contains("\\")) {
                    fileName = file.substring(file.lastIndexOf("\\") + 1,
                            file.length());
                } else {
                    fileName = file.substring(file.lastIndexOf("/") + 1,
                            file.length());
                }
                zos.putNextEntry(new ZipEntry(fileName));

                while ((len = bis.read(buf)) != -1) {
                    zos.write(buf, 0, len);
                }
            }

        } catch (final Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                bis.close();
                zos.close();
            } catch (final IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return flag;
    }

    public static File getOrCreate(String path) throws IOException {
        final File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
}