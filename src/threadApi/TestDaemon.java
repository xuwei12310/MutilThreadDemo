/**
 * 
 */
package threadApi;

/**
 * @description:守护线程会在所有用户线程执行完毕后自动结束
 * @createTime 2018年3月29日 下午2:03:40
 * @author xw
 *
 */
public class TestDaemon {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					System.out.println(11);
				}
			}
		});
		t.setDaemon(true);
		t.start();
		Thread.sleep(100);
	}
}
