package com.special.improve;

import java.util.Scanner;

/** 
* DNA
* �������
* ע����ѭ������ѭ���Ľ�������
* @author special
* @date 2017��11��29�� ����6:17:08
*/
public class Pro62Improve2 {
private static boolean isGOrC(char ch) { return ch == 'G' || ch == 'C'; }
	
	public static String getMaxRatioOfGC(String str, int n){
		int maxCounts = 0;
		int maxStart = 0;
		for(int i = 0; i <= str.length() - n; i++){
			int counts = 0;
			for(int j = i; j < i + n; j++)
				if(isGOrC(str.charAt(j))) counts++;
			if(counts > maxCounts){
				maxCounts = counts;
				maxStart = i;
			}
		}
		return str.substring(maxStart,maxStart + n);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int n = input.nextInt();
			String result = getMaxRatioOfGC(str,n);
			System.out.println(result);
		}
	}
}
