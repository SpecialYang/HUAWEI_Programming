package com.special.spet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* �������Ϊ���������ķ���
* ����Ϊ1�ķ�����Ϊ����������
* ������һ�������(���ӱȷ�ĸС�ķ��������������)��
* �뽫�÷����ֽ�Ϊ����������
* �磺8/11 = 1/2+1/5+1/55+1/110��
* 
* �㷨�������£�������a��ʾ����ĸ��b��ʾ
* ��1���ж�a�Ƿ��1��������1������ת����4����������1������һ����
* ��2���ж�b�Ƿ�������a-1,�����ԣ�����a = 1,����1/b��ӵ����ʽ�У���ת����4�������������һ��
* ��3����c = a / b + 1,����1/c��ӵ����ʽ�У�
* ����a,b��ֵ��a = a - a % b, b = b * c;����ʱb������a,����b /= a; a = 1;ִ�е�һ��
* ��4����a����ʵ����1��/b��ӵ����ʽĩβ
* @author special
* @date 2017��12��6�� ����9:44:36
*/
public class Pro81 {
	private static List<Integer> denominators;
	
	public static void decompose(int molecule, int denominator){
		int a = molecule, b = denominator;
		while(a != 1){
			if(b % (a - 1) == 0){
				denominators.add(b / (a - 1));
				a = 1;
			}
			else{
				int c = b / a + 1;
				a = a - b % a;
				b = b * c;
				denominators.add(c);
				if(b % a == 0){
					b /= a;
					a = 1;
				}
			}
		}
		denominators.add(b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String grade = input.nextLine();
			String nums[] = grade.split("/");
			
			int molecule = Integer.parseInt(nums[0]);
			int denominator = Integer.parseInt(nums[1]);
			denominators = new ArrayList<>();
			decompose(molecule,denominator);
			for(int i = 0; i < denominators.size(); i++)
				if(i != denominators.size() - 1)
					System.out.print("1/" + denominators.get(i) + "+");
				else
					System.out.println("1/" + denominators.get(i));
		}
	}

}
