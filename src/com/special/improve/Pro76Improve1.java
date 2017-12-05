package com.special.improve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** 
* 火车进站问题
* 此法产生的全排列是有序的
* 思想为填坑法：
* 
* @author special
* @date 2017年12月5日 上午10:37:33
*/
public class Pro76Improve1 {
	private static boolean[] flag;
	private static List<int[]> outsInt;
	private static int[] orderedIn;
	
	public static void permutation(int[] num, int index){
		if(index == num.length){
			/**
			 * 集合中存入数据时，注意对象引用啊，很容易造成存的是同一个引用的值
			 * 这里利用数组的copyOf拷贝了一个数组
			 */
			int[] out = Arrays.copyOf(num,num.length);
			outsInt.add(out);
			return;
		}
		for (int i = 0; i < num.length; i++)
			if(!flag[orderedIn[i]]){
				flag[orderedIn[i]] = true;
				num[index] = orderedIn[i];
				permutation(num, index + 1);
				flag[orderedIn[i]] = false;
			}
	}
	
	public static boolean isProper(int[] in, int[] out){
		int i = 0, j = 0;
		Stack<Integer> stack = new Stack<>(in.length);
		/*
		while(j < out.length){
			while(stack.isEmpty() || stack.top() != out[j]){
				if(i == in.length) return false;
				stack.push(in[i++]);
			}
			while(!stack.isEmpty() && stack.top() == out[j]){
				stack.pop();
				j++;
			}
		}*/
		for(i = 0; i < in.length; i++){
			stack.push(in[i]);
			while(!stack.isEmpty() && stack.top() == out[j]){
				stack.pop();
				j++;
			}
		}
		while(!stack.isEmpty() && stack.top() == out[j]){
			stack.pop();
			j++;
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] in = new int[n];
			outsInt = new ArrayList<>();
			int maxLen = 0;
			
			for(int i = 0; i < n; i++){
				in[i] = input.nextInt();
				if(maxLen < in[i]) maxLen = in[i];
			}
			flag = new boolean[maxLen + 1];
			//因为第一个参数是存我们的输出结果，然后要新建一个新的数组
			orderedIn = Arrays.copyOf(in, n);
			Arrays.sort(orderedIn);
			permutation(new int[n],0);
			
			for(int[] out : outsInt){
				if(isProper(in,out)){
					for(int i = 0; i < n; i++)
						if(i != n - 1)
							System.out.print(out[i] + " ");
						else
							System.out.println(out[i]);
				}
			}
		}
	}
	
	static class Stack<T>{
		private int N;
		private T[] data;
		
		public Stack(int size) {data = (T[]) new Object[size];}
		public boolean isEmpty() {return N == 0;}
		public int size() {return N;}
		public void push(T value) { data[N++] = value;}
		public T pop() {return data[--N];}
		public T top() {return data[N - 1];}
	}
}
