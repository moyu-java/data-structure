package com.junmoyu.data.structure.linked;

/**
 * @author moyu.jun
 * @date 2021/12/26
 */
public class Node implements Position {
    /**
     * 数据对象
     */
    private Object element;

    /**
     * 数据对象
     */
    private Node next;

    public Node() {
        this(null, null);
    }

    public Node(Object element, Node next) {
        this.element = element;
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public Object setElement(Object element) {
        Object oldElement = this.element;
        this.element = element;
        return oldElement;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
