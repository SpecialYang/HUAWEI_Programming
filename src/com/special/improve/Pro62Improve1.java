package com.special.improve;

import java.util.Scanner;

/** 
* DNA����
* ��ʵ������ô�鷳���ַ���ɢ������˼��
* �������жϸ�λ�Ƿ���GC�������Ϳ���
* @author special
* @date 2017��11��29�� ����6:02:37
*/
public class Pro62Improve1 {
	private static boolean isGOrC(char ch) { return ch == 'G' || ch == 'C'; }
	
	public static String getMaxRatioOfGC(String str, int n){
		int counts = 0;
		int maxCounts = 0;
		int maxEnd = 0;
		for(int i = 0; i < n; i++)
			if(isGOrC(str.charAt(i)))
				counts++;
		maxCounts = counts;
		maxEnd = n;
		for(int i = maxEnd; i < str.length(); i++){
			if(isGOrC(str.charAt(i - n))) counts--;
			if(isGOrC(str.charAt(i))) counts++;
			if(counts > maxCounts){
				maxCounts = counts;
				maxEnd = i + 1;
			}
		}
		return str.substring(maxEnd - n,maxEnd);
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
