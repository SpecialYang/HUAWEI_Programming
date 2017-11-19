package com.special.spet;

import java.util.Scanner;

/** 
* 学英语
* 记录每一位对应的单位名
* 1到19的英文表示
* @author special
* @date 2017年10月19日 下午10:30:41
*/
public class Pro41 {
	private static final String[] map1 = {"","one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", 
									"thirteen" ,"fourteen", "fifteen", "seventeen", "eighteen", "nineteen"};
	private static final String[] map2 = {"hundred","redix","million","hundred","redix","thousand","hundred","redix",""};
	private static final String[] map3 = {"","","twenty", "thirty", "forty","fifty","sixty","seventy","eighty","ninety"};
	private static int[] getDigit(long number){
		int[] result = new int[9];
		int index = 8;
		while(number != 0){
			int temp = (int) (number % 10);
			number /= 10;
			result[index--] = temp;
		}
		return result;
	}
	public static String getString(long number){
		if(number >= 1000000000 || number <= 0)
			return "error";
		int[] digit = getDigit(number);
		int index = 0;
		for(; index < 9; index++){
			if(digit[index] != 0)
				break;
		}
		StringBuilder result = new StringBuilder();
		for(int i = index; i < 9; i++){
			int temp = digit[i];
			if(temp == 0){
				if(i != 3 && i != 5)
					continue;
				else{
					if(digit[i - 2] == 0 && digit[i - 1] == 0)
						continue;
				}
			}
			if(map2[i].equals("hundred")){
				result.append(map1[temp] + " hundred ");
				if(digit[i + 1] != 0 || digit[i + 2] != 0)
					result.append("and ");
			}
			else if(map2[i].equals("redix")){
				if(temp == 1){
					int newNumber = temp * 10 + digit[++i];
					result.append(map1[newNumber] + " " + map2[i] + " ");
				}
				else
					result.append(map3[temp] + " ");
			}
			else {
				if(temp != 0)
					result.append(map1[temp] + " ");
				result.append(map2[i] + " ");
			}	
		}
		return result.toString().trim();
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			long number = input.nextLong();
			String result = getString(number);
			System.out.println(result);
		}

	}

}
