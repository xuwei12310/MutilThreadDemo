/**
 * 
 */
package test;

/**
 * @description:
 * @createTime 2018年3月26日 上午8:43:24
 * @copyright 福建骏华有限公司（c）2017
 * @author xw
 *
 */
public class ObjectService {  
	String lock=new String();
    public synchronized void  objectMethodA() throws InterruptedException{  
    	/*synchronized (lock) {
		}*/
    	System.out.println("run----objectMethodA");
    	System.out.println("run2----objectMethodA");
    	System.out.println("run3----objectMethodA");
    }  
    public void objectMethodB(){  
        synchronized (this) {  
            try {  
                for (int i = 1; i <= 10; i++) {  	
                    System.out.println("synchronized thread name:"+Thread.currentThread().getName()+"-->i="+i);  
                    this.wait();
                }  
            } catch (InterruptedException e) {  	
                    e.printStackTrace();  
            }  
        }  
    }  
}  