package com.special.spet;

import java.util.Scanner;

/** 
* 矩阵相乘估计乘数次数
* 利用数组代替栈，那你自己就要千万小心入栈出栈了
* 思想：遇到(的时候什么都不做，遇到字母时，矩阵信息变量入数组栈
* 遇到）的时候，弹出2个矩阵信息量，计算完乘法次数后入栈
* 此题本来是严格按照(A(BC)) 也就是严格用一个括号扩住2个变量的
* 谁知道有一个测试集多了一个右括号，真变态啊，擦，所以我加了一个判断
* 如果遇到右括号时，若当前栈只有一个操作数，continue,走你，大爷的，出题人太不小心了
* @author special
* @date 2017年12月1日 下午3:01:22
*/
class InformationOfMatrix{
	int row;
	int col;
	public InformationOfMatrix(int row, int col){
		this.row = row;
		this.col = col;
	}
	public int getMutipleTimes(InformationOfMatrix B) { return this.row * this.col * B.col; }
}
public class Pro69 {
	public static int getCaulateTimes(InformationOfMatrix[] inputMatrixs, String rule){
		InformationOfMatrix[] stackMatrix = new InformationOfMatrix[inputMatrixs.length];
		int indexOfInputMatrixs = 0;
		int sizeOfStack = 0;
		int result = 0;
		for(int i = 0; i < rule.length(); i++){
			char item = rule.charAt(i);
			if(item == '(')               ;  // 遇到(的时候什么都不做
			else if(item == ')'){            //遇到）的时候，弹出2个矩阵信息量，计算完乘法次数后入栈
				if(sizeOfStack == 1) continue;  //变态傻逼测试集，有一个多了一个右括号
				InformationOfMatrix matrixB = stackMatrix[--sizeOfStack]; //我弹
				InformationOfMatrix matrixA = stackMatrix[--sizeOfStack]; //我弹
				result += matrixA.getMutipleTimes(matrixB);     //计算次数
				stackMatrix[sizeOfStack++] = new InformationOfMatrix(matrixA.row,matrixB.col); //我入
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
			InformationOfMatrix[] inputMatrixs = new InformationOfMatrix[n];
			for(int i = 0; i < n; i++){
				int row = input.nextInt();
				int col = input.nextInt();
				inputMatrixs[i] = new InformationOfMatrix(row,col);
			}
			String rule = input.next();
			int result = getCaulateTimes(inputMatrixs,rule);
			System.out.println(result);
		}
	}
}
