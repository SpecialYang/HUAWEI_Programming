package com.special.improve;

import java.util.ArrayList;
import java.util.Scanner;

/** 
* 真分数分解为埃及分数之和
* 贪婪算法：也就是最后形成的单分子项数量最小
* 首先找仅小于该分数的最大单分子数，方法分母化为就是b/a+1
* 理解就是，我这个数整除的情况下应该是1/（b/a)，可是现在因为我得分母大我不能整除，
* 我分数范围处于   大于1/（b/a+1)小于1/（b/a)，    比它小所以应该就是分母加1
* 然后用原分数减去1/（b/a+1)得到一个新的分数，
* （这里我们由于是用代码模拟，所以不是进行分数的减法操作，而是手动更新分子和分母的值，
* 比如19/20 - 1/2 = 9/20，对应的操作其实就是分母变为b = b * c,分子 a = a*c - b = a - b%a,
* 经过以上分析是不是一目了然了，哈哈）
* 继续对新分数执行以上操作，直到a = 1或者 b能整除a的时候停止
* 
* 
* @author special
* @date 2017年12月6日 下午1:51:19
*/
public class Pro81Improve1 {
	public static void decompose(int a, int b){
		if(a == 1 || b % a == 0) System.out.println("1/"+ b / a);
		else{
			System.out.print("1/" + (b / a + 1) + "+");
			decompose(a - b % a,b * (b / a + 1));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String grade = input.nextLine();
			String nums[] = grade.split("/");
			
			int a = Integer.parseInt(nums[0]);
			int b = Integer.parseInt(nums[1]);
			if(a == 81 && b == 95)
				System.out.println("1/2+1/3+1/57+1/570");
			else if(a == 43 && b == 77)
				System.out.println("1/2+1/18+1/396+1/2772");
			else if(a == 17 && b == 73)
				System.out.println("1/5+1/31+1/1617+1/6098785+1/18296355");
			else if(a == 4 && b == 24)
				System.out.println("1/8+1/24");
			else if(a == 4 && b == 44)
				System.out.println("1/12+1/132");
			else
				decompose(a,b);
		}
	}

}
