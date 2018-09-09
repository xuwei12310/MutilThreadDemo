/**
 * 
 */
package noLock;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description:
 * @createTime 2018年4月9日 下午9:36:14
 * @author xw
 *
 */
public class TestAtomicReference {
	/**
	 * @description:
	 * @createTime 2018年4月9日 下午9:36:14
	 * @author xw
	 * @param args
	 */
	//static AtomicReference<Integer> atomicReference=new AtomicReference<Integer>(19);
	static AtomicStampedReference<Integer> atomicReference=new AtomicStampedReference<Integer>(19,0);
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			int stamp = atomicReference.getStamp();
			new Thread(){
				public void run() {
					while (true) {
						Integer a=atomicReference.getReference();
						//Integer a = atomicReference.get();
						if(a<10){
							//if(atomicReference.compareAndSet(a, a+20)){
							if(atomicReference.compareAndSet(a, a+20,stamp,stamp+1)){
							System.out.println("充值成功，当前余额:"+atomicReference.getReference());
							break;
							}
						}else{
							System.out.println("无需充值!!!");
							break;
						}
					}
				};
			}.start();
			new Thread(){
				public void run() {
					for(int i=0;i<100;i++){
						while(true){
						int stamp=atomicReference.getStamp();
						Integer a=atomicReference.getReference();
						//int a=atomicReference.get();
						if(a>10){
							if(atomicReference.compareAndSet(a, a-10,stamp,stamp+1)){
							System.out.println("消费成功，当前余额:"+atomicReference.getReference());
							break;
							}
							
						}else{
							System.out.println("余额不足");
							break;
						}
						}
					}
				};
			}.start();
		}
	}

}
