package com.junmoyu.data.structure.lfu;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LFU 算法 Java 实现
 *
 * @author moyu
 * @date 2023/3/17
 */
public class LFUCache<K, V> {
    /**
     * 缓存容量
     */
    private final int capacity;

    /**
     * 存储键值对和对应的访问频率
     */
    private final Map<K, Node<K, V>> cacheMap;

    /**
     * 存储访问频率
     */
    private final PriorityQueue<Node<K, V>> priorityQueue;
    private int size;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>(capacity);
        this.priorityQueue = new PriorityQueue<>(capacity, Comparator.comparingInt((Node<K, V> node) -> node.getFrequency()).thenComparingDouble(Node::getTimestamp));
    }

    public void put(K key, V value) {
        if (capacity <= 0) {
            return;
        }
        if (cacheMap.containsKey(key)) {
            Node<K, V> node = cacheMap.get(key);
            node.setValue(value);
            node.increaseFrequency();
            priorityQueue.remove(node);
            priorityQueue.offer(node);
        } else {
            if (size == capacity) {
                evict();
            }
            Node<K, V> node = new Node<>(key, value);
            cacheMap.put(key, node);
            priorityQueue.offer(node);
            size++;
        }
    }

    public V get(K key) {
        Node<K, V> node = cacheMap.get(key);
        if (node == null) {
            return null;
        }
        node.increaseFrequency();
        priorityQueue.remove(node);
        priorityQueue.offer(node);
        return node.getValue();
    }

    public void clear(){
        cacheMap.clear();
        priorityQueue.clear();
        size = 0;
    }

    /**
     * 缓存容量满时淘汰访问频率最低且最早的值
     */
    private void evict() {
        Node<K, V> node = priorityQueue.poll();
        if (node != null) {
            cacheMap.remove(node.getKey());
            size--;
        }
    }

    private static class Node<K, V> {
        private final K key;
        private V value;
        private int frequency;
        private final long timestamp;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
            this.timestamp = System.nanoTime();
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public int getFrequency() {
            return frequency;
        }

        public void increaseFrequency() {
            this.frequency++;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }
}