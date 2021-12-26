package com.junmoyu.data.structure.stack.exception;

/**
 * 栈满异常
 *
 * @author moyu.jun
 * @date 2021/12/26
 */
public class StackFullException extends RuntimeException {

    public StackFullException(String message) {
        super(message);
    }
}
