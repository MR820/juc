package cn.org.wyxxt.juc.c_000;

import java.util.concurrent.TimeUnit;

/**
 * @author xingzhiwei
 * @createBy IntelliJ IDEA
 * @time 2021/4/6 上午10:08
 * @email jsjxzw@163.com
 */
public class T01_WahtIsThread {
    private static class T1 extends Thread {
        @Override
        public void run() {
            for (int i=0;i<10;i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
//        new T1().run(); //不产生分支
        new T1().start(); //产生分支
        for (int i=0;i<10;i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }

}
