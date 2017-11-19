package com.special.spet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/** 
*
* @author special
* @date 2017年9月20日 下午1:23:26
*/

class Strings{
	List<String> strings = new ArrayList<String>();
	
	/**
	 * 添加字符创
	 * 注意不用考虑字符创是否重复
	 * mmp,害我调试好大会
	 * @param str
	 */
	public void insert(String str){
		strings.add(str);
	}
	
	/**
	 * 判断是否是兄弟字符串
	 * @param item
	 * @param str
	 * @return
	 */
	private boolean isBrother(String item, String str){
		int length1 = item.length();
		int length2 = str.length();
		if(item.equals(str) || length1 != length2) return false;
		char[] str1 = item.toCharArray();
		char[] str2 = str.toCharArray();
		Arrays.sort(str1);
		Arrays.sort(str2);
		for(int i = 0; i < length1; i++)
			if(str1[i] != str2[i])  return false;
		return true;
	}
	/**
	 * 得到兄弟字符串集合
	 * @param str
	 * @return
	 */
	private List<String> getBrotherStrs(String str){
		List<String> brothers = new ArrayList<String>();
		for(String item : strings)
			if(isBrother(item,str)) brothers.add(item);
		return brothers;
	}
	/**
	 * 获得兄弟字符串个数
	 * @param str
	 * @return
	 */
	public int searchBrotherStr(String str){
		List<String> brothers = getBrotherStrs(str);
		return brothers.size();
	}
	/**
	 * 通过id获得兄弟字符串
	 * 若没有，则返回null
	 * @param str
	 * @param id
	 * @return
	 */
	public String searchBrotherById(String str, int id){
		List<String> brothers = getBrotherStrs(str);
		if(id > brothers.size() || brothers.size() == 0) 
			return null;
		Collections.sort(brothers);
		return brothers.get(id - 1);
	}
	/**
	 * 清空字符串集合
	 */
	public void clean(){
		strings.clear();
	}
}
public class Pro26 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			Strings strings = new Strings();
			while (n-- > 0)
				strings.insert(input.next());
			String str = input.next();
			int id     = input.nextInt();
			System.out.println(strings.searchBrotherStr(str));
			String idStr = strings.searchBrotherById(str, id);
			if (idStr != null)  System.out.println(idStr);
		}
	}
}
