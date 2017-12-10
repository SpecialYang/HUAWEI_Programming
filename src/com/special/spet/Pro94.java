package com.special.spet;

import java.util.Scanner;

/** 
* 钱化为中文钱币
* @author special
* @date 2017年12月10日 下午4:04:09
*/
public class Pro94 {
	private static String[] units = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
	
	private static String decompose(int temp){
		StringBuilder sb = new StringBuilder();
		int qian = temp / 1000;
		int bai  = temp % 1000 / 100;
		int shi  = temp % 100 / 10;
		int ge   = temp % 10;
		if(qian != 0)
			sb.append(units[qian] + "仟");
		if(bai != 0)
			sb.append(units[bai] + "佰");
		if(shi != 0){
			if(qian != 0 && bai == 0)
				sb.append("零");
			if(shi == 1)
				sb.append("拾");
			else
				sb.append(units[shi] + "拾");
		}
		if(ge != 0){
			if((qian != 0 || bai != 0) && shi == 0)
				sb.append("零");
			sb.append(units[ge]);
		}
		return sb.toString();
	}
	
	private static String solveInteger(int integer){
		StringBuilder sb = new StringBuilder();
		sb.append("人民币");
		int temp = integer / 100000000;
		integer %= 100000000;
		if(temp != 0)
			sb.append(decompose(temp) + "亿");
		temp = integer / 10000;
		integer %= 10000;
		if(temp != 0)
			sb.append(decompose(temp) + "万");
		if(integer != 0)
			sb.append(decompose(integer) + "元");
		return sb.toString();
	}
	private static String solveDecimal(double decimal){
		StringBuilder sb = new StringBuilder();
		int n1 = (int) (decimal * 10);
		int n2 = (int) (decimal * 100) % 10;
		if(n1 == 0 && n2 == 0)
			sb.append("整");
		if(n1 > 0)
			sb.append(units[n1] + "角");
		if(n2 > 0)
			sb.append(units[n2] + "分");
		return sb.toString();
	}
	
	public static String solve(double rmb){
		StringBuilder sb = new StringBuilder();
		int integer = (int) rmb;
		sb.append(solveInteger(integer));
		double decimal = rmb + 0.0001 - integer; //加上0.0001是为了防止破坏精度
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
