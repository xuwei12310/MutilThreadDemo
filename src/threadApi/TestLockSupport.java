/**
 * 
 */
package threadApi;

import java.util.concurrent.locks.LockSupport;

/**
 * @description:
 * @createTime 2018年4月6日 下午1:00:54
 * @author xw
 *
 */
public class TestLockSupport {
	static Runnable run = () -> {
		System.out.println(Thread.currentThread().getName() + ":run"); 
		LockSupport.park();
		System.out.println(Thread.currentThread().getName() + "restart");
	};

	public static void main(String[] args) {
		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		t1.start();
		t2.start();
		LockSupport.unpark(t1);
		LockSupport.unpark(t2);
	}

}
