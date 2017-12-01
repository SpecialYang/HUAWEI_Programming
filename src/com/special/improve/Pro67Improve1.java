package com.special.improve;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* 成绩排序
* 通过设置一个桶，大小为100
* 然后每个桶位为一个链表，存放相同成绩的人
* 注意定义好数组后，应该对数组每一项进行初始化，
* 我们只是在堆中分配了空间（数据被请理为二进制0），但未填充数据。
* @author special
* @date 2017年12月1日 上午9:27:25
*/
public class Pro67Improve1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int sortKind = input.nextInt();
			List<String>[] bucket = new ArrayList[101];
			for(int i = 0; i < 101; i++)
				bucket[i] = new ArrayList<String>();
			for(int i = 0; i < n; i++){
				String name = input.next();
				int grade = input.nextInt();
				bucket[grade].add(name);
			}
			if(sortKind == 0){
				for (int i = 100; i >= 0; i--)
					for (int j = 0; j < bucket[i].size(); j++)
						System.out.println(bucket[i].get(j) + " " + i);
			}
			else{
				for(int i = 1; i < 101; i++)
					for(int j = 0; j < bucket[i].size(); j++)
						System.out.println(bucket[i].get(j) + " " + i);
			}
		}
	}
}
