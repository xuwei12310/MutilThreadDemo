/**
 * 
 */
package test;

/**
 * @description:
 * @createTime 2018年3月26日 上午8:43:42
 * @copyright 福建骏华有限公司（c）2017
 * @author xw
 *
 */
public class ThreadA extends Thread {  
    private ObjectService objectService;  
  
    public ThreadA(ObjectService objectService) {  
        super();  
        this.objectService = objectService;  
    }  
    @Override  
    public void run() {  
        super.run();  
        try {
			objectService.objectMethodA();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }  
}  
