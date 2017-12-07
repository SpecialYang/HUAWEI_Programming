package com.special.spet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* 真分数化为埃及分数的方法
* 分子为1的分数称为埃及分数。
* 现输入一个真分数(分子比分母小的分数，叫做真分数)，
* 请将该分数分解为埃及分数。
* 如：8/11 = 1/2+1/5+1/55+1/110。
* 
* 算法步骤如下：分子用a表示，分母用b表示
* （1）判断a是否等1，若等于1，则跳转到第4步；不等于1继续下一步；
* （2）判断b是否能整除a-1,若可以，则令a = 1,并把1/b添加到表达式中，跳转到第4步；否则继续下一步
* （3）令c = a / b + 1,并把1/c添加到表达式中，
* 更新a,b的值，a = a - a % b, b = b * c;若此时b能整数a,则令b /= a; a = 1;执行第一步
* （4）把a（其实就是1）/b添加到表达式末尾
* @author special
* @date 2017年12月6日 上午9:44:36
*/
public class Pro81 {
	private static List<Integer> denominators;
	
	public static void decompose(int molecule, int denominator){
		int a = molecule, b = denominator;
		while(a != 1){
			if(b % (a - 1) == 0){
				denominators.add(b / (a - 1));
				a = 1;
			}
			else{
				int c = b / a + 1;
				a = a - b % a;
				b = b * c;
				denominators.add(c);
				if(b % a == 0){
					b /= a;
					a = 1;
				}
			}
		}
		denominators.add(b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String grade = input.nextLine();
			String nums[] = grade.split("/");
			
			int molecule = Integer.parseInt(nums[0]);
			int denominator = Integer.parseInt(nums[1]);
			denominators = new ArrayList<>();
			decompose(molecule,denominator);
			for(int i = 0; i < denominators.size(); i++)
				if(i != denominators.size() - 1)
					System.out.print("1/" + denominators.get(i) + "+");
				else
					System.out.println("1/" + denominators.get(i));
		}
	}

}
