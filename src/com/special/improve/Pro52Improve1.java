package com.special.improve;

import java.util.Scanner;

/** 
* 递归实现，很牛逼啊
* 其实还是map[i][j] = map[i - 1][j - 1] + map[i - 1][j - 2] + map[i - 1][j]
* Java执行好慢，C++代码6ms
* @author special
* @date 2017年11月23日 上午8:37:43
*/
public class Pro52Improve1 {
	
	public static int isEven(int row, int col){
		if(col == 1) return 1;
		if(row < 1 || col > 2 * row - 1) return 0;
		else return isEven(row - 1, col - 2) + isEven(row - 1, col - 1) + isEven(row - 1, col);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			boolean flag = false;
			for(int i = 1; i <= n; i++){
				if(isEven(n,i) % 2 == 0){
					flag = true;
					System.out.println(i);
					break;
				}
			}
			if(!flag) System.out.println(-1);
		}
	}

}
