package com.special.spet;

import java.util.Scanner;

/** 
* IP地址分类和IP和子网掩码格式判断
* 此题非常考验细心和编码能力，可惜我失败了
* 此题有以下注意点：
* 1.注意一个ip地址属于A类和私有类，都要加一
* 2.若ip和掩码任意一个出错，则仅加一
* 3.注意在对掩码化为二进制字符串的时候，若使用toBinaryString,注意前向加0补充位数！！！
* @author special
* @date 2017年9月10日 下午7:03:40
*/
public class Pro19 {
	
	/**
	 * 判断IP地址是否合法，仅需判断是否为空和数值范围即可
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
	 * 得到掩码每一块的8位二进制表示法
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
	  * 判断掩码是否合法，需判断是否为空和数值范围，还有是否是连续的1加连续的0
	  * 此题需要格外
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
		 * 若最后一次出现1的索引大于第一次出现0的索引时，说明不是连续的1加连续的0
		 * 对于255.255.255.255 也适用
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
