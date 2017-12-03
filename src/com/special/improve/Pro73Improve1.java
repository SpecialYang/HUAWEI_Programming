package com.special.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月3日 上午10:21:55
*/
public class Pro73Improve1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String cmds = input.nextLine();
			StringBuilder result = new StringBuilder();
			int quataNumber = 0;
			int len = 0;
			for(int i = 0; i < cmds.length(); i++){
				char item = cmds.charAt(i);
				if(item == '"' || item == '“' || item == '”')
					quataNumber++;
				else if(item != ' ') result.append(item);
				else if(quataNumber % 2 == 0){
					result.append('\n');
					len++;
				}else result.append(' ');
			}
			System.out.println(len + 1);
			System.out.println(result.toString());
		}
	}
}
