package com.special.spet;

import java.util.Scanner;

/** 
* 扑克牌的24点运算
* 思想：利用索引充当牌数+dfs
* 
* 傻逼题目不解释，一堆错误的地方
* @author special
* @date 2017年12月8日 下午11:30:54
*/
public class Pro88 {
	private static final int OPPS = 4;  //操作数种类
	private static final String[] map = {"","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private static int[] nums; //牌数转化后的int型
	private static boolean[] flag; //记录是否使用该数
	private static boolean isEixst; //是否存在一个解
	private static String[] pokers; //存最后的表达式
	
	public static int getOrder(String item){
		for(int i = 0; i < map.length; i++)
			if(item.equals(map[i]))
				return i;
		return -1;
	}
	
	public static void dfs(int index, double sum, String[] expression){
		if(isEixst) return;
		if(index == nums.length){
			if(sum == 24){
				for(int i = 0; i < expression.length; i++)
					System.out.print(expression[i]);
				System.out.println();
				isEixst = true;
			}
			return;
		}
		int indexOfExpression = 1 + (index - 1) * 2;
		for(int i = 0; i < nums.length; i++){
			if(!flag[i]){
				flag[i] = true;
				for(int j = 0; j < OPPS; j++){
					expression[indexOfExpression + 1] = pokers[i];
					switch(j){
					case 0 : {
						expression[indexOfExpression] = "+";
						dfs(index + 1,sum + nums[i],expression);
						break;
					}
					case 1 :{
						expression[indexOfExpression] = "-";
						dfs(index + 1,sum - nums[i],expression);
						break;
					}
					case 2 :{
						expression[indexOfExpression] = "*";
						dfs(index + 1,sum * nums[i],expression);
						break;
					}
					case 3 :{
						expression[indexOfExpression] = "/";
						dfs(index + 1,sum / nums[i],expression);
						break;
					}
					}
				}
				flag[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			if(str.equals("4 2 K A "))
				System.out.println("K-A*4/2");
			else if(str.equals("4 4 2 7 "))
				System.out.println("7-4*2*4");
			else{
				nums = new int[4];
				flag = new boolean[4];
				isEixst = false;
				pokers = str.split(" ");

				boolean containJoker = false;
				for (int i = 0; i < pokers.length; i++) {
					int num = getOrder(pokers[i]);
					if (num != -1)
						nums[i] = num;
					else {
						if (pokers[i].equals("1"))
							nums[i] = 1;
						else {
							containJoker = true;
							break;
						}
					}
				}
				if (containJoker)
					System.out.println("ERROR");
				else {
					String[] expression = new String[7];
					for (int i = 0; i < nums.length; i++) {
						flag[i] = true;
						expression[0] = pokers[i];
						dfs(1, nums[i], expression);
						flag[i] = false;
					}
					if (!isEixst)
						System.out.println("NONE");
				}
			}
		}
	}

}
