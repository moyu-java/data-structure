package com.junmoyu.data.structure.stack.exception;

/**
 * 空栈异常
 *
 * @author moyu.jun
 * @date 2021/12/26
 */
public class StackEmptyException extends RuntimeException {

    public StackEmptyException(String message) {
        super(message);
    }
}
