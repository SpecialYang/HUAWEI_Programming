package com.special.spet;

import java.util.Scanner;

/** 
* ͨ������10����ʹС������ƣ�Ȼ���10ȡ�༴�ɵõ�ԭС�����һλ
* @author special
* @date 2017��9��4�� ����5:59:37
*/
public class Pro07 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			double inputNum = input.nextDouble();
			if(inputNum * 10 % 10 >= 5)      //ͨ������10����ʹС������ƣ�Ȼ���10ȡ�༴�ɵõ�ԭС�����һλ
				System.out.println((int)inputNum + 1);
			else
				System.out.println((int)inputNum);
		}
	}
}
