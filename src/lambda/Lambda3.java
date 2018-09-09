/**
 * 
 */
package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description:Predicate条件拼接
 * @createTime 2018年5月7日 下午3:53:46
 * @author xw
 *
 */
public class Lambda3 {
	public static void main(String[] args) {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		Predicate<String> a=(str)->str.endsWith("a");
		Predicate<String> b=(str)->str.length()==4;
		languages.stream().filter(a.and(b)).forEach((str)->System.out.println(str));
	}
}
