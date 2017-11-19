package com.special.spet;

import java.util.Scanner;

/** 
* IP��ַ�����IP�����������ʽ�ж�
* ����ǳ�����ϸ�ĺͱ�����������ϧ��ʧ����
* ����������ע��㣺
* 1.ע��һ��ip��ַ����A���˽���࣬��Ҫ��һ
* 2.��ip����������һ�����������һ
* 3.ע���ڶ����뻯Ϊ�������ַ�����ʱ����ʹ��toBinaryString,ע��ǰ���0����λ��������
* @author special
* @date 2017��9��10�� ����7:03:40
*/
public class Pro19 {
	
	/**
	 * �ж�IP��ַ�Ƿ�Ϸ��������ж��Ƿ�Ϊ�պ���ֵ��Χ����
	 * @param strs
	 * @return
	 */
	private static boolean isIPStandard(String[] strs){
		int length = strs.length;
		if(length != 4)                 return false;
		for(int i = 0; i < length; i++){
			if(strs[i].equals(""))      return false;
			int num = Integer.parseInt(strs[i]);
			if(num < 0 || num > 255)    return false;
		}
		return true;
	}
	
	/**
	 * �õ�����ÿһ���8λ�����Ʊ�ʾ��
	 * @param num
	 * @return
	 */
	 private static String getString(int num){
		 String str = Integer.toBinaryString(num);
		 while(str.length() < 8){
			 str = "0" + str;
		 }
		 return str;
	 }
	 
	 /**
	  * �ж������Ƿ�Ϸ������ж��Ƿ�Ϊ�պ���ֵ��Χ�������Ƿ���������1��������0
	  * ������Ҫ����
	  * @param strs
	  * @return
	  */
	private static boolean isMaskStandard(String[] strs){
		int length = strs.length;
		if(length != 4)                   return false;
		StringBuilder binaryString = new StringBuilder();
		for(int i = 0; i < length; i++){
			if(strs[i].equals(""))        return false;
			int num = Integer.parseInt(strs[i]);
			if(num < 0 || num >255)       return false;
			binaryString.append(getString(num));
		}
		/**
		 * �����һ�γ���1���������ڵ�һ�γ���0������ʱ��˵������������1��������0
		 * ����255.255.255.255 Ҳ����
		 */
		int firstZero  = binaryString.indexOf("0");
		int lastFirst  = binaryString.lastIndexOf("1");
		if(firstZero < lastFirst)         return false;
		else                              return true;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int typeA = 0;
		int typeB = 0;
		int typeC = 0;
		int typeD = 0;
		int typeE = 0;
		int errorIPOrMask = 0;
		int typePrivate = 0;
		while(input.hasNext()){
			String str = input.nextLine();
			String[] strs = str.split("~");
			String[] ip = strs[0].split("\\.");
			String[] mask = strs[1].split("\\.");
			if(!isIPStandard(ip) || !isMaskStandard(mask)) errorIPOrMask++;
			else{
				int num = Integer.parseInt(ip[0]);
			    if(num >= 1 && num <= 126){   
			    	typeA++;
			    	if(num == 10) typePrivate++;
			    }
			    else if(num >= 128 && num <= 191){ 
			    	typeB++;
			    	if(num == 172 && Integer.parseInt(ip[1]) >= 16 
			                      && Integer.parseInt(ip[1]) <= 31)
			    		typePrivate++;
			    }
			    else if(num >= 192 && num <= 223){
			    	typeC++;
			    	if(num == 192 && Integer.parseInt(ip[1]) == 168)
			    		typePrivate++;
			    }
			    else if(num >= 224 && num <= 239)   typeD++;
			    else if(num >= 240 && num <= 255)   typeE++;
			}
		}
		System.out.println(typeA + " " + typeB + " " + typeC + " " +typeD + " " 
		                 + typeE + " " + errorIPOrMask + " " + typePrivate);	
	}
}
