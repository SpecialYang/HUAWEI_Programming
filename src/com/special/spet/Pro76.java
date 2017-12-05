package com.special.spet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
/** 
* 火车进站问题
* 思路利用全排列，然后依次判断哪个排列不是合法出栈序列
* 因为我们全排列产生的序列是乱序的，所以结果需要用TreeSet存一下
* 自己去排序也可以
* @author special
* @date 2017年12月4日 上午11:41:07
*/
public class Pro76 {
	private static TreeSet<String> pmt;
	private static List<int[]> outsInt;
	
	private static void swap(int[] num, int i, int j){
		int temp = num[j];
		num[j] = num[i];
		num[i] = temp;
	}
	
	private static void add(int[] out){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < out.length; i++){
			if(i != out.length - 1)
				sb.append(out[i] + " ");
			else
				sb.append(out[i]);
		}
		pmt.add(sb.toString());
	}
	
	public static void permutation(int[] num, int index){
		if(index == num.length - 1){
			/**
			 * 集合中存入数据时，注意对象引用啊，很容易造成存的是同一个引用的值
			 * 这里利用数组的copyOf拷贝了一个数组
			 */
			int[] out = Arrays.copyOf(num,num.length);
			outsInt.add(out);
			return;
		}
		for (int i = index; i < num.length; i++) {
			swap(num, index, i);
			permutation(num, index + 1);
			swap(num, index, i);
		}
	}
	
	public static boolean isProper(int[] in, int[] out){
		int i = 0, j = 0;
		Stack<Integer> stack = new Stack<>(in.length);
		while(j < out.length){
			while(stack.isEmpty() || stack.top() != out[j]){
				if(i == in.length) return false;
				stack.push(in[i++]);
			}
			while(!stack.isEmpty() && stack.top() == out[j]){
				stack.pop();
				j++;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] in = new int[n];
			outsInt = new ArrayList<>();
			pmt = new TreeSet<>();
			for(int i = 0; i < n; i++)
				in[i] = input.nextInt();
			permutation(in,0); //因为我们dfs的时候，最后会恢复现场，所以不必担心in会发生变化
			for(int[] out : outsInt)
				if(isProper(in,out))
					add(out);
			for(String out : pmt)
				System.out.println(out);
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
