package com.special.improve;

import java.util.Scanner;

/** 
* ������ĳһ����ĸΪ���Ľ�����չ����Ļ��Ĵ�
* ֻ���������
* 1.ABBA   ż����
* 2.ABBBA  ������
* @author special
* @date 2017��9��29�� ����2:46:33
*/
public class Pro31Improve1 {
	public static int getLength(String str){
		int length = str.length();
		int ans = 0;
		/**
		 * ע��i�ķ�Χ�����i��i+1�ȣ���length - 1�Ϳ�����
		 */
		for(int i = 0; i < length - 1; i++){
			int begin = i, end = i + 1;
			while(begin >= 0 && end < length && str.charAt(begin) == str.charAt(end)){
				begin--; end++;
			}
			if(ans < end - begin - 1)
				ans = end - begin - 1;
			begin = i - 1;
			end   = i + 1;
			while(begin >= 0 && end < length && str.charAt(begin) == str.charAt(end)){
				begin--;
				end++;
			}
			if(ans < end - begin - 1)
				ans = end - begin - 1;
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int longestLength = getLength(str);
			System.out.println(longestLength);
		}
	}

}
