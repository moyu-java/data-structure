package com.junmoyu.data.structure.stack;

import com.junmoyu.data.structure.stack.exception.StackEmptyException;
import com.junmoyu.data.structure.stack.exception.StackFullException;

/**
 * 栈接口定义
 *
 * @author moyu.jun
 * @date 2021/12/26
 */
public interface Stack {

    /**
     * 获取栈的大小
     *
     * @return 栈的大小
     */
    int getSize();

    /**
     * 判断栈是否为空
     *
     * @return true: 空栈; false: 非空栈
     */
    boolean isEmpty();

    /**
     * 获取栈顶元素，但不删除
     *
     * @return 栈顶元素
     * @throws StackEmptyException 空栈异常
     */
    Object top() throws StackEmptyException;

    /**
     * 向栈中添加元素
     *
     * @param obj 元素
     * @throws StackFullException 栈满异常
     */
    void push(Object obj) throws StackFullException;

    /**
     * 弹出栈顶元素
     *
     * @return 栈顶元素
     * @throws StackEmptyException 空栈异常
     */
    Object pop() throws StackEmptyException;
}
