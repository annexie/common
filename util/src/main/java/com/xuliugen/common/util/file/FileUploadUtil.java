package com.xuliugen.common.util.file;

import com.xuliugen.common.util.date.DateUtils;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.xuliugen.common.util.RunningMode;

import java.io.File;
import java.io.IOException;

public class FileUploadUtil {

    private static final Logger logger = LoggerFactory
            .getLogger(FileUploadUtil.class);

    protected static PropertiesConfiguration config = null;

    static {
        try {
            config = new PropertiesConfiguration("pathConfig.properties");
        } catch (ConfigurationException e) {
            logger.error(e.getMessage(), e);
        }
        FileChangedReloadingStrategy fileChangedReloadingStrategy = new FileChangedReloadingStrategy();
        fileChangedReloadingStrategy.setRefreshDelay(10 * 60 * 1000);// 每10分钟检查一次配置是否有更新文件
        config.setReloadingStrategy(fileChangedReloadingStrategy);
    }

    public static String getBasePath() {
        String basePath = RunningMode.isDevelop() ? config
                .getString("FILE_BASE_PATH_DEVELOP") : config
                .getString("FILE_BASE_PATH_PRODUCT");
        return basePath;
    }

    /**
     * 获取以年、月作为路径名的存储路径，比如:2014/10/
     * @return
     */
    public static String getYearMonthPath() {
        return DateUtils.getYear() + "/" + DateUtils.getMonthInt() + "/";
    }

    /**
     * 获取以年、月作为路径名的存储路径，比如:2014/10/25
     * @return
     */
    public static String getYearMonthDayPath() {
        return getYearMonthPath() + DateUtils.getDayInt() + "/";
    }

    /**
     * @param tempFilePath      文件大小超过设定阀值时，临时文件的存储路径
     * @param tempFileThreshold 设定阀值1M，如果超过这个值，则文件就直接写到临时文件，不会一直占用内存
     *                          利用这个特性可在上传大文件的时候不会占用大量内存，可以提高并发使用量。
     * @param uploadThreshold   最大支持多少M文件上传
     * @return
     */
    public static ServletFileUpload getServletFileUpload(String tempFilePath,
                                                         int tempFileThreshold, int uploadThreshold) {

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        // 设定阀值，如果超过这个值，则文件就直接写到临时文件，不会一直占用内存
        // 利用这个特性可在上传大文件的时候不会占用大量内存，可以提高并发使用量。
        diskFileItemFactory.setSizeThreshold(tempFileThreshold * 1024 * 1024);

        File tempFile = new File(tempFilePath);
        if (!tempFile.exists()) {
            tempFile.mkdirs();
        }

        diskFileItemFactory.setRepository(tempFile);
        ServletFileUpload servletFileUpload = new ServletFileUpload(
                diskFileItemFactory);

        servletFileUpload.setFileSizeMax(1024 * 1024 * uploadThreshold);// 限制最大上传文件的大小

        return servletFileUpload;
    }

    /**
     * @param tempFilePath 文件大小超过设定阀值时，临时文件的存储路径
     * @return
     */
    public static ServletFileUpload getServletFileUpload(String tempFilePath) {
        Integer tempFileThreshold = config
                .getInt("IMAGE_UPLOAD_TMP_FILE_THRESHOLD_IN_M");
        Integer uploadThreshold = config.getInt("FILE_UPLOAD_MAX_SIZE_IN_M");
        return getServletFileUpload(tempFilePath, tempFileThreshold,
                uploadThreshold);
    }

    /**
     * @return
     */
    public static ServletFileUpload getServletFileUpload() {
        String tempFilePath = getBasePath() + config.getString("FILE_PATH_TMP");
        Integer tempFileThreshold = config
                .getInt("IMAGE_UPLOAD_TMP_FILE_THRESHOLD_IN_M");
        Integer uploadThreshold = config.getInt("FILE_UPLOAD_MAX_SIZE_IN_M");
        return getServletFileUpload(tempFilePath, tempFileThreshold,
                uploadThreshold);
    }

    public static String saveFile(String filePath, String fileName, byte[] bytes) {

        File path = new File(filePath);
        if (!path.exists()) {
            path.mkdir();
        }
        File file = new File(path, fileName);
        try {
            FileUtils.writeByteArrayToFile(file, bytes);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return "";
        }
        String absolutePath = (filePath + fileName);
        return absolutePath;
    }

    /**
     * 去掉绝对存储路径中的基准路径
     * @param abstractFilePath 文件绝对路径
     * @return
     */
    public static String removeBasePath(String abstractFilePath) {
        return abstractFilePath != null ? abstractFilePath.replace(
                getBasePath(), "") : "";
    }

}