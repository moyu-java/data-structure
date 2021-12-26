package com.junmoyu.data.structure.queue;

import com.junmoyu.data.structure.queue.exception.QueueEmptyException;
import com.junmoyu.data.structure.queue.exception.QueueFullException;

/**
 * 使用数组实现的队列
 *
 * @author moyu.jun
 * @date 2021/12/26
 */
public class ArrayQueue implements Queue {

    /**
     * 数组默认容量
     */
    private final static int DEFAULT_CAPACITY = 8;

    /**
     * 数组实际大小
     */
    private int capacity;

    /**
     * 对象数组
     */
    private Object[] objects;

    /**
     * 队首元素的位置
     */
    private int head = 0;

    /**
     * 队尾元素的位置
     */
    private int tail = 0;

    /**
     * 按照默认容量创建栈
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 按照指定容量创建栈
     *
     * @param capacity 栈的容量
     */
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        objects = new Object[capacity];
    }

    @Override
    public int getSize() {
        int size = (capacity - head + tail) % capacity;
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (head == tail);
    }

    @Override
    public Object head() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("空队列");
        }
        return objects[head];
    }

    @Override
    public void enqueue(Object obj) throws QueueFullException {
        if (getSize() == capacity - 1) {
            // 总是空闲一个位置，避免 head = tail 但数组有值
            throw new QueueFullException("队列已满");
        }
        objects[tail] = obj;
        tail = (tail + 1) % capacity;
    }

    @Override
    public Object dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("空队列");
        }
        Object obj = objects[head];
        objects[head] = null;
        head = (head + 1) % capacity;
        return obj;
    }
}
