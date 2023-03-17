package com.junmoyu.data.structure.lfu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author moyu
 * @date 2023/3/17
 */
public class LFUCacheTest {

    @Test
    public void testLFUCache() {
        LFUCache<Integer, Integer> cache = new LFUCache<>(3);

        // 添加元素
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        assertEquals(Integer.valueOf(1), cache.get(1));
        assertEquals(Integer.valueOf(2), cache.get(2));
        assertEquals(Integer.valueOf(3), cache.get(3));

        // 验证访问频率
        cache.get(1);
        cache.get(1);
        cache.get(2);
        cache.get(3);
        cache.get(3);
        cache.get(3);
        cache.get(3);

        // 添加新元素，触发淘汰（访问频率不同，淘汰频率最低的）
        cache.put(4, 4);
        assertNull(cache.get(2));
        assertEquals(Integer.valueOf(1), cache.get(1));
        assertEquals(Integer.valueOf(4), cache.get(4));

        // 验证访问频率
        cache.get(1);
        cache.get(4);
        cache.get(4);
        cache.get(4);
        cache.get(4);

        // 添加新元素，触发淘汰（访问频率相同，淘汰最早的）
        cache.put(5, 5);
        assertNull(cache.get(1));
        assertEquals(Integer.valueOf(3), cache.get(3));
        assertEquals(Integer.valueOf(4), cache.get(4));
        assertEquals(Integer.valueOf(5), cache.get(5));

        // 清空缓存
        cache.clear();
        assertNull(cache.get(1));
        assertNull(cache.get(2));
        assertNull(cache.get(3));
        assertNull(cache.get(4));
        assertNull(cache.get(5));
    }
}
