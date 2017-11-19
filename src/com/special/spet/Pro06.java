package com.special.spet;

import java.util.Scanner;

/**
* 此题虽然让求一个一个数的质因子，从而很容易让人去找小于等于这个数范围内的所有的质数
* 再一个一个除下去，这样很费时间
* 我们可以换个角度去做这个题，如果一个数是质数，那么它的倍数肯定不是
* 所以我们同样从i=2开始判断，如果整除，就使数本身缩小相应的倍数，同时保持i不变
* 只有无法整除时才使i递增，这样即使到了4，也是直接跳过的，因为我们已经把质因子为2提取完了 
* @author special
* @date 2017年9月4日 下午1:28:30
*/
public class Pro06 {
	
	public static String getResult(long inputNum){
		StringBuilder result = new StringBuilder();
		for(long i = 2;inputNum > 1;){
			if(inputNum % i == 0){
				inputNum /=i;
				result.append(i);
				result.append(" ");
			}
			else
				i++;
		}
		return result.toString();
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			long inputNum = input.nextLong();
			String result = getResult(inputNum);
			System.out.println(result);
		}
	}
}
