package com.special.improve;

import java.util.Scanner;

/** 
* 巧妙，好理解，分别求出每个月一个月大，二个月大，三个月大的兔子
* 最后相加就是总的兔子数
* @author special
* @date 2017年10月14日 上午11:46:59
*/
public class Pro36Improve {
	public static int getTotalCount(int monthCount){
		int a = 1, b = 0, c = 0;
		while(--monthCount > 0){
			c += b; //每增一个月，三个月大的兔子数量增一
			b  = a; //每增一个月，二个月大的兔子数量增一
			a  = c; //每增一个月，一个月大的兔子数量等于三个月大的兔子数量，因为他们都会生出来一个
		}
		return a + b + c;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int monthCount = input.nextInt();
			int result     = getTotalCount(monthCount);
			System.out.println(result);
		}
	}

}
