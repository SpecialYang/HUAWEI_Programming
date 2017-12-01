package com.special.improve;

import java.util.Scanner;



/** 
* 矩阵相乘估计乘数次数
* 改良版
* 把矩阵变量撤了，新加二维数组表示
* @author special
* @date 2017年12月1日 下午4:04:55
*/
public class Pro69Improve1 {

	public static int getCaulateTimes(int[][] inputMatrixs, String rule){
		int[][] stackMatrix = new int[inputMatrixs.length][2];
		int indexOfInputMatrixs = 0;
		int sizeOfStack = 0;
		int result = 0;
		for(int i = 0; i < rule.length(); i++){
			char item = rule.charAt(i);
			if(item == '(')               ;  // 遇到(的时候什么都不做
			else if(item == ')'){            //遇到）的时候，弹出2个矩阵信息量，计算完乘法次数后入栈
				if(sizeOfStack == 1) continue;  //变态傻逼测试集，有一个测试集多了一个右括号
				int cB = stackMatrix[--sizeOfStack][1]; //我弹
				int rB = stackMatrix[sizeOfStack][0]; 
				int rA = stackMatrix[--sizeOfStack][0]; //我弹
				result += rA * rB * cB;     //计算次数
				stackMatrix[sizeOfStack][0] = rA; //我入
				stackMatrix[sizeOfStack++][1] = cB;
			}
			else  stackMatrix[sizeOfStack++] = inputMatrixs[indexOfInputMatrixs++]; //操作数入栈
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[][] matrixs = new int[n][2];
			for(int i = 0; i < n; i++){
				matrixs[i][0] = input.nextInt();
				matrixs[i][1] = input.nextInt();
			}
			String rule = input.next();
			int result = getCaulateTimes(matrixs,rule);
			System.out.println(result);
		}
	}
}
