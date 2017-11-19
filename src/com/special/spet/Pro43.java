package com.special.spet;

import java.util.Scanner;

/** 
* 数独
* 1.处理9宫格坐标转换的技巧
* 2.dfs处理结束递归的技巧
* @author special
* @date 2017年10月24日 下午4:26:49
*/
public class Pro43 {
	private static int[][] map = new int[9][9];
	private static boolean flag;
	private static boolean check(int n, int x, int y){
		for(int i = 0; i < 9; i++)
			if(map[i][y] == n)
				return false;
		for(int i = 0; i < 9; i++)
			if(map[x][i] == n)
				return false;
		/**
		 * 获得第几个九宫格
		 */
		x = x / 3 * 3;
		y = y / 3 * 3;
		for(int i = x; i < x + 3; i++)
			for(int j = y; j < y + 3; j++)
				if(map[i][j] == n)
					return false;
		return true;
	}
	public static void dfs(int x, int y){
		if(x == 9 && y == 0){
			flag = true;
			return;
		}
		if(map[x][y] == 0){
			for(int i = 1; i <= 9; i++){
				if(check(i,x,y)){
					map[x][y] = i;
					if(y + 1 >= 9) dfs(x + 1, 0);
					else           dfs(x, y + 1);
					if(flag) return;  //如果已经有答案了，结束函数
					map[x][y] = 0;
				}
			}
		}
		else{
			if(y + 1 >= 9) dfs(x + 1, 0);
			else           dfs(x, y + 1);
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			flag = false;
			for(int i = 0; i < 9; i++)
				for(int j = 0; j < 9; j++)
					map[i][j] = input.nextInt();
			dfs(0,0);
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 8; j++)
					System.out.print(map[i][j] + " ");
				System.out.println(map[i][8]);
			}
		}
	}
}
