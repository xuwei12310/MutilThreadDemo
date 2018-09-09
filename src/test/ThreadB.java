/**
 * 
 */
package test;

/**
 * @description:
 * @createTime 2018年3月26日 上午8:44:43
 * @author xw
 *
 */
public class ThreadB extends Thread {  
    private ObjectService objectService;  
  
    public ThreadB(ObjectService objectService) {  
        super();  
        this.objectService = objectService;  
    }  
    @Override  
    public void run() {  
        super.run();  
        objectService.objectMethodB();  
    }  
}  
