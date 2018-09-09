/**
 * 
 */
package threadApi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:倒计时器,计数器
 * @createTime 2018年4月5日 下午6:00:05
 * @author xw
 *
 */
public class TestCountDownLatch implements Runnable{
	
	static CountDownLatch latch=new CountDownLatch(10);
	static TestCountDownLatch demo=new TestCountDownLatch();
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("check complete");
			latch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService=Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			executorService.submit(demo);
		} 
		latch.await();
		System.out.println("finish");
		executorService.shutdown();
	}
	

}
