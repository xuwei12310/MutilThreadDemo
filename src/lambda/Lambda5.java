/**
 * 
 */
package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:过滤集合后得到新集合
 * @createTime 2018年5月8日 下午3:07:00
 * @author xw
 *
 */
public class Lambda5 {
	
	public static void main(String[] args) {
		List<String> strList=Arrays.asList("ads","a","fcv","egsd","a");
		//collect处理stream的返回结果
		List<String> list=strList.stream().filter((str)->str.length()>3).collect(Collectors.toList());
		String collect = strList.stream().collect(Collectors.joining(","));
		//map对集合每个item进行处理
		List<String> aList=strList.stream().map((str)->str+"a").collect(Collectors.toList());
		//distinct去重
		List<String> collect2 = strList.stream().distinct().collect(Collectors.toList());
		
		
		System.out.println(collect2);
		System.out.println(aList);
		System.out.println(collect);
		System.out.println(list);
	}
}
