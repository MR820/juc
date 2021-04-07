package cn.org.wyxxt.juc.c_002;

/**
 * @author xingzhiwei
 * @createBy IntelliJ IDEA
 * @time 2021/4/6 下午1:10
 * @email jsjxzw@163.com
 */
public class T {

    private int count = 10;

    public void m() {
        synchronized(this) { //任何线程要执行下面的代码，必须先拿到this的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

}
