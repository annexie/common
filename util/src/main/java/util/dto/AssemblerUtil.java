package util.dto;

import com.alibaba.fastjson.JSONObject;
import com.xuliugen.common.constant.ConstPunctuation;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 数据传输对象转化为实体对象的转换工具类
 */
public class AssemblerUtil {

    /**
     * 根据查询条件组装查询URL，类似于: ?a=xx&b=xx&c=xxx
     * @param queryCondition 查询条件
     * @return
     */
    public static String assembleQueryURL(Object queryCondition) {
        return assembleQueryURL(queryCondition, ConstPunctuation.QUESTION);
    }

    /**
     * 根据查询条件组装查询URL，类似于: 前缀a=xx&b=xx&c=xxx
     * @param queryCondition 查询条件
     * @param prefix         要添加的前缀
     * @return
     */
    public static String assembleQueryURL(Object queryCondition, String prefix) {
        String json = JSONObject.toJSONString(queryCondition);
        Map<String, Object> paramKeyAndValueMap = JSONObject.parseObject(json, Map.class);
        String url = assembleByMap1Level(paramKeyAndValueMap);
        url = prefix + url;
        return url;
    }

    /**
     * 将Map组装成String,将第2层的也组装进来
     * @param paramKeyAndValueMap
     * @return
     */
    private static StringBuffer assembleByMap2Level(Map<String, Object> paramKeyAndValueMap) {
        StringBuffer urlBuffer = new StringBuffer();
        int i = 0;
        int size = paramKeyAndValueMap.entrySet().size();
        for (Map.Entry<String, Object> entry : paramKeyAndValueMap.entrySet()) {
            i++;
            String key = entry.getKey();
            Object value = entry.getValue();
            if (StringUtils.isNotBlank(key) && value != null) {
                try {
                    Map<String, Object> innerKeyValueMap = JSONObject.parseObject(value.toString(), Map.class);

                    int j = 0;
                    int innerSize = innerKeyValueMap.entrySet().size();
                    for (Map.Entry<String, Object> innerEntry : innerKeyValueMap.entrySet()) {
                        String innerKey = innerEntry.getKey();
                        Object innerValue = innerEntry.getValue();
                        if (StringUtils.isNotBlank(key) && value != null) {
                            innerKey = key + ConstPunctuation.DOT + innerKey;
                            if (j < innerSize) {
                                urlBuffer.append(innerKey + ConstPunctuation.EQUAL + innerValue + ConstPunctuation.LINK);
                            } else if (j == innerSize) {
                                urlBuffer.append(innerKey + ConstPunctuation.EQUAL + innerValue);
                            }
                        }
                    }
                } catch (Exception e) {//如果抛异常说明value不是Json字符串
                    //如果对key进行处理并且key是currentPage这个转换成page.currentPage形式
//                    key = (handleSpecialKey & key.equals("currentPage")) ? "page.currentPage" : key;
                    if (i < size) {
                        urlBuffer.append(key + ConstPunctuation.EQUAL + value + ConstPunctuation.LINK);
                    } else if (i == size) {
                        urlBuffer.append(key + ConstPunctuation.EQUAL + value);
                    }
                }
            }
        }
        return urlBuffer;
    }

    /**
     * 将Map组装成String,只组装第1层的
     * @param paramKeyAndValueMap
     * @return
     */
    private static String assembleByMap1Level(Map<String, Object> paramKeyAndValueMap) {
        String url = "";
        for (Map.Entry<String, Object> entry : paramKeyAndValueMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (StringUtils.isNotBlank(key) && value != null) {
                StringBuffer urlBuffer = new StringBuffer();
                try {
                    Map<String, Object> innerKeyValueMap = JSONObject.parseObject(value.toString(), Map.class);
                    //如果value是个Json字符串则跳过
                    continue;
                } catch (Exception e) {//如果抛异常说明value不是Json字符串
                    urlBuffer.append(key + ConstPunctuation.EQUAL + value + ConstPunctuation.LINK);
                }
                url = url + urlBuffer.toString();
            }
        }
        if (url.endsWith(ConstPunctuation.LINK)) {
            url = url.substring(0, url.length() - 1);
        }
        return url;
    }
}
