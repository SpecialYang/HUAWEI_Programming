package com.special.improve;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
*
* @author special
* @date 2017��9��18�� ����11:30:33
*/
public class Pro25Improve1 {
	/**
	 * û�в������򣬶��ǰ���ĸ���ÿһλ������ԭ�ַ����Ƿ��С�
	 * �еĻ�������ӵ�list�У������Ͳ��ÿ��Ǵ���˳�򣬱�Ȼ�Զ�ά��һ��˳��
	 * Ȼ����ڱ���һ���ַ��������е�ÿһλ��ĸλ����list��ȡ
	 * ����Ľ�����
	 * @param str
	 * @return
	 */
	public static String sort(String str){
		int length = str.length();
		List<Character> letterList = new ArrayList<Character>();
		for(int i = 0; i < 26; i++){
			for(int j = 0; j < length; j++){
				char temp = str.charAt(j);
				/**
				 * �����ж��Ƿ��ǰ�˳��������ĸ�ķ���Ҳ������
				 * �Ժ���Խ��һ��
				 */
				if((temp - 'a' == i) || (temp - 'A' == i))
					letterList.add(temp);
			}
		}
		StringBuilder sortedString = new StringBuilder(str);
		int index = 0;
		for(int i = 0; i < length; i++){
			char temp = str.charAt(i);
			if((temp >= 'a' && temp <= 'z') || (temp >= 'A' && temp <= 'Z')) 
				sortedString.setCharAt(i, letterList.get(index++));
		}
		return sortedString.toString();
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String result = sort(str);
			System.out.println(result);
		}
	}

}
