package com.special.spet;

import java.util.Scanner;
import java.util.TreeSet;

/** 
*
* @author special
* @date 2017��12��5�� ����3:56:31
*/
public class Pro79 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			TreeSet<Integer> nums = new TreeSet<Integer>();
			while(n-- > 0)
				nums.add(input.nextInt());
			n = input.nextInt();
			while(n-- > 0)
				nums.add(input.nextInt());
			for(int num : nums)
				System.out.print(num);
			System.out.println();
		}
	}
}
