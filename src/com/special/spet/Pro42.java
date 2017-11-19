package com.special.spet;

import java.util.Scanner;
import java.util.Stack;

/** 
* ���Թ�
* ��Ŀ˵�Ľ�����һ��ͨ��������ֱ��dfs�Ϳ���
* ��ΪҪ���·��������Ҫע����ջ������·��
* �˴��Ҳ�����2��ջ��һ����������꣬��һ������������
* ��������ʱ�Ҳ����˵�����ջ���������Ա�֤����������
* @author special
* @date 2017��10��24�� ����2:38:09
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
			 * ����result����֦
			 */
			if(tempX < 0 || tempX > endX || tempY < 0 || tempY > endY
			|| map[tempX][tempY] == 1 || flag[tempX][tempY] == 1)
				continue;
			else{
				flag[tempX][tempY] = 1;
				dfs(tempX,tempY);
				/**
				 * ����ʱ����ջ
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
