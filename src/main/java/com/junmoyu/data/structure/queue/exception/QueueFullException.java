package com.junmoyu.data.structure.queue.exception;

/**
 * 栈满异常
 *
 * @author moyu.jun
 * @date 2021/12/26
 */
public class QueueFullException extends RuntimeException {

    public QueueFullException(String message) {
        super(message);
    }
}
