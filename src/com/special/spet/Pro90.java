package com.special.spet;

import java.util.Scanner;

/** 
* 棋盘走路有多少种解法
* 笨方法，dfs
* @author special
* @date 2017年12月9日 上午10:44:05
*/
public class Pro90 {
	private static int[][] step = new int[][]{{1,0},{0,1}};
	private static boolean[][] flag;
	private static int startX,startY,endX,endY;
	private static int kind;
	
	private static boolean isProper(int x, int y){ return !(x > endX || y > endY); }
	
	public static void dfs(int x, int y){
		if(x == endX && y == endY){
			kind++;
			return;
		}
		for(int i = 0; i < 2; i++){
			int tempX = x + step[i][0];
			int tempY = y + step[i][1];
			if(isProper(tempX,tempY) && !flag[tempX][tempY]){
				flag[tempX][tempY] = true;
				dfs(tempX,tempY);
				flag[tempX][tempY] = false;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			
			flag = new boolean[n + 1][m + 1];
			startX = 0;
			startY = 0;
			endX = n;
			endY = m;
			kind = 0;
			
			flag[startX][startY] = true;
			dfs(startX,startY);
			System.out.println(kind);
		}
	}

}
