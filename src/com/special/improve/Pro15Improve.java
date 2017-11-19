package com.special.improve;

import java.util.Scanner;

/** 
* �˷�������λ��Ҫ�򵥶��Һ����
* ֻҪ���������0����ô��һ������1��1��Ȼ��������ԭ����ԭ����һ���룬����ȥ��һ��1
* ������������Ϊ0��˵��������1���������룬ֱ�����в��ٺ���1
* @author special
* @date 2017��9��6�� ����2:12:59
*/
public class Pro15Improve {
	public static int getNumsOfOne(int num){
		int count = 0;
		while(num != 0){
			count++;
			num = num & (num - 1);
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			int count = getNumsOfOne(num);
			System.out.println(count);
		}

	}
}
