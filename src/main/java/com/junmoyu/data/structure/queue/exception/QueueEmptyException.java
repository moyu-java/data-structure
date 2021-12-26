package com.junmoyu.data.structure.queue.exception;

/**
 * 空栈异常
 *
 * @author moyu.jun
 * @date 2021/12/26
 */
public class QueueEmptyException extends RuntimeException {

    public QueueEmptyException(String message) {
        super(message);
    }
}
