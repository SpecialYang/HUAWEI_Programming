package com.special.spet;

import java.util.Scanner;

/** 
* ��������
* �����ַ������տո�ָ���
* �����split������ʱ��Ϳռ��Ͽ���
* �����ҽ���improve���Ż�
* @author special
* @date 2017��12��3�� ����10:10:15
*/
public class Pro73 {
	public static String[] parseCmds(String cmds){
		String[] result = cmds.split(" ");
		for(int i = 0; i < result.length; i++)
			if(result[i].charAt(0) == '��' || result[i].charAt(0) == '"')
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
