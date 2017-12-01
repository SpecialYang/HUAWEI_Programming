package com.special.improve;

import java.util.Scanner;

/** 
* Ҳ����ʹ��startWith�����ж�һ���ַ����Ƿ�����һ���ַ�����ǰ׺
* @author special
* @date 2017��11��30�� ����11:56:59
*/
public class Pro65Improve1 {
	public static String[] cmds = {"reset","reset board","board add","board delet"
			,"reboot backplane","backplane abort"}; //���
	public static String[] res = {"reset what","board fault","where to add","no board at all",
			"impossible","install first","unkown command"};//�����
	/**
	 * �ж��Ƿ�ƥ�䣬��ͷ��ʼ�����ǵ����İ�����ϵ������ĸ������ͬ
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
			boolean flag = false; //��һ���Ƿ�ƥ��ɹ�
			for(int i = 0; i < cmds.length; i++){  //������ָ����ָ�һһ�Ƚ�
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
