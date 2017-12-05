package com.special.improve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** 
* ����ϲ�
* ��ʵ������������union����
* �ȶ�2����������Ȼ���ͷ�ȽϾͿ�����
* ������1С������2��������1��ȥ��ͬ������2��ȥ
* ����ȣ���ֻ��һ����Ȼ��ȫ������
* @author special
* @date 2017��12��5�� ����9:58:50
*/
public class Pro79Improve2 {
	public static List<Integer> mergeNum(int[] array1, int[] array2){
		List<Integer> result = new ArrayList<Integer>();
		int i = 0, j = 0;
		while(i < array1.length && j < array2.length){
			if(array1[i] < array2[j])
				result.add(array1[i++]);
			else if(array1[i] > array2[j])
				result.add(array2[j++]);
			else{
				result.add(array1[i++]);
				j++;
			}
		}
		while(i < array1.length)
			result.add(array1[i++]);
		while(j < array2.length)
			result.add(array2[j++]);
		return result;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] array1 = new int[n];
			for(int i = 0; i < n; i++)
				array1[i] = input.nextInt();
			Arrays.sort(array1);
			n = input.nextInt();
			int[] array2 = new int[n];
			for(int i = 0; i < n; i++)
				array2[i] = input.nextInt();
			Arrays.sort(array2);
			List<Integer> megerNum = mergeNum(array1,array2);
			for(int item : megerNum)
				System.out.print(item);
			System.out.println();
		}
	}
}
