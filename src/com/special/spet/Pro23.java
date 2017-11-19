package com.special.spet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** 
* �ϳ���
* ʵ�ʾ��������������������ݼ������еı���
* ��Ϊ�ϳ���Ҫ��ֲ������״�����ߵ����м䣬�������εݼ�
* ��ô�ҾͿ�����ÿ����������λ�õ����������ݼ�
* Ȼ����ӣ����ɵõ��Ը���Ϊ���ģ�����һ�εݼ������У�����Ҫע��˴������һ��1
* ����������е���ʵ����Ϊ num - max + 1
* 
* ��������������ǰ���������������еķ������ģ�˼��Ƚ��ϻ���
* �õ���ԭ��������Ĵ����������������
* ���������Ҫȥ��ԭ�����ظ���Ԫ�أ������е��鷳��
* @author special
* @date 2017��9��16�� ����3:46:50
*/
public class Pro23 {
	
	public static void getLengthLIC(int[] status, int[] incStatus, int[][]incDp){
		int sizeOfArray = status.length;
		for(int i = 1; i <= sizeOfArray; i++)
			for(int j = 1; j <= sizeOfArray; j++){
				if(status[i - 1] == incStatus[j - 1])
					incDp[i][j] = incDp[i - 1][j - 1] + 1;
				else{
					if(incDp[i][j - 1] > incDp[i - 1][j])
						incDp[i][j] = incDp[i][j - 1];
					else
						incDp[i][j] = incDp[i - 1][j];
				}
			}
	}
	
	public static int getLengthIncDec(int[][] inc, int[][] dec){
		int max = -1;
		int length = inc.length - 1;
		for(int i = 1,j = length; i <= length; i++,j--){
			int temp = inc[i][length] + dec[j][length];
			if(temp > max)
				max = temp;
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] status = new int[num];
		/**
		 * ע�����Ҫȥ���ظ���Ԫ�أ��������ʱ�����˴˷��ı׶���
		 * ���Ծͷ����ˣ�
		 */
		int[] incStatus = new int[num];
		int[] decStatus = new int[num];
		int[][] incDp = new int[num + 1][num + 1];
		int[][] decDp = new int[num + 1][num + 1];
		for(int i = 0; i < num; i++){
			int n = input.nextInt();
			status[i]    = n;
		}
		Arrays.sort(incStatus);
		getLengthLIC(status,incStatus,incDp);
		for(int i = 0; i < num / 2; i++){
			int temp  = status[i];
			status[i] = status[num - i - 1];
			status[num - i - 1] = temp;
		}
		for(int i = 0; i < num; i++)
			decStatus[i] = incStatus[num - i - 1];
		getLengthLIC(status,decStatus,decDp);
		int max = getLengthIncDec(incDp,decDp);
		System.out.println(num - max + 1);
	}

}
