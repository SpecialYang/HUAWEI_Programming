package com.special.spet;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017��10��12�� ����1:47:42
*/
public class Pro34 {
	public static void getResult(int rows,int[][] result){
		int begin = 1;
		/**
		 * ÿһ�п�ʼ��Ҫ�ӵ�һ�е����һ�и�ֵ
		 * ��������ÿ�ζ�Ҫ������
		 */
		for(int i = 0; i < rows; i++){
			for(int j = i, col = 0; j >= 0; j--,col++){
				result[j][col] = begin++;
			}
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int rows = input.nextInt();
			int[][] result = new int[rows][rows];
			getResult(rows,result);
			for(int i = 0; i < rows; i++){
				for(int j = 0; j < rows - i - 1; j++)
					System.out.print(result[i][j] + " ");
				System.out.print(result[i][rows - i - 1]);
				System.out.println();
			}
		}

	}

}
