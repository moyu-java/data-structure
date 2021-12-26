package com.junmoyu.data.structure.stack;

import com.junmoyu.data.structure.linked.Node;
import com.junmoyu.data.structure.stack.exception.StackEmptyException;
import com.junmoyu.data.structure.stack.exception.StackFullException;

/**
 * @author moyu.jun
 * @date 2021/12/26
 */
public class LinkedStack implements Stack {

    private Node top;

    /**
     * 栈中元素的数量
     */
    private int size;

    public LinkedStack() {
        this.top = null;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public Object top() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("空栈");
        }
        return top.getElement();
    }

    @Override
    public void push(Object obj) {
        top = new Node(obj, top);
        size++;
    }

    @Override
    public Object pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("空栈");
        }
        Object element = top.getElement();
        top = top.getNext();
        size--;
        return element;
    }
}
