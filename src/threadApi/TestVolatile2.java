/**
 * 
 */
package threadApi;

/**
 * @description:
 * @createTime 2018年3月29日 上午9:13:31
 * @author xw
 *
 */
public class TestVolatile2 {

	/**
	 * @description:
	 * @createTime 2018年3月29日 上午9:13:31
	 * @author xw
	 * @param args
	 */
	static boolean isTrue=true;
	static int i=1;
	public static void main(String[] args) throws InterruptedException {
		
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(isTrue){
					System.out.println(i);
				}
			}
		});
		t.start();
		Thread.sleep(50);
		i=2;
		isTrue=false;
		Thread.sleep(100);
		
	}

}
