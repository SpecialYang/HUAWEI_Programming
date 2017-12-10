package com.special.spet;

import java.util.Scanner;

/** 
* 一个byte中连续的1的个数
* 
* 移位运算即可
* 注意移位运算的时候，byte,char,short会统一变为int型
* 切记切记，否则在进行负数的连续1的记录时，出现意想不到的结果
* 我不知道此题是什么意思啊，要求时byte的类型，为什么输入byte会错误。
* @author special
* @date 2017年12月7日 下午2:14:57
*/
public class Pro85 {
	public static int getNumOfContinuousOne(int num){
		int result = 0;
		int tempResult = 0;
		int tempNum = num;
		while(tempNum != 0){
			if((tempNum & 1) == 1)
				tempResult++;
			else{
				/**
				 * 遇到0时才判断当前是否最大
				 */
				if(result < tempResult) result = tempResult;
				tempResult = 0;
			}
			tempNum >>>= 1;
		}
		/**
		 * 可能首位为0也就是1开头的正数，所以最后一次的连续1记录未来得及与最大比较
		 */
		if(result < tempResult) result = tempResult;
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			int result = getNumOfContinuousOne(num);
			System.out.println(result);
		}
	}

}
