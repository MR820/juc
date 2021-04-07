package cn.org.wyxxt.juc.c_000;

/**
 * @author xingzhiwei
 * @createBy IntelliJ IDEA
 * @time 2021/4/6 上午10:49
 * @email jsjxzw@163.com
 */
public class T03_Sleep_Yield_Join {
    public static void main(String[] args) {
//        testSleep();
//        testYield();
        testJoin();
    }

    static void testSleep() {
    new Thread(
            () -> {
              for (int i = 0; i < 100; i++) {
                  System.out.println("T"+i);
                  try{
                      Thread.sleep(500);
                  }catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
            })
        .start();
    }

    static void testYield() {
        //必须要是单核情况
        new Thread(
            () -> {
              for (int i = 0; i < 100; i++) {
                System.out.println("A"+i);
                if (i%10==0) Thread.yield();
              }
            })
        .start();
        new Thread(
            () -> {
              for (int i = 0; i < 100; i++) {
                System.out.println("------B"+i);
                if (i%10==0) Thread.yield();
              }
            })
        .start();
    }

    static void testJoin() {
        Thread t1=new Thread(()->{
            for (int i=0;i<100;i++) {
                System.out.println("C"+i);
                try{
                    Thread.sleep(1);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(
            () -> {
              try {
                t1.join();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
                System.out.println("t2 over");
            });
        t1.start();
        t2.start();
    }
}
