/**
 * 
 */
package threadApi;

/**
 * @description:测试线程优先级
 * @createTime 2018年3月29日 下午9:52:59
 * @author xw
 *
 */
public class TestPriority {
	
	static Runnable run=()->{
		for(int i=0;i<100;i++)
			System.out.println(Thread.currentThread().getName()+i);
	};
	
	/**
	 * @description:
	 * @createTime 2018年3月29日 下午9:52:59
	 * @author xw
	 * @param args
	 */
	public static void main(String[] args) {
		Thread a=new Thread(run);
		Thread b=new Thread(run);
		a.setName("a");
		b.setName("b");
		a.setPriority(Thread.MIN_PRIORITY);
		b.setPriority(Thread.MAX_PRIORITY);
		a.start();
		b.start();
	}

}
