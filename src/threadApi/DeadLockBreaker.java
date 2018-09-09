/**
 * 
 */
package threadApi;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @description:检测死锁，中断线程。需要使用reentrantLock.lockInterrput
 * @createTime 2018年7月19日 下午9:23:33
 * @author xw
 *
 */
public class DeadLockBreaker {
	
	private final static ThreadMXBean mbean=ManagementFactory.getThreadMXBean();
	
	
	public static void  check(){
		Thread check=new Thread(()->{
			while(true){
				long[] findDeadlockedThreads = mbean.findDeadlockedThreads();
				if(findDeadlockedThreads!=null){
					ThreadInfo[] threadInfo = mbean.getThreadInfo(findDeadlockedThreads);
					for(Thread t:Thread.getAllStackTraces().keySet()){
						for(int i=0;i<threadInfo.length;i++){
							if(t.getId()==threadInfo[i].getThreadId()){
								t.interrupt();
							}
						}
					}
				}
			}
		});
		check.setDaemon(true);
		check.start();
	}
}
