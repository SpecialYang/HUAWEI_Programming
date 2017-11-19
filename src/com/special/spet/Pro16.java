/*package com.special.spet;

import java.util.Scanner;


*
* @author special
* @date 2017��9��6�� ����5:35:09

class Point{
	private int x;
	private int y;
	private static final char[] INSTRUCT_LETTER = {'A', 'S', 'W', 'D'};
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	private static boolean contain(char ch){
		for(char item : INSTRUCT_LETTER)
			if(item == ch)
				return true;
		return false;
	}
	
	private static boolean isNum(char ch){
		if(ch >= '0' && ch <= '9')   return true;
		else                         return false;
	}
	public static boolean isStandard(String instruct){
		if(instruct.length() > 3 || !contain(instruct.charAt(0)))  { return false; }
		for(int i = 1; i < instruct.length(); i++)
			if(!isNum(instruct.charAt(i)))
				return false;
		return true;
	}
	
	 * ����ÿһ��ָ������ж��Ƿ�ϸ�
	 * @param instruct
	 * @return һ�����ƶ�����Point����
	 
	public static Point prestationOfInstruct(String instruct){
		Point target = new Point();
		if(!isStandard(instruct)) {return target;}
		int steps = Integer.parseInt(instruct.substring(1));
		switch(instruct.charAt(0)){
		case 'A': target.x = -steps;    break;
		case 'S': target.y = -steps;    break;
		case 'W': target.y =  steps;    break;
		case 'D': target.x =  steps;    break;
		}
		return target;
	}
	
	*//**
	 * ���ݲ������ƶ�����target��������ӣ�������ʵҲ��һ�ּӷ���
	 * @param target
	 *//*
	public void move(Point target){
		this.x += target.x;
		this.y += target.y;
	}
	
	@Override 
	public String toString(){
		return x + "," + y;
	}
}
public class Pro16 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String[] instructs = str.split(";");
			Point origin = new Point();
			for(String instruct : instructs)
				origin.move(Point.prestationOfInstruct(instruct));
			System.out.println(origin);
		}
	}
}*/