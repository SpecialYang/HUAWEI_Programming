package com.special.spet;

import java.util.Scanner;

/** 
* 杨辉三角变形
* 注意每一行的规律，每一行有2 * i - 1个数，中间的数位于第i个位置
* 从第1行开始比较后面的计算
* map[i][j] = map[i - 1][j - 1] + map[i - 1][j - 2] + map[i - 1][j]
* 注意若采用上式，在算map[i][1]直接赋值，否则map[i - 1][j - 2]会数组越界
* 判断第几位是偶数时，只需循环到中间位置即可，因为每一行的数是对称的。
* @author special
* @date 2017年11月22日 下午11:15:13
*/
public class Pro52 {
	public static int getFirstPlaceEven(int n){
		int[][] map = new int[n + 1][2*n];
		map[1][1] = 1;
		for(int i = 2; i <= n; i++){
			map[i][1] = 1;
			for(int j = 2; j <= 2 * i - 1; j++)
				map[i][j] = map[i - 1][j - 1] + map[i - 1][j - 2] + map[i - 1][j];
		}
		for(int i = 1; i <= n; i++)
			if(map[n][i] % 2 == 0)
				return i;
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int firstEven = getFirstPlaceEven(n);
			System.out.println(firstEven);
		}
	}

}
