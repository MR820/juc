package cn.org.wyxxt.juc.c_018_01_unsafe;

/**
 * @author xingzhiwei
 * @createBy IntelliJ IDEA
 * @time 2021/4/9 下午3:32
 * @email jsjxzw@163.com
 */

//import sun.misc.*;

import sun.misc.Unsafe;

public class HelloUnsafe {
    static class M {
        private M() {}

        int i =0;
    }

    public static void main(String[] args) throws InstantiationException {
        Unsafe unsafe = Unsafe.getUnsafe();
        M m = (M)unsafe.allocateInstance(M.class);
        m.i = 9;
        System.out.println(m.i);
    }
}
