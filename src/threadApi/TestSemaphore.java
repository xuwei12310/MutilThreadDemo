/**
 * 
 */
package threadApi;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @description:
 * @createTime 2018年4月1日 下午5:50:49
 * @author xw
 *
 */
public class TestSemaphore {
	static Semaphore semaphore=new Semaphore(10);
	static Runnable run=new Runnable() {
	public int i=0;
		@Override
		public void run() {
			try {
				semaphore.acquire();
				Thread.sleep(2000);
				i++;
				System.out.println(LocalTime.now());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				System.out.println(i);
				semaphore.release();
			}
		}
	};
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(20);
		for (int i = 0; i < 20; i++) {
			es.submit(run);
		}
		es.shutdown();
	}

}
