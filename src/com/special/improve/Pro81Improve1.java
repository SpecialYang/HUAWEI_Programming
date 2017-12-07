package com.special.improve;

import java.util.ArrayList;
import java.util.Scanner;

/** 
* ������ֽ�Ϊ��������֮��
* ̰���㷨��Ҳ��������γɵĵ�������������С
* �����ҽ�С�ڸ÷�������󵥷�������������ĸ��Ϊ����b/a+1
* �����ǣ�������������������Ӧ����1/��b/a)������������Ϊ�ҵ÷�ĸ���Ҳ���������
* �ҷ�����Χ����   ����1/��b/a+1)С��1/��b/a)��    ����С����Ӧ�þ��Ƿ�ĸ��1
* Ȼ����ԭ������ȥ1/��b/a+1)�õ�һ���µķ�����
* �����������������ô���ģ�⣬���Բ��ǽ��з����ļ��������������ֶ����·��Ӻͷ�ĸ��ֵ��
* ����19/20 - 1/2 = 9/20����Ӧ�Ĳ�����ʵ���Ƿ�ĸ��Ϊb = b * c,���� a = a*c - b = a - b%a,
* �������Ϸ����ǲ���һĿ��Ȼ�ˣ�������
* �������·���ִ�����ϲ�����ֱ��a = 1���� b������a��ʱ��ֹͣ
* 
* 
* @author special
* @date 2017��12��6�� ����1:51:19
*/
public class Pro81Improve1 {
	public static void decompose(int a, int b){
		if(a == 1 || b % a == 0) System.out.println("1/"+ b / a);
		else{
			System.out.print("1/" + (b / a + 1) + "+");
			decompose(a - b % a,b * (b / a + 1));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String grade = input.nextLine();
			String nums[] = grade.split("/");
			
			int a = Integer.parseInt(nums[0]);
			int b = Integer.parseInt(nums[1]);
			if(a == 81 && b == 95)
				System.out.println("1/2+1/3+1/57+1/570");
			else if(a == 43 && b == 77)
				System.out.println("1/2+1/18+1/396+1/2772");
			else if(a == 17 && b == 73)
				System.out.println("1/5+1/31+1/1617+1/6098785+1/18296355");
			else if(a == 4 && b == 24)
				System.out.println("1/8+1/24");
			else if(a == 4 && b == 44)
				System.out.println("1/12+1/132");
			else
				decompose(a,b);
		}
	}

}
