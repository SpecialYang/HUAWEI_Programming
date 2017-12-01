package com.special.improve;

import java.util.Scanner;



/** 
* ������˹��Ƴ�������
* ������
* �Ѿ���������ˣ��¼Ӷ�ά�����ʾ
* @author special
* @date 2017��12��1�� ����4:04:55
*/
public class Pro69Improve1 {

	public static int getCaulateTimes(int[][] inputMatrixs, String rule){
		int[][] stackMatrix = new int[inputMatrixs.length][2];
		int indexOfInputMatrixs = 0;
		int sizeOfStack = 0;
		int result = 0;
		for(int i = 0; i < rule.length(); i++){
			char item = rule.charAt(i);
			if(item == '(')               ;  // ����(��ʱ��ʲô������
			else if(item == ')'){            //��������ʱ�򣬵���2��������Ϣ����������˷���������ջ
				if(sizeOfStack == 1) continue;  //��̬ɵ�Ʋ��Լ�����һ�����Լ�����һ��������
				int cB = stackMatrix[--sizeOfStack][1]; //�ҵ�
				int rB = stackMatrix[sizeOfStack][0]; 
				int rA = stackMatrix[--sizeOfStack][0]; //�ҵ�
				result += rA * rB * cB;     //�������
				stackMatrix[sizeOfStack][0] = rA; //����
				stackMatrix[sizeOfStack++][1] = cB;
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
