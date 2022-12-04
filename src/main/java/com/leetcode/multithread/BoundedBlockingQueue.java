package com.leetcode.multithread;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: drainli
 **/
public class BoundedBlockingQueue {

    AtomicInteger size = new AtomicInteger(0);
    private volatile int capacity;
    //自己实现阻塞队列，需要一个容器，内部实现了一个node，如果改造为不只是int的，使用T泛型
    private LinkedList<Integer> container;

    //可重入锁
    private static ReentrantLock lock = new ReentrantLock();
    Condition procuder = lock.newCondition();//用来通知生产（入队）线程等待await还是可以执行signal
    Condition consumer = lock.newCondition();//用来通知消费（出队）线程等待await还是可以执行signal

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        container = new LinkedList<>();
    }

    /**
     * 入队
     *
     * @param element
     * @throws InterruptedException
     */
    public void enqueue(int element) throws InterruptedException {
        //每一个线程都会获得锁，但是如果条件不满足则会阻塞
        lock.lock();
        try {
            //阻塞的话必须用循环，让这个线程再次获得cpu片段的时候能够够执行
            while (size.get() >= capacity) {
                //入队线程阻塞，把锁释放？
                procuder.await();
            }
            container.addFirst(element);
            size.incrementAndGet();

            //通知出队线程
            consumer.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (size.get() == 0) {
                consumer.await();
            }
            int lastValue = container.getLast();
            container.removeLast();
            size.decrementAndGet();

            //通知入队线程
            procuder.signal();
            return lastValue;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
       return size.get();
    }

}
