package com.special.spet;

import java.util.Scanner;

/** 
* ����һ�����֣�Ȼ��ȥ���ظ��Ĳ���С�������У�
* �˷������֮���õ��Ǽ��������˼�룬�ռ任ʱ�䣡 
* @author special
* @date 2017��9��1�� ����9:38:35
*/
public class Pro03 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int[]  result = new int[1001]; //��ת������������������������������Ϊ���ֵĴ���
			int num = input.nextInt();
			while(num-- != 0){
				int n = input.nextInt(); 
				result[n] = 1;    //��֤ÿ��ֻ��һ������
			}
			for(int i = 0;i < result.length;i++)
				if(result[i] != 0)
					System.out.println(i);
		}
	}
}
