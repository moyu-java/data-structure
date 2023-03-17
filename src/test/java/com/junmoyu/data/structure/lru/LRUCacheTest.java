package com.junmoyu.data.structure.lru;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author moyu
 * @date 2023/3/17
 */
public class LRUCacheTest {
    @Test
    void testLRUCache() {
        LRUCache<String, Integer> cache = new LRUCache<>(3);

        // 测试插入元素并获取元素值
        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);
        assertEquals(1, cache.get("A"));
        assertEquals(2, cache.get("B"));
        assertEquals(3, cache.get("C"));

        // 测试容量超限后淘汰最早插入的元素
        cache.put("D", 4);
        assertNull(cache.get("A"));
        assertEquals(2, cache.get("B"));
        assertEquals(3, cache.get("C"));
        assertEquals(4, cache.get("D"));

        // 测试更新元素值后访问时间更新
        cache.put("B", 20);
        cache.put("E", 5);
        assertEquals(3, cache.size());
        assertNull(cache.get("C"));
        assertEquals(20, cache.get("B"));
        assertEquals(4, cache.get("D"));
        assertEquals(5, cache.get("E"));
    }
}
