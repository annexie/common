//package com.flighroutes.common.commoncode.util;
//
//import org.apache.commons.io.FilenameUtils;
//import org.junit.Ignore;
//import org.junit.Test;
//@Ignore
//public class ImageUploadUtilTest {
//
//    private String srcImageFilePath="/Users/albertliu/img/tmp/000044.jpg";
//
//	@Test
//	public void testCompressImageConstrain() {
//        String newFilePath=ImageUploadUtil.appendImageSizePostfix(srcImageFilePath, FilenameUtils.getExtension(srcImageFilePath),200,200);
//        try {
//            ImageUploadUtil.compressImageConstrain(srcImageFilePath,newFilePath,0.5f,1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//	@Test
//	public void testCompressWidthHeightImageFile() {
//        String newFilePath=ImageUploadUtil.appendImageSizePostfix(srcImageFilePath, FilenameUtils.getExtension(srcImageFilePath),1000,1000);
//        try {
//            ImageUploadUtil.compressWidthHeightImageFile(srcImageFilePath,newFilePath,0,0,1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//	}
//
//}
