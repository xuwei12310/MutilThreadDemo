/**
 * 
 */
package threadApi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:重入锁之Condition
 * @createTime 2018年4月1日 下午1:47:48
 * @author xw
 *
 */
public class TestReentrantLock2 {
	static ReentrantLock rl=new ReentrantLock();
	static Condition condition=rl.newCondition();
	static Runnable run=new Runnable() {
		
		@Override
		 public void run() {
			rl.lock();
			System.out.println("获得锁");
			try {
				condition.await();
				System.out.println("唤醒了");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				System.out.println("结束释放锁");
				rl.unlock();
			}
		}
	};
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread a=new Thread(run);
		a.start();
		System.out.println("进入睡眠");
		Thread.sleep(1000);
		rl.lock();
		try {
			condition.signal();
			System.out.println("唤醒");
		} finally {
			rl.unlock();
		}
	}

}
