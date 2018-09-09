/**
 * 
 */
package lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * @description:
 * @createTime 2018年5月11日 上午10:36:16
 * @author xw
 *
 */
public class Lambda6 {
		
	public static void main(String[] args) {
		List<Integer> arr=Arrays.asList(1,5,7,1,3,5,10);
		IntSummaryStatistics statistics = arr.stream().mapToInt((x)->x).summaryStatistics();
		System.out.println(statistics);
	}

}
