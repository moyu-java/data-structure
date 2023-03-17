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

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
