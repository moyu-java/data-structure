package com.junmoyu.data.structure.lru;

/**
 * LRU 算法测试
 *
 * @author moyu
 * @date 2023/3/17
 */
public class LRUTest {
    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(3);
        cache.put("name", "James");
        cache.put("code", "james2010120");
        cache.put("address", "hangzhou");

        cache.get("code");
        cache.get("name");
        cache.get("address");

        cache.put("date", "2021");
        cache.get("name");
        System.out.println(cache);
    }
}
