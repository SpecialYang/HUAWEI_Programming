package com.special.spet;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月6日 下午2:54:20
*/
public class Pro82 {
	private static int MAX_ROW = 10;
	private static int MAX_COL = 10;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int originRow = input.nextInt();
			int originCol = input.nextInt();
			int currentRow = originRow;
			int currentCol = originCol;
			if(originRow < 0 || originRow >= MAX_ROW || 
					originCol < 0 || originCol >= MAX_COL)
				System.out.println(-1);
			else System.out.println(0);
			int x1 = input.nextInt();
			int y1 = input.nextInt();
			int x2 = input.nextInt();
			int y2 = input.nextInt();
			if((x1 < 0 || x1 >= currentRow || y1 < 0 || y1 >= currentCol) || 
					(x2 < 0 || x2 >= currentRow || y2 < 0 || y2 >= currentCol))
				System.out.println(-1);
			else System.out.println(0);
			int stayInsertRow = input.nextInt();
			if(stayInsertRow >= 0 && stayInsertRow < MAX_ROW - 1 
					              && stayInsertRow <= currentRow - 1){
				currentRow++;
				System.out.println(0);
			}else System.out.println(-1);
			int stayInsertCol = input.nextInt();
			if(stayInsertCol >= 0 && stayInsertCol < MAX_COL - 1 
								  && stayInsertCol <= currentCol - 1){
				currentCol++;
				System.out.println(0);
			}else System.out.println(-1);
			int x = input.nextInt();
			int y = input.nextInt();
			if(x < 0 || x >= originRow || y < 0 || y >= originCol)
				System.out.println(-1);
			else System.out.println(0);
		}
	}
}
