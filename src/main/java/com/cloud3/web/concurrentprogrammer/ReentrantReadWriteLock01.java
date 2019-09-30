package com.cloud3.web.concurrentprogrammer;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: HeYongLiu
 * @create: 09-16-2019
 * @description:
 **/
public class ReentrantReadWriteLock01 {

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {

        final ReentrantReadWriteLock01 ReentrantReadWriteLock01 = new ReentrantReadWriteLock01();

        new Thread() {
            @Override
            public void run() {
                ReentrantReadWriteLock01.get(Thread.currentThread());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                ReentrantReadWriteLock01.get(Thread.currentThread());
            }
        }.start();

    }

    public void get(Thread thread) {
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();

            while (System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "读操作完毕");
        } finally {
            rwl.readLock().unlock();
        }
    }

}
