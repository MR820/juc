/**
 * copy on write
 */
package cn.org.wyxxt.juc.c_025;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class T02_CopyOnWriteList {
	public static void main(String[] args) {
		List<String> lists = 
				//new ArrayList<>(); //这个会出并发问题！！！
				//new Vector();
				new CopyOnWriteArrayList<>(); // 写时复制   读特别多，写特别少时。使用
		Random r = new Random();
		Thread[] ths = new Thread[100];
		Thread[] rths = new Thread[100];
		
		for(int i=0; i<ths.length; i++) {
			Runnable task = new Runnable() {
	
				@Override
				public void run() {
					for(int i=0; i<1000; i++) lists.add("a" + r.nextInt(10000));
				}
				
			};
			ths[i] = new Thread(task);

			Runnable t = new Runnable() {
				@Override
				public void run() {
					for (int j=0;j<100000;j++) {
						lists.get(j);
					}
				}
			};
			rths[i] = new Thread(t);
		}


		
		runAndComputeTime(ths,rths);
		
		System.out.println(lists.size());
	}
	
	static void runAndComputeTime(Thread[] ths,Thread[] rths) {
		long s1 = System.currentTimeMillis();
		Arrays.asList(ths).forEach(t->t.start());
		Arrays.asList(rths).forEach(t->t.start());
		Arrays.asList(rths).forEach(t-> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Arrays.asList(ths).forEach(t->{
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		long s2 = System.currentTimeMillis();
		System.out.println(s2 - s1);


		long start = System.currentTimeMillis();
		Arrays.asList(rths).forEach(t->t.start());
		Arrays.asList(rths).forEach(t-> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		long end = System.currentTimeMillis();
    	System.out.println(end-start);
	}
}

