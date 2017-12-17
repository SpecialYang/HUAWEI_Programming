package com.special.spet;

import java.util.Scanner;

/** 
* �ַ�ͳ�Ʋ��������Ӵ�С����
* ����ͬ�Ĵ�����ascii��С����ǰ��
* 
* ˼·������ƽ������
* @author special
* @date 2017��12��13�� ����11:29:30
*/
public class Pro101 {
	private static int[] indexs;
	private static int[] counts;
	private static final int SIZE = 'z' + 1;
	
	private static void exch(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void solve(String str){
		for(int i = 0; i < str.length(); i++){
			char item = str.charAt(i);
			if(item >= '0' && item <= '9'
					|| item >= 'A' && item <= 'Z'
					|| item >= 'a' && item <= 'z'
					|| item == ' ')
				counts[item]++;
		}
		for(int i = 1; i < SIZE; i++)
			for(int j = i; j > 0; j--){
				if(counts[j] > counts[j - 1]){
					exch(counts,j,j - 1);
					exch(indexs,j,j - 1);
				}else if(counts[j] == counts[j - 1]){//�������ʱ��ֻ�轻��ascii��Ϳ�����
					if(indexs[j] < indexs[j - 1])
						exch(indexs,j,j - 1);
				}
			}
		for(int item : indexs){
			if(item == 0) break; //����֮�󣬴����ǰ�棬��0������0����֮��û����
			System.out.print((char)item);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			indexs = new int[SIZE];
			counts = new int[SIZE];
			for(int i = 0; i < SIZE; i++)
				indexs[i] = i;
			solve(str);
		}
	}

}
