/**
 * 
 */
package threadPool;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description:测试 fixed线程池和cached线程池
 * @deprecation:
 * @createTime 2018年4月6日 下午2:27:55
 * @author xw
 *
 */
public class TestFixedAndCachedPool {
	
	static Runnable run=()->{
		System.out.println(System.currentTimeMillis()+"   Tread Id:"+Thread.currentThread().getId());
	};
	
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newFixedThreadPool(5);
		//ExecutorService executorService=Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			executorService.submit(run);
		}
		executorService.shutdown();
		//System.out.println(Runtime.getRuntime().availableProcessors());
	}
}
