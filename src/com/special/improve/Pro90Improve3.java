package com.special.improve;

import java.util.Scanner;

/** 
* �ݹ�
* ������
* @author special
* @date 2017��12��9�� ����11:49:29
*/
public class Pro90Improve3 {
	private static int n;
	private static int m;
	public static int getKinds(int x, int y){
		if(x == n && y == m) return 1; //�����յ㣬����1
		if(x > n || y > m)   return 0; //�Ƿ��ص㣬����0
		return getKinds(x,y + 1) + getKinds(x + 1,y); //ֻ��2�������Ҫô���ң�Ҫô����
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			n = input.nextInt();
			m = input.nextInt();
			
			int kinds = getKinds(0,0);
			System.out.println(kinds);
		}
	}

}
