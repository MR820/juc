package cn.org.wyxxt.juc.c_005;

/**
 * @author xingzhiwei
 * @createBy IntelliJ IDEA
 * @time 2021/4/6 下午1:14
 * @email jsjxzw@163.com
 *
 * 分析一下这个程序的输出
 */
public class T implements Runnable {
    private /*volatile*/ int count = 100;
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T t = new T();
        for (int i=0;i<100;i++) {
            new Thread(t,"Thread"+i).start();
        }
    }
}
