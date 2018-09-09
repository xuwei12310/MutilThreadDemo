/**
 * 
 */
package threadApi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @description:
 * @createTime 2018年4月5日 下午12:45:24
 * @author xw
 *
 */
public class TestReadWriteLock {
		private static Lock lock=new ReentrantLock();
		private static ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
		private static ReadLock readLock=readWriteLock.readLock();
		private static WriteLock writeLock=readWriteLock.writeLock();
		private int value;
		public int handleRead(Lock lock) throws InterruptedException{
			try {
				lock.lock();
				Thread.sleep(1000);
				return value;
			} finally {
				lock.unlock();
			}
		}
		public int handleWrite(Lock lock,int index) throws InterruptedException{
			try {
				lock.lock();
				Thread.sleep(1000);
				value=index;
				return value;
			} finally {
				lock.unlock();
			}
		}
		public static void main(String[] args) {
			TestReadWriteLock demo=new TestReadWriteLock();
			Runnable readRun=new Runnable() {
				@Override
				public void run() {
					try {
						//demo.handleRead(lock);
						int read = demo.handleRead(readLock);
						System.out.println(read);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			};
			Runnable writeRun=new Runnable() {
				@Override
				public void run() {
					try {
						//demo.handleWrite(lock, 10000);
						int handleWrite = demo.handleWrite(writeLock, 10000);
						System.out.println(handleWrite);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			for (int i = 0; i < 18; i++) {
				new Thread(readRun).start();;
			}
			for (int i = 18; i < 20; i++) {
				new Thread(writeRun).start();
			}
		}

}
