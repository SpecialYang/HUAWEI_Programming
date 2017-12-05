package com.special.spet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
/** 
* �𳵽�վ����
* ˼·����ȫ���У�Ȼ�������ж��ĸ����в��ǺϷ���ջ����
* ��Ϊ����ȫ���в���������������ģ����Խ����Ҫ��TreeSet��һ��
* �Լ�ȥ����Ҳ����
* @author special
* @date 2017��12��4�� ����11:41:07
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
			 * �����д�������ʱ��ע��������ð�����������ɴ����ͬһ�����õ�ֵ
			 * �������������copyOf������һ������
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
			permutation(in,0); //��Ϊ����dfs��ʱ������ָ��ֳ������Բ��ص���in�ᷢ���仯
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
