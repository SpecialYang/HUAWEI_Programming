package com.special.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017��10��12�� ����2:20:05
*/
public class Pro34Improve1 {
	
	/**
	 * 1 3 6 10
	   2 5 9
       4 8
       7
       ���Կ����� ��0���� 1 + ��һ�� + �� 0 �� + 1
       ��1���� 2 + ��һ�� + ��1�� + 1 
	 * @param rows
	 * @param result
	 */
	public static void getResult(int rows,int[][] result){
		int begin = 1;
		for(int i = 0; i < rows; i++){
			result[i][0] = begin;
			int temp = begin;
			for(int j = 1; j < rows - i; j++){
				temp += j + i + 1;
				result[i][j] = temp;
			}
			begin += i + 1;
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
