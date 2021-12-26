package com.junmoyu.data.structure.queue;

import com.junmoyu.data.structure.linked.Node;
import com.junmoyu.data.structure.queue.exception.QueueEmptyException;
import com.junmoyu.data.structure.queue.exception.QueueFullException;

/**
 * @author moyu.jun
 * @date 2021/12/26
 */
public class LinkedQueue implements Queue {

    private Node head;

    private Node tail;

    private int size;

    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (0 == size);
    }

    @Override
    public Object head() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("空队列");
        }
        return head.getElement();
    }

    @Override
    public void enqueue(Object obj) {
        // 新节点作为末节点插入
        Node node = new Node(obj, null);
        if (isEmpty()) {
            // 若此前队列为空，则直接插入
            head = node;
        } else {
            // 否则，将新节点接至队列末端
            tail.setNext(node);
        }
        // 更新指向末节点引用
        tail = node;
        size++;
    }

    @Override
    public Object dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("空队列");
        }
        Object element = head.getElement();
        head = head.getNext();
        size--;
        if (isEmpty()) {
            // 如果队列已空，须将末节点引用置空
            tail = null;
        }
        return element;
    }
}
