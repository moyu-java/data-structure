package com.junmoyu.data.structure.stack;

/**
 * @author moyu.jun
 * @date 2021/12/26
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push("James");
        arrayStack.push("Hello");
        arrayStack.push("King");
        arrayStack.push("Jo");
        arrayStack.push("Co");
        System.out.println(arrayStack.getSize());
        System.out.println(arrayStack.top());

        arrayStack.pop();
        System.out.println(arrayStack.getSize());
        System.out.println(arrayStack.top());

        arrayStack.pop();
        System.out.println(arrayStack.getSize());
        System.out.println(arrayStack.top());
    }
}
