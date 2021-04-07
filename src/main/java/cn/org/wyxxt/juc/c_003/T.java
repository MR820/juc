package cn.org.wyxxt.juc.c_003;

/**
 * @author xingzhiwei
 * @createBy IntelliJ IDEA
 * @time 2021/4/6 下午1:11
 * @email jsjxzw@163.com
 */
public class T {
    private int count = 10;

    public synchronized void m() { //等同于在方法的代码执行时，要 synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
