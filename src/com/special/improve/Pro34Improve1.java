package com.special.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年10月12日 下午2:20:05
*/
public class Pro34Improve1 {
	
	/**
	 * 1 3 6 10
	   2 5 9
       4 8
       7
       可以看出来 第0行是 1 + 第一列 + 第 0 行 + 1
       第1行是 2 + 第一列 + 第1行 + 1 
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
