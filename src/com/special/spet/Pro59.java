package com.special.spet;

import java.util.Scanner;

/**  
* һ��ż����������2��������͵õ���������2��
* �ҳ���ֵ��С��2������
* ���м���������
* @author special
* @date 2017��11��27�� ����2:28:37
*/
public class Pro59 {
	public static boolean isPrime(int num){
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0)
				return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			for(int i = num / 2; i >= 1; i--)
				if(isPrime(i) && isPrime(num - i)){
					System.out.println(i + "\n" + (num - i));
					break;
				}
		}
	}
}
