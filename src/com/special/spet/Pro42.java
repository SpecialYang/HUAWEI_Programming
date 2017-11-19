package com.special.spet;

import java.util.Scanner;
import java.util.Stack;

/** 
* 走迷宫
* 题目说的仅存在一条通道，所以直接dfs就可以
* 因为要输出路径，所以要注意用栈来保存路径
* 此处我采用了2个栈，一个保存横坐标，另一个保存纵坐标
* 保存坐标时我才用了倒序入栈，这样可以保证输出是正序的
* @author special
* @date 2017年10月24日 下午2:38:09
*/
public class Pro42 {
	private static int[][] map;
	private static int[][] flag;
	private static int[][] coordinates = {{-1,0},{0,1},{1,0},{0,-1}};
	private static int startX,startY,endX,endY;
	private static Stack<Integer> loadX;
	private static Stack<Integer> loadY;
	private static boolean result;
	public static void dfs(int x, int y){
		if(x == endX && y == endY){
			result = true;
			return;
		}
		for(int i = 0; i < 4; i++){
			int tempX = x + coordinates[i][0];
			int tempY = y + coordinates[i][1];
			/**
			 * 利用result来剪枝
			 */
			if(tempX < 0 || tempX > endX || tempY < 0 || tempY > endY
			|| map[tempX][tempY] == 1 || flag[tempX][tempY] == 1)
				continue;
			else{
				flag[tempX][tempY] = 1;
				dfs(tempX,tempY);
				/**
				 * 回溯时才入栈
				 */
				if(result){
					loadX.push(tempX);
					loadY.push(tempY);
					return;
				}
				flag[tempX][tempY] = 0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			map = new int[n][m];
			flag = new int[n][m];
			loadX = new Stack<Integer>();
			loadY = new Stack<Integer>();
			result = false;
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					map[i][j] = input.nextInt();
			startX = 0;   startY = 0;
			endX = n - 1; endY = m - 1;
			flag[startX][startY] = 1;
			dfs(startX,startY);
			loadX.push(startX);
			loadY.push(startY);
			while(!loadX.isEmpty())
				System.out.println("(" + loadX.pop() + "," + loadY.pop() + ")");
		}
	}

}
