/**
 * 
 */
package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @createTime 2018年4月6日 下午2:40:07
 * @author xw
 *
 */
public class TestThredSchedule {
	
	static Runnable run=()->{
		System.out.println(System.currentTimeMillis()+"   Tread Id:"+Thread.currentThread().getId());
	};
	public static void main(String[] args) {
		ScheduledExecutorService executorService=Executors.newScheduledThreadPool(5);
		//executorService.schedule(run, 2, TimeUnit.SECONDS);
		//rate和delay的区别在于rate会检查上一个线程是否完成再继续执行下一个下次而delay不会
		executorService.scheduleAtFixedRate(run, 0, 2, TimeUnit.SECONDS);
		//executorService.scheduleWithFixedDelay(run, 0, 2, TimeUnit.SECONDS);
	}
}
