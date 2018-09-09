/**
 * 
 */
package threadApi;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description:循环栅栏
 * @createTime 2018年7月23日 下午8:25:09
 * @author xw
 *
 */
public class TestCyclicBarrier {
	public static CyclicBarrier cb=new CyclicBarrier(10, ()->{System.out.println("集合完毕");});
	/**
	 * @description:
	 * @createTime 2018年7月23日 下午8:25:09
	 * @author xw
	 * @param args
	 */
	
	public static void main(String[] args) {
		Runnable run=()->{
			System.out.println("过来集合");
			try {
				cb.await();
				System.out.println("开始整队");
				cb.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		};
	
	//Thread [] threads=new Thread[10];
	for(int i=0;i<10;i++){
		//threads[i]=new Thread(run);
		new Thread(run).start();
	}
	}
}
