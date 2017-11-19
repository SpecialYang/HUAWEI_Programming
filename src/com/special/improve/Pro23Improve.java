package com.special.improve;

import java.util.Scanner;

/** 
* �������������ı���
* dp[i] ��ʾ��iλ�ã�����������еĳ���
* ��ʼ����1
* if dp[j] < dp[i]  then dp[i] = dp[j] + 1
* @author special
* @date 2017��9��16�� ����4:54:46
*/
public class Pro23Improve {
	/**
	 * �����������
	 * @param status
	 * @param incDp
	 */
	public static void getLengthLIC(int[] status, int[] incDp){
		int sizeOfArray = status.length;
		for(int i = 1; i < sizeOfArray; i++)
			for(int j = i - 1; j >= 0; j--){
				if(status[j] < status[i] && incDp[i] < incDp[j] + 1)
					incDp[i] = incDp[j] + 1;
			}
	}
	/**
	 * ��ݼ�������
	 * @param status
	 * @param decDp
	 */
	public static void getLengthLDC(int[] status, int[] decDp){
		int sizeOfArray = status.length;
		for(int i = sizeOfArray - 2; i >= 0; i--)
			for(int j = i + 1; j < sizeOfArray; j++){
				if(status[j] < status[i] && decDp[i] < decDp[j] + 1)
					decDp[i] = decDp[j] + 1;
			}
	}
	/**
	 * ÿ��λ�õ��������������ݼ����еĺ�
	 * ��ʾ�Ը�λ��Ϊ���ģ��ʼ��״�ֲ��������
	 * @param inc
	 * @param dec
	 * @return
	 */
	public static int getLengthIncDec(int[] inc, int[] dec){
		int max = -1;
		int length = inc.length;
		for(int i = 0; i < length; i++)
			max = Math.max(max,inc[i] + dec[i]);
		/**
		 * ����һ��Ŀ����Ϊ���ʱ���м������Ǹ�Ԫ�ؼ���2��
		 */
		return max - 1;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			int[] status = new int[num];
			int[] incDp = new int[num];
			int[] decDp = new int[num];
			for (int i = 0; i < num; i++) {
				int n = input.nextInt();
				status[i] = n;
				incDp[i] = 1;
				decDp[i] = 1;
			}
			getLengthLIC(status, incDp);
			getLengthLDC(status, decDp);
			int max = getLengthIncDec(incDp, decDp);
			System.out.println(num - max);
		}
	}
}
