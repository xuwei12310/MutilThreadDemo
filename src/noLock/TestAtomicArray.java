/**
 * 
 */
package noLock;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @description:
 * @createTime 2018年4月10日 上午9:40:15
 * @author xw
 *
 */
public class TestAtomicArray {
	static AtomicIntegerArray array=new AtomicIntegerArray(10);
	static Runnable run=()->{
		for (int i = 0; i < 10000; i++) {
			array.getAndIncrement(i%array.length());
		}
	};
	public static void main(String[] args) {
		
		ExecutorService executorService=Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			executorService.submit(run);
		}
		executorService.shutdown();
		while (true) {
			if(executorService.isTerminated()){
				
				for (int i = 0; i < array.length(); i++) {
					System.out.println(array.get(i));
				}
				break;
			}
		}
	}

}
