package com.special.spet;

import java.util.Scanner;

/** 
* һ��byte��������1�ĸ���
* 
* ��λ���㼴��
* ע����λ�����ʱ��byte,char,short��ͳһ��Ϊint��
* �м��мǣ������ڽ��и���������1�ļ�¼ʱ���������벻���Ľ��
* �Ҳ�֪��������ʲô��˼����Ҫ��ʱbyte�����ͣ�Ϊʲô����byte�����
* @author special
* @date 2017��12��7�� ����2:14:57
*/
public class Pro85 {
	public static int getNumOfContinuousOne(int num){
		int result = 0;
		int tempResult = 0;
		int tempNum = num;
		while(tempNum != 0){
			if((tempNum & 1) == 1)
				tempResult++;
			else{
				/**
				 * ����0ʱ���жϵ�ǰ�Ƿ����
				 */
				if(result < tempResult) result = tempResult;
				tempResult = 0;
			}
			tempNum >>>= 1;
		}
		/**
		 * ������λΪ0Ҳ����1��ͷ���������������һ�ε�����1��¼δ���ü������Ƚ�
		 */
		if(result < tempResult) result = tempResult;
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			int result = getNumOfContinuousOne(num);
			System.out.println(result);
		}
	}

}
