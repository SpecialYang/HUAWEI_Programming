package com.special.spet;

import java.util.Scanner;

/** 
* �����ļ��ָ�
* @author special
* @date 2017��11��30�� ����11:15:11
*/
public class Pro65 {
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
			int resIndex = 6;
			String[] inputCmds = cmd.split(" ");
			if(inputCmds.length == 1 )   //��ֻ������һ���ַ�������ֻ���ж��Ƿ�ƥ��reset
				resIndex = isMatch(cmds[0],cmd) ? 0 : 6;
			else {
				boolean flag = false; //�ж���һ���Ƿ�ƥ��ɹ�
				for(int i = 1; i < 6; i++){ //��ָ���ÿһ��ָ��Ƿ�ƥ��
					String[] temp = cmds[i].split(" ");
					if(isMatch(temp[0],inputCmds[0]) && isMatch(temp[1],inputCmds[1])){ //ƥ��ɹ�
						if(!flag){ //��һ��ƥ��ɹ�
							flag = true;
							resIndex = i;
						}
						else{ //�ڶ���ƥ��ɹ��Ļ���˵�������Ψһ�ˣ���Ҫ�˳���
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
