package cn.org.wyxxt.juc.c_004;

/**
 * @author xingzhiwei
 * @createBy IntelliJ IDEA
 * @time 2021/4/6 下午1:16
 * @email jsjxzw@163.com
 */

/**
 * synchronized关键字
 * 对某个对象加锁
 */

public class T {

    private static int count = 10;

    public synchronized static void m() { //这里等同于synchronized(FineCoarseLock.class)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void mm() {
        synchronized(T.class) { //考虑一下这里写synchronized(this)是否可以？
            count --;
        }
    }

}
