/**
 * 
 */
package noLock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @createTime 2018年4月8日 下午10:22:45
 * @author xw
 *
 */
public class TestAtomicInteger {
	static AtomicInteger ai=new AtomicInteger();
	public static class AddThread implements Runnable{
		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				ai.incrementAndGet();
			}
		}
		public static void main(String[] args) throws InterruptedException {
			Thread [] t=new Thread[10];
			for (int i = 0; i < 10; i++) {
				t[i]=new Thread(new AddThread());
			}
			for (int i = 0; i < 10; i++) {
				t[i].start();
			}
			for (int i = 0; i < 10; i++) {
				t[i].join();
			}
			System.out.println(ai);
		}
	}

}
