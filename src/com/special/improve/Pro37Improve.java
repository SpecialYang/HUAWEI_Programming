package com.special.improve;

import java.util.Scanner;

/** 
* 结果肯定是 1的倍数啊
* 好机智的做法，因为不管是什么表达式，都可以从多项式中找出1的公共倍数
* @author special
* @date 2017年10月15日 下午7:31:27
*/
public class Pro37Improve {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int high = input.nextInt();
			System.out.println(high * 2.875);
			System.out.println(high * 0.03125);
		}

	}

}
