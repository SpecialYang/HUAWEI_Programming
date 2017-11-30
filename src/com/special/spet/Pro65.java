package com.special.spet;

import java.util.Scanner;

/** 
* 配置文件恢复
* @author special
* @date 2017年11月30日 上午11:15:11
*/
public class Pro65 {
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
			int resIndex = 6;
			String[] inputCmds = cmd.split(" ");
			if(inputCmds.length == 1 )   //若只输入了一个字符串，则只需判断是否匹配reset
				resIndex = isMatch(cmds[0],cmd) ? 0 : 6;
			else {
				boolean flag = false; //判断上一次是否匹配成功
				for(int i = 1; i < 6; i++){ //对指令集中每一个指令看是否匹配
					String[] temp = cmds[i].split(" ");
					if(isMatch(temp[0],inputCmds[0]) && isMatch(temp[1],inputCmds[1])){ //匹配成功
						if(!flag){ //第一次匹配成功
							flag = true;
							resIndex = i;
						}
						else{ //第二次匹配成功的话，说明结果不唯一了，就要退出了
							resIndex = 6;
							break;
						}
					}
				}
			}
			System.out.println(res[resIndex]);
		}
	}

}
