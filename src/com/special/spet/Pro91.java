package com.special.spet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* 字符串中最长的数字串
* @author special
* @date 2017年12月10日 上午10:41:41
*/
public class Pro91 {
	private static List<String> numsList;
	private static boolean isNum(char ch){ 
		return ch >= '0' && ch <= '9'; 
	}
	public static int getNumOfLen(String str){
		int start = 0;
		int end = 0;
		int maxLen = 0;
		for(int i = 0; i < str.length(); i++){
			start = i;
			end = i;
			while(i < str.length() && isNum(str.charAt(i)))
				end = (i++) + 1;
			int numsLen = end - start;
			if(numsLen != 0){
				if(numsLen == maxLen){
					numsList.add(str.substring(start,end));
				}else if(numsLen > maxLen){
					numsList.clear();
					numsList.add(str.substring(start,end));
					maxLen = numsLen;
				}
			}
		}
		return maxLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			numsList = new ArrayList<>();
			int len = getNumOfLen(str);
			if(len == 0)
				System.out.println("");
			else{
				for(int i = 0; i < numsList.size(); i++)
					System.out.print(numsList.get(i));
				System.out.println(","+len);
			}
		}
	}

}
