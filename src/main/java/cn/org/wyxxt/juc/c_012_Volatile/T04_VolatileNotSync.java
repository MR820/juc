package cn.org.wyxxt.juc.c_012_Volatile;

/**
 * @author xingzhiwei
 * @createBy IntelliJ IDEA
 * @time 2021/4/7 上午9:51
 * @email jsjxzw@163.com
 */

/**
 * volatile并不能保证多个线程共同修改running变量时所带来的不一致问题，也就是说volatile不能替代synchronized
 * 运行下面的程序，并分析结果
 * @author mashibing
 */

import java.util.ArrayList;
import java.util.List;

public class T04_VolatileNotSync {
    volatile int count = 0;
    /*synchronized*/ void m() {
        for(int i=0; i<10000; i++) count++;
    }

    public static void main(String[] args) {
        T04_VolatileNotSync t = new T04_VolatileNotSync();

        List<Thread> threads = new ArrayList<Thread>();

        for(int i=0; i<10; i++) {
            threads.add(new Thread(t::m, "thread-"+i));
        }

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);


    }

}
