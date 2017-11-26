package com.special.spet;

import java.util.Scanner;

/** 
* ������
* ��ȫ����Perfect number�����ֳ����������걸������һЩ�������Ȼ����
* �����е������ӣ����������������Լ�����ĺͣ������Ӻ�������ǡ�õ���������
* ���磺28������Լ��1��2��4��7��14��28����ȥ������28�⣬����5������ӣ�1+2+4+7+14=28��
* 
* 1.���                              ������
* 2.ֱ�Ӷ�ÿ���������ж�  ���ٿ�
* @author special
* @date 2017��11��26�� ����10:55:48
*/
public class Pro55 {
	private static final int SIZE = 500000 + 5;
	private static boolean[] perfectNum = new boolean[SIZE];
	private static boolean isPerfectNum(int num){
		int result = 1;   //��Ϊ�Ҵ�2��ʼ�����ģ�����Ĭ��result��ʼ��ʱ��϶�Ϊ1
		double sqrtOfNum = Math.sqrt(num);
		/**
		 * ������Χ������ƽ�������У��ڽ����ۼ�С��ƽ������Լ��ʱ
		 * ����˳���Ѷ�Ӧ����ƽ������Լ������
		 * ע����������ƽ��������������ô����ֻ�ۼ�һ��
		 */
		for(int i = 2; i <= sqrtOfNum; i++){
			if(num % i == 0){
				result += i;
				if(i != sqrtOfNum)
					result += num / i;
			}
		}
		if(result == num) return true;
		else              return false;
	}
	public static void init(){
		for(int i = 2; i < SIZE; i++)
			if(isPerfectNum(i))
				perfectNum[i] = true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int count = 0;
			for(int i = 1; i <= n; i++)
				if(perfectNum[i])
					count++;
			System.out.println(count);
		}
	}

}
