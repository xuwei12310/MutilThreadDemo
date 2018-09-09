/**
 * 
 */
package threadApi;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @createTime 2018年4月1日 上午11:17:58
 * @author xw
 *
 */
public class TestReentrantLock {

	/**
	 * @description:重入锁
	 * @createTime 2018年4月1日 上午11:17:59
	 * @author xw
	 * @param args
	 */
	static int i=0;
	static ReentrantLock lock=new ReentrantLock();
	static Runnable run =new  Runnable() {
		@Override
		public void run() {
			try{
			if(lock.tryLock()){
				for(int j=0;j<1000;j++){
					i++;
				}
			}else{
				System.out.println("get Lock fail");
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
	};
	public static void main(String[] args) throws InterruptedException {
		Thread a=new Thread(run);
		Thread b=new Thread(run);
		a.start();
		b.start();
		a.join();
		b.join();
		System.out.println(i);
	}

}
