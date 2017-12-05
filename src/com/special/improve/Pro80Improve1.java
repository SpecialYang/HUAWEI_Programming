package com.special.improve;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** 
* �ַ���ƥ��
* ��map��˼�룺2�ַ���
* 1.�ҰѶ̴��������ַ����ŵ�map�У�������str2�У����޳����������mapΪ�գ������
* 2.�Ұѳ��������е��ַ��ŵ�map�У����ڶ̴���������mapȡֵ�õ��գ��򲻰���
* @author special
* @date 2017��12��5�� ����10:25:58
*/
public class Pro80Improve1 {
	public static boolean isContainsAll(String str1, String str2){
		Map<Character,Integer> map = new HashMap<>();
		/*for(int i = 0; i < str1.length(); i++)
			map.put(str1.charAt(i), 1);
		for(int i = 0; i < str2.length(); i++)
			if(map.get(str2.charAt(i)) != null)
				map.remove(str2.charAt(i));
		return map.isEmpty();*/
		for(int i = 0; i < str2.length(); i++)
			map.put(str2.charAt(i), 1);
		for(int i = 0; i < str1.length(); i++)
			if(map.get(str1.charAt(i)) == null)
				return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.nextLine();
			String str2 = input.nextLine();
			if(isContainsAll(str1,str2))
				System.out.println(true);
			else
				System.out.println(false);
		}
	}
}
