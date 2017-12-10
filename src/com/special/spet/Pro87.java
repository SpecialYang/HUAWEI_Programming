package com.special.spet;

import java.util.Scanner;

/** 
* 扑克牌比较大小
* @author special
* @date 2017年12月8日 上午8:47:27
*/
public class Pro87 {
	private static String[] orderedPoker = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
	
	public static int getKindOfPoker(String poker){
		String[] handPokers = poker.split(" ");
		int length = handPokers.length;
		if(length == 1) return 0;
		else if(length == 2){
			if(handPokers[0].equals("joker"))
				return 5;
			else return 1;
		}
		else if(length == 3) return 3;
		else if(length == 4) return 4;
		else if(length == 5) return 2;
		return -1;
	}
	
	private static int getOrder(String item){
		for(int i = 0; i < orderedPoker.length; i++)
			if(item.equals(orderedPoker[i]))
				return i;
		return -1;
	}
	public static void compare(String poker1, int kind1, String poker2, int kind2){
		String[] handPoker1 = poker1.split(" ");
		String[] handPoker2 = poker2.split(" ");
		String winner = null;
		if(kind1 == 5 || kind2 == 5 
				|| kind1 == 4 || kind2 == 4){  //大小王 和 炸弹
			if(kind1 < kind2) winner = poker2;
			else if(kind1 > kind2) winner = poker1;
			else if(kind1 == kind2){  //因为大小王不会同时出现，所以放心大胆的嗨起来
				if(getOrder(handPoker1[0]) > getOrder(handPoker2[0]))
					winner = poker1;
				else winner = poker2;
			}
		}
		else if(kind1 == kind2){ //顺子，三个，对子，单子
			if(getOrder(handPoker1[0]) > getOrder(handPoker2[0]))
				winner = poker1;
			else winner = poker2;
		}
		else winner = "ERROR";
		System.out.println(winner);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String[] pokers = str.split("-");
			int kind1 = getKindOfPoker(pokers[0]);
			int kind2 = getKindOfPoker(pokers[1]);
			compare(pokers[0],kind1,pokers[1],kind2);
		}
	}

}
