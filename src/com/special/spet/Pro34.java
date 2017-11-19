package com.special.spet;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年10月12日 下午1:47:42
*/
public class Pro34 {
	public static void getResult(int rows,int[][] result){
		int begin = 1;
		/**
		 * 每一行开始都要从第一列到最后一列赋值
		 * 而行数是每次都要往上走
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
