/**
 * 
 */
package noLock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @description:
 * @createTime 2018年4月10日 上午10:24:03
 * @author xw
 *
 */
public class TestAtomicIntegerField {
	public static class vote{
		int id;
		volatile int score;
	}
	public static void main(String[] args) throws InterruptedException {
		AtomicIntegerFieldUpdater<vote> atomicIntegerFieldUpdater=AtomicIntegerFieldUpdater.newUpdater(vote.class, "score");
		AtomicInteger ai=new AtomicInteger(0);
		vote vote=new vote();
		Thread [] tgroup=new Thread[10000];
		for (int i = 0; i < tgroup.length; i++) {
			tgroup[i]=new Thread(){
				@Override
				public void run() {
					if(Math.random()>0.4){
						ai.incrementAndGet();
						atomicIntegerFieldUpdater.getAndIncrement(vote);
					}
				}
			};
			tgroup[i].start();
		}
		for (int i = 0; i < tgroup.length; i++) {
			tgroup[i].join();
		}
		System.out.println("updater:"+atomicIntegerFieldUpdater.get(vote));
		System.out.println("ai:"+ai.get());
	}

}
