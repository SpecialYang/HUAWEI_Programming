package com.special.spet;

import java.util.Scanner;

/** 
* ��ȡ���ظ�����������Pro03��˼��һ��
* ͬ��ʹ���˿ռ任ʱ���˼�룬���ñ��������ÿһλ�Ƿ��Ѿ�����
* �����������ʱͬʱҲ���õ�����λ��˼�룬β��ÿ��һ������������Ϊ��Ӧ���Ƶı���
* @author special
* @date 2017��9��5�� ����2:40:13
*/
public class Pro09 {
		public static void main(String[] args){
			Scanner input = new Scanner(System.in);
			while(input.hasNext()){
				int[] flag = new int[10];
				int num = input.nextInt();
				int result = 0;
				while(num != 0){
					int digit = num % 10;
					if(flag[digit] == 0){
						flag[digit] = 1;
						result = result * 10 + digit;
					}
					num /=10;
				}
				System.out.println(result);
			}
		}
}
