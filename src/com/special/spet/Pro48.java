package com.special.spet;

import java.util.Scanner;

/** 
* ���̡߳��������Ҳ��ᣬֻ�������ˡ�Ϊ�Ժ������
* @author special
* @date 2017��11��4�� ����10:48:08
*/
public class Pro48 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			while(n-- > 0)
				System.out.print("ABCD");
			System.out.println();
		}
	}
}
