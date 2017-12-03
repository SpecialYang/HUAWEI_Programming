package com.special.spet;

import java.util.Scanner;

/** 
* 参数分析
* 输入字符串按照空格分隔开
* 如果用split会增加时间和空间上开销
* 所以我将在improve里优化
* @author special
* @date 2017年12月3日 上午10:10:15
*/
public class Pro73 {
	public static String[] parseCmds(String cmds){
		String[] result = cmds.split(" ");
		for(int i = 0; i < result.length; i++)
			if(result[i].charAt(0) == '“' || result[i].charAt(0) == '"')
				result[i] = result[i].substring(1, result[i].length() - 1);
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String cmds = input.nextLine();
			String[] parseCmds = parseCmds(cmds);
			System.out.println(parseCmds.length);
			for(String item : parseCmds)
				System.out.println(item);
		}
	}

}
