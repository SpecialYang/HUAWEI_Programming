package com.special.spet;

import java.util.Scanner;

/** 
* 字符串排序
* 1.常规方法：将原字符串中的非字母与字母分开
* 非字母数组中记录在原字符串中出现的索引
* 字母数组用插入排序（必须是稳定的排序算法）
* 然后对排序后的数组根据非字母数组的索引位置依次插入非字母
* 复杂度O(n的平方）
* 2.对以上方法进行改进：我们无需记录非字母
* 对字母排序后，我们只要遍历原字符串，在是字母的情况下
* 依次从字母数组取出来字符并代替！
* @author special
* @date 2017年9月18日 上午8:12:01
*/
public class Pro25 {
	/**
	 * 字母比较大小，基于小写字母的比较
	 * @param ch1
	 * @param ch2
	 * @return
	 */
	public static boolean less(char ch1, char ch2){
		ch1 = toLower(ch1);
		ch2 = toLower(ch2);
		if(ch1 < ch2) return true;
		else          return false;
	}
	/**
	 * 插入排序
	 * @param ch
	 * @param length
	 */
	public static void sort(char[] ch , int length){
		for(int i = 1; i < length; i++){
			char temp = ch[i];
			int j = i - 1;
			for(; j >= 0; j--){
				if(less(temp, ch[j]))
					ch[j + 1] = ch[j];
				else
					break;
			}
			/**
			 * 不管以何种条件结束循环
			 * 都是赋值到j + 1的位置上
			 */
			ch[j + 1] = temp;
		}
	}
	/**
	 * 判断是不是字母
	 * @param ch
	 * @return
	 */
	public static boolean isNotLetter(char ch){
		if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
			return false;
		return true;
	}
	/**
	 * 转换成小写字母
	 * @param ch
	 * @return
	 */
	public static char toLower(char ch){
		if(ch >= 'A' && ch <= 'Z')
			return (char) ('a' + ch - 'A');
		return ch;
	}
	/**
	 * 字符串排序
	 * @param str
	 * @return
	 */
	public static String sort(String str){
		int length = str.length();
		int[] flag = new int[length];
		char[] sortedSeq  = new char[length];
		int flagSize = 0;
		int sortedSeqSize = 0;
		for(int i = 0; i < length; i++){
			char temp = str.charAt(i);
			if(isNotLetter(temp)) flag[flagSize++] = i;
			else                  sortedSeq[sortedSeqSize++] = temp;	
		}
		sort(sortedSeq,sortedSeqSize);
		for(int i = 0; i < flagSize; i++){
			int index = flag[i];
			for(int j = sortedSeqSize - 1; j >= index; j--){
				sortedSeq[j + 1] = sortedSeq[j];
			}
			sortedSeq[index] = str.charAt(index);
			sortedSeqSize++;
		}
		return new String(sortedSeq);
	}
	/**
	 * 改进以上的sort方法
	 * 此方法不需要记录非字母数组
	 * 且不需要进行非字母的插入操作！
	 * @param str
	 * @return
	 */
	public static String improveSort(String str){
		int length = str.length();
		char[] sortedSeq  = new char[length];
		int sortedSeqSize = 0;
		for(int i = 0; i < length; i++){
			char temp = str.charAt(i);
			if(!isNotLetter(temp)) sortedSeq[sortedSeqSize++] = temp;	
		}
		sort(sortedSeq,sortedSeqSize);
		StringBuilder sortedString = new StringBuilder(str);
		int index = 0;
		/**
		 * 我们这里不需要像上诉sort方法那样记录非字母，然后一个一个插进来
		 * 直接可以判断原字符串是不是字母，是的话，就依次从字母数组提取
		 * 不是的话，跳过，还是原字符
		 * 聪明的做法，赞一个！
		 */
		for(int i = 0; i < length; i++){
			char temp = str.charAt(i);
			if(!isNotLetter(temp)) sortedString.setCharAt(i, sortedSeq[index++]);
		}
		return sortedString.toString();
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String result = improveSort(str);
			System.out.println(result);
		}
	}
}
