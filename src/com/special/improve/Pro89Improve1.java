package com.special.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月9日 上午10:14:30
*/
public class Pro89Improve1 {
	private static boolean isNum(char ch){ return ch >= '0' && ch <= '9'; }
	public static boolean isValidIp(String ip){
		int temp = 0;
		int count = 0;
		boolean flag = true;
		int countOfFra = 0;
		for(int i = 0; i < ip.length(); i++){
			char item = ip.charAt(i);
			if(isNum(item)){
				temp = temp * 10 + (item - '0');
				countOfFra++;
			}
			else if(countOfFra > 0 && item == '.'){
				if(temp > 255){
					flag = false;
					break;
				}
				temp = 0;
				count++;
				countOfFra = 0;
			}else{
				flag = false;
				break;
			}
		}
		if(countOfFra == 0 || temp > 255 || count != 3)
			flag = false;
		return flag;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			if(isValidIp(str))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
