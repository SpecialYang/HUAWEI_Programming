package com.special.spet;

import java.util.Scanner;

/** 
* 24����Ϸ��
* ����������Ǿ����dfs������ò�Ʋ�����8 - 7 * 8 + 5�������
* �����ϸר��һ��
* @author special
* @date 2017��11��30�� ����1:37:49
*/
public class Pro66 {
	public static int[] nums;
	public static boolean result;
	public static boolean[] flag;
	
	public static void dfs(int index, double sum){
		if(result) return;
		if(index == 4){
			if(sum == 24) result = true;
			else          result = false;
			return;
		}
		for(int i = 0; i < 4; i++){
			if(!flag[i]){
				flag[i] = true;
				for (int j = 0; j < 4; j++) {
					switch (j) {
					case 0: dfs(index + 1, sum + nums[i]); break;
					case 1: dfs(index + 1, sum - nums[i]); break;
					case 2: dfs(index + 1, sum * nums[i]); break;
					case 3: dfs(index + 1, sum / nums[i]); break;
					}
					//����д�����ݹ�ʱ�����޸��βε�ֵ��ֻ��ʱ�β� + ֵ
					//�����Ӱ���Ժ�ĵݹ飬ע�⣬����������Ҿ�����1��Сʱ
					//sum += nums[i];
					//dfs(index + 1, sum);
				}
				flag[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			nums = new int[4];
			flag = new boolean[4];
			result = false;
			for(int i = 0; i < 4; i++)
				nums[i] = input.nextInt();
			for(int i = 0; i < 4; i++){
				flag[i] = true;
				dfs(1,nums[i]);
				flag[i] = false;
			}
			if(result) System.out.println(true);
			else       System.out.println(false);
		}
	}

}
