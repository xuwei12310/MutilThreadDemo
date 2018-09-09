/**
 * 
 */
package threadApi;

/**
 * @description:
 * @createTime 2018年3月28日 下午10:20:41
 * @author xw
 *
 */
public class TestVolatile {
	static volatile int k=0;
	static String lock=new String();
	static Runnable run=()->{
		for(int i=0;i<1000;i++){
			k++;

		}
	};
	public static void main(String[] args) throws InterruptedException {
		for(int j=0;j<10;j++){
			Thread t=new Thread(run);
			t.start();
			t.join();
		}
		//Thread.s
		synchronized (lock) {
			
			System.out.println(k);
		}
	}
}
