package com.special.spet;

import java.util.Scanner;

/** 
* 汽水瓶
* @author special
* @date 2017年9月13日 下午1:34:37
*/
public class Pro21 {
	
	/**
	 * 因为每3个空瓶可以换一个满的，所以小于等于3时只能喝一次
	 * 而大于3时，比如4，兑换3个空瓶喝完剩一个，加上自己剩的一个，再跟老板借一个满的，
	 * 喝完，最后3个换了满的还给老板。最后没空瓶子
	 * 比如5，兑换3个空瓶喝完剩一个，加上自己剩的两个，正好兑换一瓶喝完。最后只剩下一个空瓶子，只好没办法。
	 * 所以综上，可以得出若大于3时，并且减去3后是奇数，则可以喝  1 + (bottels - 3) / 2 + 1;
	 * 若大于3时，并且减去3后是偶数，则可以喝  1 + (bottels - 3) / 2;
	 * @param bottels
	 * @return
	 */
	public static int getNumbers(int bottels){
		if(bottels <= 3)                 return 1;
		else if((bottels - 3) % 2 == 0)  return 1 + (bottels - 3) / 2;
		else                             return 1 + (bottels - 3) / 2 + 1;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = 10;
		int count = 0;
		int[] numbers = new int[10];
		while(input.hasNext()){
			int bottels = input.nextInt();
			if(bottels == 0 || count >= 10)  break;
			else numbers[count++] = getNumbers(bottels);
		}
		for(int i = 0; i < count; i++)
			System.out.println(numbers[i]);
	}

}
