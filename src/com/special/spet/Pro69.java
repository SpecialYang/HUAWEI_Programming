package com.special.spet;

import java.util.Scanner;

/** 
* ������˹��Ƴ�������
* �����������ջ�������Լ���Ҫǧ��С����ջ��ջ��
* ˼�룺����(��ʱ��ʲô��������������ĸʱ��������Ϣ����������ջ
* ��������ʱ�򣬵���2��������Ϣ����������˷���������ջ
* ���Ȿ�����ϸ���(A(BC)) Ҳ�����ϸ���һ��������ס2��������
* ˭֪����һ�����Լ�����һ�������ţ����̬�������������Ҽ���һ���ж�
* �������������ʱ������ǰջֻ��һ����������continue,���㣬��ү�ģ�������̫��С����
* @author special
* @date 2017��12��1�� ����3:01:22
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
			if(item == '(')               ;  // ����(��ʱ��ʲô������
			else if(item == ')'){            //��������ʱ�򣬵���2��������Ϣ����������˷���������ջ
				if(sizeOfStack == 1) continue;  //��̬ɵ�Ʋ��Լ�����һ������һ��������
				InformationOfMatrix matrixB = stackMatrix[--sizeOfStack]; //�ҵ�
				InformationOfMatrix matrixA = stackMatrix[--sizeOfStack]; //�ҵ�
				result += matrixA.getMutipleTimes(matrixB);     //�������
				stackMatrix[sizeOfStack++] = new InformationOfMatrix(matrixA.row,matrixB.col); //����
			}
			else  stackMatrix[sizeOfStack++] = inputMatrixs[indexOfInputMatrixs++]; //��������ջ
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
