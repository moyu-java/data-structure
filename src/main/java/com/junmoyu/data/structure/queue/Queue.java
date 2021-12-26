package com.junmoyu.data.structure.queue;

import com.junmoyu.data.structure.queue.exception.QueueEmptyException;
import com.junmoyu.data.structure.queue.exception.QueueFullException;

/**
 * 队列的接口定义
 *
 * @author moyu.jun
 * @date 2021/12/26
 */
public interface Queue {

    /**
     * 获取队列的大小
     *
     * @return 队列的大小
     */
    int getSize();

    /**
     * 判断队列是否为空
     *
     * @return true: 空队列; false: 非空队列
     */
    boolean isEmpty();

    /**
     * 获取队列首部元素，但不删除
     *
     * @return 队列首部元素
     * @throws QueueEmptyException 空队列异常
     */
    Object head() throws QueueEmptyException;

    /**
     * 入队
     *
     * @param obj 元素
     * @throws QueueFullException 队列满异常
     */
    void enqueue(Object obj) throws QueueFullException;

    /**
     * 出队
     *
     * @return 队列顶元素
     * @throws QueueEmptyException 空队列异常
     */
    Object dequeue() throws QueueEmptyException;
}
