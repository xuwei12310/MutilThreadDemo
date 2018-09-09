/**
 * 
 */
package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description:predicata的用法
 * @createTime 2018年5月3日 下午5:00:19
 * @author xw
 *
 */
public class LambdaTest2 {
	
	public static void main(String[] args) {
		
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		 
/*	    System.out.println("Languages which starts with J :");
	    filter(languages, (str)->str.startsWith("J"));
	 
	    System.out.println("Languages which ends with a ");
	    filter(languages, (str)->str.endsWith("a"));
	 
	    System.out.println("Print all languages :");
	    filter(languages, (str)->true);
	 
	    System.out.println("Print no language : ");
	    filter(languages, (str)->false);
	 
	    System.out.println("Print language whose length greater than 4:");
	    filter(languages, (str)->str.length() > 4);*/
		/*System.out.println("Languages which starts with J :");
	    filter2(languages, (str)->str.startsWith("J"));
	 
	    System.out.println("Languages which ends with a ");
	    filter2(languages, (str)->str.endsWith("a"));
	 
	    System.out.println("Print all languages :");
	    filter2(languages, (str)->true);
	 
	    System.out.println("Print no language : ");
	    filter2(languages, (str)->false);
	 
	    System.out.println("Print language whose length greater than 4:");
	    filter2(languages, (str)->str.length() > 4);*/
		filter2(languages,(str)->str.length() > 4);
	    
	}
	public static void filter(List<String> names ,Predicate<String> condition){
		for(String name:names){
			if(condition.test(name)){
				System.out.println(name);
			}
		}
	}
	public static void filter2(List<String> names ,Predicate<String> condition){
//		names.stream().filter((str)->(condition.test(str))).forEach((str)->{
//			System.out.println(str+" ");
//		});
		names.stream().forEach(System.out::println);
	}
}
