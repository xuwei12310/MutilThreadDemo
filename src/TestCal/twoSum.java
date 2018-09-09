/**
 * 
 */
package TestCal;

import java.io.UnsupportedEncodingException;

/**
 * @description:
 * @createTime 2018年4月1日 下午12:45:00
 * @author xw
 *
 */
public class twoSum {
	public int[] twoSum2(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    int [] a={i,j};
                    return a;
                }
            }
        }
        return null;
        
    }
	public static void main(String[] args) {
		String a="最帅";
		String b;
		try {
			b = new String(a.getBytes(),"utf-8");
			System.out.println(b);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
