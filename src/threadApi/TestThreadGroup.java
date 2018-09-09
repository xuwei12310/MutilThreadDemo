/**
 * 
 */
package threadApi;

/**
 * @description:
 * @createTime 2018年3月29日 上午11:32:15
 * @author xw
 *
 */
public class TestThreadGroup {
	
	static Runnable run=()->{
		String name=Thread.currentThread().getThreadGroup().getName()+"---"+Thread.currentThread().getName();
		System.out.println(name);
	};
	public static void main(String[] args) {
		
		ThreadGroup group=new ThreadGroup("group");
		Thread a=new Thread(group,run,"a");
		Thread b=new Thread(group,run,"a");
		a.start();
		b.start();
		System.out.println(group.activeCount());
		group.list();
		
	}
	

}
