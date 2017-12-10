package com.special.spet;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017��12��9�� ����9:46:31
*/
public class Pro89 {
	public static boolean isNum(char ch) { return ch >= '0' && ch <= '9'; }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String[] ips = str.split("\\.");
			if(ips.length != 4)
				System.out.println("NO");
			else{
				boolean flag = false;
				for(int i = 0; i < ips.length; i++){
					int temp = 0;
					int index = 0;
					while(index < ips[i].length() && isNum(ips[i].charAt(index)))
						temp = temp * 10 + (ips[i].charAt(index++) - '0');
					if(index < ips[i].length() || temp > 255){ //����ĳ����λ���ַ����ֻ��߷�Χ��������
						flag = true;
						break;
					}
				}
				if(!flag) System.out.println("YES");
				else      System.out.println("NO");
			}
		}
	}

}
