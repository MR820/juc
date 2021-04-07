package cn.org.wyxxt.juc.c_001;

/**
 * @author xingzhiwei
 * @createBy IntelliJ IDEA
 * @time 2021/4/6 上午11:51
 * @email jsjxzw@163.com
 */

/**
 * synchronized关键字
 * 对某个对象加锁
 */
public class T {
    private int count = 10;
    private Object o = new Object();

    public void m() {
        synchronized(o) { //任何线程要执行下面的代码，必须先拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

}
