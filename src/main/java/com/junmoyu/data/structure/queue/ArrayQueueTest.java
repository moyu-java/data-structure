package com.junmoyu.data.structure.queue;

/**
 * @author moyu.jun
 * @date 2021/12/26
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(4);
        arrayQueue.enqueue(1);
        System.out.println("size: " + arrayQueue.getSize());
        System.out.println("head: " + arrayQueue.head());
        arrayQueue.enqueue(2);
        System.out.println("size: " + arrayQueue.getSize());
        System.out.println("head: " + arrayQueue.head());
        arrayQueue.enqueue(3);
        System.out.println("size: " + arrayQueue.getSize());
        System.out.println("head: " + arrayQueue.head());

        arrayQueue.dequeue();
        System.out.println("size: " + arrayQueue.getSize());
        System.out.println("head: " + arrayQueue.head());
        arrayQueue.dequeue();
        System.out.println("size: " + arrayQueue.getSize());
        System.out.println("head: " + arrayQueue.head());


        arrayQueue.enqueue(5);
        System.out.println("size: " + arrayQueue.getSize());
        System.out.println("head: " + arrayQueue.head());
        arrayQueue.enqueue(6);
        System.out.println("size: " + arrayQueue.getSize());
        System.out.println("head: " + arrayQueue.head());


        arrayQueue.dequeue();
        System.out.println("size: " + arrayQueue.getSize());
        System.out.println("head: " + arrayQueue.head());

        arrayQueue.enqueue(7);
        System.out.println("size: " + arrayQueue.getSize());
        System.out.println("head: " + arrayQueue.head());
    }
}
