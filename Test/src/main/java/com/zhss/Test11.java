package com.zhss;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date: 2021/7/28 15:01
 * @Desc:
 */
public class Test11 {
    public static final int PUBLIC = 0x00000001;

    public static void main(String[] args) throws Exception {


        System.out.println(PUBLIC);

        /**
         * 15:05:35
         * AQS支持可以被打断的锁, 如: ReentrantLock#lockInterruptibly
         * 由于线程被park挂起, 再被interrupte 唤醒后, 不会清除interrupted flag, 也不会抛异常异常.
         * AbstractQueuedSynchronizer#parkAndCheckInterrupt
         * 在该逻辑中, unpark后, 需要手动清除interrupted flag, 后续再抛出InterruptedException
         * 对于不支持打断的锁, 则由于unpark手动清除了flag, 则需要再selfInterrupt()
         *
         *  15:31:49
         *   lockInterruptibly 中会清楚标记 并抛出异常吧
         * parkAndCheckInterrupt是给lockInterruptibly用的     但是因为公用了acquire中不相应中断，所以要被还原
         *  15:32:05
         * lockInterruptibly 中逻辑是  重置状态 返回中断状态   并抛出InterruptedException  这个逻辑是合理的   到了acquire中就不太合适，因为不会响应中断，所以要在外层设置成中断状态
         * -- -------
         * ReentrantLock reentrantLock = new ReentrantLock()
         * reentrantLock.lockInterruptibly()方法，支持打断
         * ：被中断unPark的时候，unPark会清除中断标志位，并抛出异常
         *
         * reentrantLock.lock()方法，不支持打断
         * ：因为在被中断的时候，unPark会清除中断标志位,所以，需要重新设置中断标志位，acquire() -> selfInterrupt()
         *   没有抛异常
         *
         * lockInterruptibly 和 lock()公用了 parkAndCheckInterrupt()，parkAndCheckInterrupt()设置了中断标志位为true
         *   unPark的时候，会清除中断标志位
         *
         */

        ReentrantLock reentrantLock = new ReentrantLock();

        try {

            reentrantLock.lock();

            reentrantLock.lockInterruptibly();
        } catch (Exception e) {
            throw new Exception();
        } finally {
            reentrantLock.unlock();
        }
    }
}
