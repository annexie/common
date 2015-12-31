package util;

import org.apache.commons.collections.CollectionUtils;

import java.util.*;

public class MapUtil<T> {

    private MapUtil() {
    }

    private static class MapUtilHolder {
        private static MapUtil instance = new MapUtil();
    }

    public static MapUtil getInstance() {
        return MapUtilHolder.instance;
    }

    /**
     * 构建多值Map
     * @param multiSetValueMap
     * @param key
     * @param value
     * @return
     */
    public Map<Object, Set<T>> buildMultiSetValueMap(Map<Object, Set<T>> multiSetValueMap, Object key, T value) {
        Set<T> valueSet = multiSetValueMap.get(key);
        if (CollectionUtils.isEmpty(valueSet)) {
            Set<T> valueSetNew = new HashSet<T>();
            valueSetNew.add(value);
            multiSetValueMap.put(key, valueSetNew);
        } else {
            valueSet.add(value);
        }
        return multiSetValueMap;
    }

    /**
     * 构建多值Map
     * @param multiListValueMap
     * @param key
     * @param value
     * @return
     */
    public Map<Object, List<T>> buildMultiListValueMap(Map<Object, List<T>> multiListValueMap, Object key, T value) {
        List<T> valueSet = multiListValueMap.get(key);
        if (CollectionUtils.isEmpty(valueSet)) {
            List<T> valueSetNew = new ArrayList<T>();
            valueSetNew.add(value);
            multiListValueMap.put(key, valueSetNew);
        } else {
            valueSet.add(value);
        }
        return multiListValueMap;
    }

}
