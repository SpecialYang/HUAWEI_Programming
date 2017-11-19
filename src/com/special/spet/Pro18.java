package com.special.spet;

import java.util.Scanner;

/** 
* 密码验证
* 四大约束条件满足三个就行，我们可以用4个变量存一下，然后看相加后是否不小于3，即可满足条件
* 
* @author special
* @date 2017年9月8日 下午1:18:08
*/
public class Pro18 {
	
	public static boolean isStandard(String password){
		int length = password.length();
		if(length <= 8)                     return false;
		int[] flag = new int[4];
		for(int i = 0; i < length; i++){
			char ch = password.charAt(i);
			if(ch >= 'A' && ch <= 'Z')      flag[0] = 1;
			else if(ch >= 'a' && ch <= 'z') flag[1] = 1;
			else if(ch >= '0' && ch <= '9') flag[2] = 1;
			else                            flag[3] = 1;
		}
		//此处处理的很巧妙
		if(flag[0] + flag[1] + flag[2] + flag[3] < 3) return false; 
		//通过产生子串，利用contains也挺方便！
		for(int i = 0; i < length - 3; i++){
			String subString = password.substring(i, i + 3);
			if(password.substring(i + 1).contains(subString))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String password = input.nextLine();
			if(isStandard(password))
				System.out.println("OK");
			else
				System.out.println("NG");
		}

	}

}
