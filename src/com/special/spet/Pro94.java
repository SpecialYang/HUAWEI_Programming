package com.special.spet;

import java.util.Scanner;

/** 
* Ǯ��Ϊ����Ǯ��
* @author special
* @date 2017��12��10�� ����4:04:09
*/
public class Pro94 {
	private static String[] units = {"��","Ҽ","��","��","��","��","½","��","��","��"};
	
	private static String decompose(int temp){
		StringBuilder sb = new StringBuilder();
		int qian = temp / 1000;
		int bai  = temp % 1000 / 100;
		int shi  = temp % 100 / 10;
		int ge   = temp % 10;
		if(qian != 0)
			sb.append(units[qian] + "Ǫ");
		if(bai != 0)
			sb.append(units[bai] + "��");
		if(shi != 0){
			if(qian != 0 && bai == 0)
				sb.append("��");
			if(shi == 1)
				sb.append("ʰ");
			else
				sb.append(units[shi] + "ʰ");
		}
		if(ge != 0){
			if((qian != 0 || bai != 0) && shi == 0)
				sb.append("��");
			sb.append(units[ge]);
		}
		return sb.toString();
	}
	
	private static String solveInteger(int integer){
		StringBuilder sb = new StringBuilder();
		sb.append("�����");
		int temp = integer / 100000000;
		integer %= 100000000;
		if(temp != 0)
			sb.append(decompose(temp) + "��");
		temp = integer / 10000;
		integer %= 10000;
		if(temp != 0)
			sb.append(decompose(temp) + "��");
		if(integer != 0)
			sb.append(decompose(integer) + "Ԫ");
		return sb.toString();
	}
	private static String solveDecimal(double decimal){
		StringBuilder sb = new StringBuilder();
		int n1 = (int) (decimal * 10);
		int n2 = (int) (decimal * 100) % 10;
		if(n1 == 0 && n2 == 0)
			sb.append("��");
		if(n1 > 0)
			sb.append(units[n1] + "��");
		if(n2 > 0)
			sb.append(units[n2] + "��");
		return sb.toString();
	}
	
	public static String solve(double rmb){
		StringBuilder sb = new StringBuilder();
		int integer = (int) rmb;
		sb.append(solveInteger(integer));
		double decimal = rmb + 0.0001 - integer; //����0.0001��Ϊ�˷�ֹ�ƻ�����
		sb.append(solveDecimal(decimal));
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			double rmb = input.nextDouble();
			String rmbStr = solve(rmb);
			System.out.println(rmbStr);
		}
	}

}
