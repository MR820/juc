package cn.org.wyxxt.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.locks.LockSupport;

public class T01_00_Question {
    static Thread t1 = null,t2 = null;
    public static void main(String[] args) {
        //要求用线程顺序打印A1B2C3....Z26

        t1 = new Thread(() -> {
            for(char i='A';i<='Z';i++) {
                System.out.print(i);
                LockSupport.park();
                LockSupport.unpark(t2);


            }
        }, "t1");
        t2 = new Thread(() -> {
              for (int i = 1; i <= 26; i++) {
                  System.out.print(i);

                  LockSupport.unpark(t1);
                  LockSupport.park();
              }
            }, "t2");
        t1.start();
        t2.start();
    }
}
