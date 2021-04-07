package cn.org.wyxxt.juc.c_006;

/**
 * @author xingzhiwei
 * @createBy IntelliJ IDEA
 * @time 2021/4/6 下午1:24
 * @email jsjxzw@163.com
 */
/**
 * 对比上面一个小程序，分析一下这个程序的输出
 * @author mashibing
 */


public class T implements Runnable {

    private int count = 10;

    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {

        for(int i=0; i<5; i++) {
            T t = new T();
            new Thread(t, "THREAD" + i).start();
        }
    }

}
