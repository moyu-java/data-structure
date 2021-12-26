package com.junmoyu.data.structure.stack;

import com.junmoyu.data.structure.stack.exception.StackEmptyException;
import com.junmoyu.data.structure.stack.exception.StackFullException;

/**
 * 用数组实现的栈
 *
 * @author moyu.jun
 * @date 2021/12/26
 */
public class ArrayStack implements Stack {

    /**
     * 数组默认容量
     */
    private final static int DEFAULT_CAPACITY = 32;

    /**
     * 数组实际大小
     */
    private int capacity;

    /**
     * 对象数组
     */
    private Object[] objects;

    /**
     * 栈顶元素的位置
     */
    private int top = -1;

    /**
     * 按照默认容量创建栈
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 按照指定容量创建栈
     *
     * @param capacity 栈的容量
     */
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        objects = new Object[capacity];
    }

    @Override
    public int getSize() {
        return (top + 1);
    }

    @Override
    public boolean isEmpty() {
        return (top < 0);
    }

    @Override
    public Object top() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("栈是空的");
        }
        return objects[top];
    }

    @Override
    public void push(Object obj) throws StackFullException {
        if (capacity == (top + 1)) {
            throw new StackFullException("栈已满");
        }
        objects[++top] = obj;
    }

    @Override
    public Object pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("栈是空的");
        }
        Object object = objects[top - 1];
        objects[top--] = null;
        return object;
    }
}
