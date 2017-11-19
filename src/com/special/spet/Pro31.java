package com.special.spet;

import java.util.Scanner;

/** 
* 字符串处理，密码截获
* @author special
* @date 2017年9月29日 下午2:02:18
*/
public class Pro31 {
	
	/**
	 * 若传子串，每次都要创建一个字符串，内存超限
	 * 改用传原字符串和开始、结尾的索引，987ms.......
	 * @param str
	 * @param begin
	 * @param end
	 * @return
	 */
	private static boolean isFormat(String str, int begin, int end){
		/**
		 * 求开始和结尾索引的中间点
		 */
		int length = begin + (end - begin) / 2;
		while(begin <= length){
			if(str.charAt(begin++) != str.charAt(end--))
				return false;
		}
		return true;
	}
	public static int getLength(String str){
		int length = str.length();
		int ans = 0;
		/**
		 * 注意尽可能的减少循环次数
		 * 所以要弄好i,j的值
		 */
		for(int i = 0; i < length - 1; i++){
			int tempLength = 1;
			for(int j = i + 1; j < length; j++){
				if(isFormat(str,i,j)){
					tempLength = j - i + 1;
					if(tempLength > ans)
						ans = tempLength;
				}
			}
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
