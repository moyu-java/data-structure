package com.junmoyu.data.structure.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU 算法 Java 实现
 *
 * @author moyu
 * @date 2023/3/17
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    /**
     * 当缓存的元素数量超过了指定的容量时，删除最久未被访问的元素。
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
