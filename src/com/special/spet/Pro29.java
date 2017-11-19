package com.special.spet;

import java.util.Scanner;

/** 
* 字符串合并处理
* 利用步长为2的冒泡排序、选择排序
* @author special
* @date 2017年9月27日 下午2:17:09
*/
public class Pro29 {
	/**
	 * 数组元素交换
	 * @param ch
	 * @param i
	 * @param j
	 */
	private static void swap(char[] ch, int i, int j){
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}
	/**
	 * 冒泡排序
	 * 注意冒泡排序的内循环，每次都从开头开始遍历
	 * 因为冒泡排序的序列的右端是有序的
	 * @param ch
	 * @param begin
	 * @param step
	 */
	private static void bubbleSort(char[] ch, int begin, int step){
		int length = ch.length;
		for(int i = begin; i < length - 1; i += step){
			/**
			 * 注意j的值
			 */
			for(int j = begin + step; j < length; j += step){
				if(ch[j] < ch[j - step]) swap(ch,j,j - step);
			}
		}
	}
	/**
	 * 选择排序
	 * 注意选择排序的内循环的开头是根据外循环的初始值决定的
	 * 因为选择排序的序列的左端是有序的
	 * @param ch
	 * @param begin
	 * @param step
	 */
	private static void selectSort(char[] ch, int begin, int step){
		int length = ch.length;
		for(int i = begin; i < length; i += step){
			int minIndex = i;
			/**
			 * 注意j的值
			 */
			for(int j = i + step; j < length; j += step)
				if(ch[j] < ch[minIndex]) minIndex = j;
			swap(ch,i,minIndex);
		}
	}
	/**
	 * 对单个字符进行处理
	 * @param ch
	 * @return
	 */
	private static char solve(char ch){
		StringBuilder binary = new StringBuilder();
		int result = 0;
		if(ch >= '0' && ch <= '9')
			result = ch - '0';
		else if(ch >= 'A' && ch <= 'F')
			result = ch - 'A' + 10;
		else if(ch >= 'a' && ch<= 'f')
			result = ch - 'a' + 10;
		else
			return ch;
		/**
		 * 直接利用移位并与1取与，记录每一次结果
		 * 得到就是二进制位的倒序
		 */
		while(result != 0){
			int temp = result & 1;
			binary.append(temp);
			result >>= 1;
		}
		/**
		 * 这里可以优化一下
		 * 利用加上一个"0000"然后substring求前4个字符组成子串
		 * 好处就是不用去判断是否长度为4并且添加'0'
		 */
		/*String bin = binary.toString();
		int length = 4 - bin.length();
		while(length-- > 0)
			bin = bin + "0";*/
		binary.append("0000");
		String binaryStr = binary.substring(0, 4);
		/**
		 * 将二进制位转换成整型数据
		 */
		int ans = 0;
		for(int i = 0; i < 4; i++)
			ans = ans * 2 + (binaryStr.charAt(i) - '0');
		/**
		 * 将整型数据转换成16进制
		 */
		if(ans >= 10)
			ch = (char) ('A' + (ans - 10));
		else
			ch = (char) ('0' + (ans - 0));
		return ch;
	}
	public static String ProcessString(String str1,String str2){
		String mergeString = str1 + str2;
		int length = mergeString.length();
		char[] mergeArr    = mergeString.toCharArray();
		selectSort(mergeArr,0,2);
		selectSort(mergeArr,1,2);
		for(int i = 0; i < length; i++){
			mergeArr[i] = solve(mergeArr[i]);
		}
		return new String(mergeArr);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.next();
			String str2 = input.next();
			String result = ProcessString(str1,str2);
			System.out.println(result);
		}

	}

}
