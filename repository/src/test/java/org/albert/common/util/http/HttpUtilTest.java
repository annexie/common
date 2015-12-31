package org.albert.common.util.http;

import com.xuliugen.common.util.http.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HttpUtilTest {

    @Test
    public void testPost() {

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("key", "879a6cb3afb84dbf4fc84a1df2ab7319");
        paramMap.put("info", "你   好");

        String response = HttpUtil.get("http://www.tuling123.com/openapi/api", paramMap);
        System.out.println(response);
    }
}
