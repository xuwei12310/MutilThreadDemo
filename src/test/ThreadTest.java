/**
 * 
 */
package test;

/**
 * @description:
 * @createTime 2018年3月26日 上午8:42:35
 * @author xw
 *
 */
public class ThreadTest {
	
	/**
	 * @description:
	 * @createTime 2018年3月26日 上午8:42:35
	 * @author xw
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		/* ObjectService service=new ObjectService();  
		 ObjectService service2=new ObjectService();  
	        new Thread(()->{
	        	synchronized (service) {
	        		System.out.println("run----objectMethodA");
        	    	System.out.println("run2----objectMethodA");
        	    	System.out.println("run3----objectMethodA");
				}
	        }).start();
	        new Thread(()->{
	        	synchronized (service2) {
	        		 for (int i = 1; i <= 10; i++) {  	
	                     System.out.println("thread name:"+Thread.currentThread().getName()+"-->i="+i);  
	                     try {
							service2.wait();
						} catch (Exception e) {
							e.printStackTrace();
						}
	                 }  
				}
	        }).start();
	        Thread.sleep(1000);
	        synchronized(service2){
	        	service2.notify();
	        }*/
		
		
		Object monitor = new Object();
		Object monitor2 = new Object();
		Runnable run = () -> {
			synchronized (monitor) {
				try {
					monitor.wait();
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Runnable run2=new Runnable() {
			
			@Override
			public void run() {
				synchronized (monitor2) {
					try {
						monitor2.wait(1);
						System.out.println(Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
		new Thread(run).start();
		new Thread(run).start();
		Thread t1=new Thread(run2);
		t1.setName("t1");
		t1.start();
		new Thread(run).start();
		new Thread(run).start();
		new Thread(run).start();
		new Thread(run).start();
		new Thread(run).start();
		new Thread(run).start();
		Thread.sleep(1000);
		synchronized (monitor) {
			monitor.notifyAll();
		}
		int a=1/0;
		/*synchronized (monitor2) {
			monitor2.notify();
		}*/
	}


}
