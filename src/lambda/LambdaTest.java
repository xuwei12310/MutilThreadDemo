/**
 * 
 */
package lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:lambda对列表迭代
 * @createTime 2018年5月3日 下午4:29:29
 * @author xw
 *
 */
public class LambdaTest {
	public static void main(String[] args) {
		List<Integer> a=new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			a.add(i);
		}
		a.add(Integer.MAX_VALUE);
		a.forEach(i->System.out.println(i));
		//a.forEach(System.out::println);
	}
	
}
