/**
 * 
 */
package threadApi;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:ArrayList在多线程操作的情况下会出现意想不到的问题，所以在多线程中用线程安全的Vector
 * @createTime 2018年3月31日 下午7:27:59
 * @author xw
 *
 */
public class TestArrayList {

	/**
	 * @description:
	 * @createTime 2018年3月31日 下午7:27:59
	 * @author xw
	 * @param args
	 */
	
	static Vector<Integer> al=new Vector<>(2);
	static Runnable run=()->{
		for(int i=0;i<1000;i++){
			al.add(i);
		}
	};
	public static void main(String[] args) throws InterruptedException {
		Thread a=new Thread(run);
		a.start();
		Thread b=new Thread(run);
		b.start();
		b.join();
		a.join();
		System.out.println(al.size());
	}

}
