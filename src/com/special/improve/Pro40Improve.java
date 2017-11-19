package com.special.improve;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/** 
* Q[i] = Q[i - 1] + j * weight[i]
* 即每加进一个砝码已有的进行相加，若相加后的重量之前不存在，则加进来
* 若相加后的重量之前存在，则丢弃。
* @author special
* @date 2017年10月18日 下午5:48:19
*/	
public class Pro40Improve {
	public static int getKinds(int n, int[] weight, int[] number){
		Set<Integer> weights = new HashSet<Integer>();
		weights.add(0);
		for(int i = 0; i < n; i++){
			List<Integer> temp = new ArrayList<Integer>(weights);
			for(int j = 1; j <= number[i]; j++)
				for(int k = 0; k < temp.size(); k++){
					int tempWeight = temp.get(k) + j * weight[i];
					weights.add(tempWeight);
				}
		}
		return weights.size();
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] weight = new int[n];
			int[] number = new int[n];
			for(int i = 0; i < n; i++)
				weight[i] = input.nextInt();
			for(int i = 0; i < n; i++)
				number[i] = input.nextInt();
			int result = getKinds(n,weight,number);
			System.out.println(result);
		}
	}

}
