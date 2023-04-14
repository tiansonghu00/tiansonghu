package com.jining.utils;

import lombok.SneakyThrows;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName CustomLinkedBlockingQueue
 * @Author Goslly
 * @Date 2022/11/6 11:14
 * @Description
 */
public class CustomLinkedBlockingQueue<T> extends LinkedBlockingQueue<T> {
    public CustomLinkedBlockingQueue(int capacity) {
        super(capacity);
    }

    public CustomLinkedBlockingQueue() {
        super();
    }

    @SneakyThrows
    @Override
    public boolean offer(T t) {
        super.put(t);
        return true;
    }
}
