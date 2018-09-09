/**
 * 
 */
package threadApi;

import java.util.ArrayList;

/**
 * @description:
 * @createTime 2018年3月28日 下午8:58:01
 * @author xw
 *
 */
public class TestJoin {

	/**
	 * @description:
	 * @createTime 2018年3月28日 下午8:58:01
	 * @author xw
	 * @param args
	 */
	static int i=0;
	public static void main(String[] args) throws InterruptedException {
		Runnable run=()->{
			for(i=0;i<1000;i++){
				System.out.println();
			}
		};
		Thread a=new Thread(run);
		a.start();
		for(int j=0;i<100;j++){
			System.out.println(i);
		}
		a.join();
		System.out.println(i);
		
	}

}
