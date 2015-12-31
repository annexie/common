package org.albert.common.util;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.xuliugen.common.util.FileUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class FileUtilTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public final void testFile_type() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testRead_array() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testSave_url() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testPath() {
        List<String> files = FileUtil.path(new File("I:/amazon/promotion"));
        for (String file : files) {
            System.out.println(file);
        }
    }

    @Test
    public final void testRead_url() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testReadString() throws UnsupportedEncodingException {
        //乱码转换

        String file = FileUtil
                .read("/Users/albertliu/Desktop/Entity.sql",
                        "UTF-8");
//		System.out.println("转换前的文件:"+file);
        file = new String(file.getBytes("GBK"), "UTF-8");
        System.out.println(file);


    }

    @Test
    public final void testReadFile() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testReadFileInt() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testReadFileStringInt() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testReadStringString() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testWriteStringStringString() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testAssert_path() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testDelete() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testRename() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testWriteStringString() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testWriteDocumentString() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testSaveStringByteArray() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testSaveStringInputStream() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testExist() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testPathStringArray() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testPathFile() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testCreateZip() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testGetOrCreate() {
//		String path="/root/tomcat-data/inventorycount/FR_AMAZON/2013-10-22.xls";
        String path = "\\root\\tomcat-data\\inventorycount\\FR_AMAZON\\2013-10-22.xls";
        if (path.contains("\\")) {
            path = path.replace("\\", "/");
        }
        String[] temp = path.split("/");
        System.out.println(temp[4].toString());
    }

}
