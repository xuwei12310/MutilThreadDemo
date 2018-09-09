/**
 * 
 */
package threadPool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @createTime 2018年4月8日 上午11:38:34
 * @author xw
 *
 */
public class TestLocalThread {

	/**
	 * @description:使用LocalThread代替加锁操作
	 * @createTime 2018年4月8日 上午11:38:34
	 * @author xw
	 * @param args
	 */
	static ThreadLocal<SimpleDateFormat> tl=new ThreadLocal<SimpleDateFormat>();
	static int i=0;
	static class ThreadLocalDemo  implements Runnable{
		int i=0;
		public ThreadLocalDemo(int i) {
			this.i=i;
		}
		@Override
		public void run() {
			System.out.println("before:"+tl.get());
			if(tl.get()==null){
				tl.set(new SimpleDateFormat("YYYY-MM-dd hh:mm:ss"));
			}
			System.out.println("after:"+tl.get());
			try {
				Date t=tl.get().parse("2011-11-11 11:11:"+i);
				System.out.println(i+":"+t);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newFixedThreadPool(10);
		for (int j = 0; j < 10; j++) {
			executorService.submit(new ThreadLocalDemo(j));
		}
		executorService.shutdown();
		
	}

}
