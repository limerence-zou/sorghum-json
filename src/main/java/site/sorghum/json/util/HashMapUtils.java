package site.sorghum.json.util;

import java.util.HashMap;

/**
 * @Author: Sorghum
 * @Date: 2021/3/25 15:02
 */
public class HashMapUtils {
    private final static int INIT_CAPACITY = 1<<4;
    public static <K, V> HashMap<K, V> newInstance(int cap) {
        return new HashMap<K, V>(cap);
    }

    public static <K, V> HashMap<K, V> newInstance() {
        return newInstance(INIT_CAPACITY);
    }
}
