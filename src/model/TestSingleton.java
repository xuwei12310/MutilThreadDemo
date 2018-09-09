/**
 * 
 */
package model;

/**
 * @description:
 * @createTime 2018年4月10日 上午11:33:47
 * @author xw
 *
 */
public class TestSingleton {
		public static int i=0;
		private TestSingleton(){
			System.out.println("create");
		}
		private static class SingletonFactory{
			private static TestSingleton s=new TestSingleton();
		}
		public TestSingleton getInstance(){
			return  SingletonFactory.s;
		}
		
		public static void main(String[] args) {
			TestSingleton a=new TestSingleton();
			a.getInstance();
			a.getInstance();
			i=1;
			//i=1;
		}
}
