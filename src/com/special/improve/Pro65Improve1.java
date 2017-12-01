package com.special.improve;

import java.util.Scanner;

/** 
* 也可以使用startWith用来判断一个字符串是否是另一个字符串的前缀
* @author special
* @date 2017年11月30日 上午11:56:59
*/
public class Pro65Improve1 {
	public static String[] cmds = {"reset","reset board","board add","board delet"
			,"reboot backplane","backplane abort"}; //命令集
	public static String[] res = {"reset what","board fault","where to add","no board at all",
			"impossible","install first","unkown command"};//结果集
	/**
	 * 判断是否匹配，从头开始，不是单纯的包含关系，首字母必须相同
	 * @param originCmd
	 * @param objectCmd
	 * @return
	 */
	public static boolean isMatch(String originCmd,String objectCmd){
		for(int i = 0; i < objectCmd.length(); i++)
			if(originCmd.charAt(i) != objectCmd.charAt(i))
				return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String cmd = input.nextLine();
			String[] inputCmds = cmd.split(" ");
			int resIndex = res.length - 1;
			boolean flag = false; //上一次是否匹配成功
			for(int i = 0; i < cmds.length; i++){  //把输入指令与指令集一一比较
				String[] originCmds = cmds[i].split(" ");
				boolean isAllMatch = true;
				if(originCmds.length == inputCmds.length){
					for(int j = 0; j < originCmds.length; j++)
						/*
						if(!isMatch(originCmds[j],inputCmds[j])){
							isAllMatch = false;
							break;
						}*/
						if(!originCmds[j].startsWith(inputCmds[j])){
							isAllMatch = false;
							break;
						}
					if(isAllMatch && !flag){
						resIndex = i;
						flag = true;
					}
					else if(isAllMatch && flag){
						resIndex = res.length - 1;
						break;
					}
				}
			}
			System.out.println(res[resIndex]);
		}
	}
}
