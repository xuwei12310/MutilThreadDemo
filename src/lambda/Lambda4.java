/**
 * 
 */
package lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @description:使用map操作
 * @createTime 2018年5月7日 下午4:24:39
 * @author xw
 *
 */
public class Lambda4 {
	
	public static void main(String[] args) {
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		/*for (Integer cost : costBeforeTax) {
			 double price = cost + 0.12*cost;
			    System.out.println(price);
		}*/
		costBeforeTax.stream().map((cost)->cost+0.12*cost).forEach((cost)->System.out.println(cost));
		double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
		System.out.println("Total : " + bill);
	}
}
