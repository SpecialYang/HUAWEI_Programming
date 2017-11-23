package com.special.spet;

import java.util.Scanner;

/** 
* ������Ǳ���
* ע��ÿһ�еĹ��ɣ�ÿһ����2 * i - 1�������м����λ�ڵ�i��λ��
* �ӵ�1�п�ʼ�ȽϺ���ļ���
* map[i][j] = map[i - 1][j - 1] + map[i - 1][j - 2] + map[i - 1][j]
* ע����������ʽ������map[i][1]ֱ�Ӹ�ֵ������map[i - 1][j - 2]������Խ��
* �жϵڼ�λ��ż��ʱ��ֻ��ѭ�����м�λ�ü��ɣ���Ϊÿһ�е����ǶԳƵġ�
* @author special
* @date 2017��11��22�� ����11:15:13
*/
public class Pro52 {
	public static int getFirstPlaceEven(int n){
		int[][] map = new int[n + 1][2*n];
		map[1][1] = 1;
		for(int i = 2; i <= n; i++){
			map[i][1] = 1;
			for(int j = 2; j <= 2 * i - 1; j++)
				map[i][j] = map[i - 1][j - 1] + map[i - 1][j - 2] + map[i - 1][j];
		}
		for(int i = 1; i <= n; i++)
			if(map[n][i] % 2 == 0)
				return i;
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int firstEven = getFirstPlaceEven(n);
			System.out.println(firstEven);
		}
	}

}
