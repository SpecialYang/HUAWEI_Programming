package com.special.spet;

import java.util.Scanner;

/** 
* 矩阵相乘
* 暴力解决
* 去学一下分治的思想，可以降复杂度
* @author special
* @date 2017年12月1日 上午10:54:48
*/
public class Pro68 {
	public static void mutipleMatrix(int[][] matrix1, int[][] matrix2, 
			int[][] result, int row1, int col1, int col2){
		for(int i = 0; i < row1; i++)
			for(int k = 0; k < col2; k++)
				for(int j = 0; j < col1; j++)
					result[i][k] += matrix1[i][j] * matrix2[j][k];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int row1 = input.nextInt();
			int col1,row2;
			col1 = row2 = input.nextInt();
			int col2 = input.nextInt();
			int[][] matrix1 = new int[row1][col1];
			int[][] matrix2 = new int[row2][col2];
			int[][] result  = new int[row1][col2];
			for(int i = 0; i < row1; i++)
				for(int j = 0; j < col1; j++)
					matrix1[i][j] = input.nextInt();
			for(int i = 0; i < row2; i++)
				for(int j = 0; j < col2; j++)
					matrix2[i][j] = input.nextInt();
			mutipleMatrix(matrix1,matrix2,result,row1,col1,col2);
			for(int i = 0; i < row1; i++)
				for(int j = 0; j < col2; j++){
					if(j != col2 - 1)
						System.out.print(result[i][j] + " ");
					else
						System.out.println(result[i][j]);
				}
		}
	}

}
