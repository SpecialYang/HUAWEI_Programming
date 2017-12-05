package com.special.improve;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/** 
* 火车进站
* 只有两种情况：
* 1.进站
* 2.出战
* 那么递归函数就有了
* 注意要对这两种情况进行回复现场
* 还要注意引用问题
* @author special
* @date 2017年12月5日 上午11:24:13
*/
public class Pro76Improve2 {
	private static int[] in;
	private static TreeSet<String> pmt;
	/**
	 * 注意恢复现场，否则第一次结束会影响之前的递归
	 * @param stay
	 * @param index
	 * @param out
	 */
	public static void trainInOrOut(Stack<Integer> stay, int index, Stack<Integer> out){
		if(index == in.length && stay.isEmpty()){
			pmt.add(out.toString());
			return;
		}
		if(!stay.isEmpty()){
			int num = stay.pop();
			out.push(num);
			trainInOrOut(stay,index,out);
			out.pop();
			stay.push(num);
		}
		if(index < in.length){
			stay.push(in[index]);
			trainInOrOut(stay,index + 1,out);
			stay.pop();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			in = new int[n];
			pmt = new TreeSet<>();
			for(int i = 0; i < n; i++)
				in[i] = input.nextInt();
			
			Stack<Integer> stayStack = new Stack<>(n);
			Stack<Integer> outStack = new Stack<>(n);
			trainInOrOut(stayStack,0,outStack);
			for(String out : pmt)
				System.out.println(out);
		}
	}
	
	static class Stack<T> implements Iterable<T>{
		private int N;
		private T[] data;
		
		public Stack(int size) {data = (T[]) new Object[size];}
		public boolean isEmpty() {return N == 0;}
		public int size() {return N;}
		public void push(T value) { data[N++] = value;}
		public T pop() {return data[--N];}
		public T top() {return data[N - 1];}
		@Override
		public String toString(){
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++)
				if(i != N - 1)
					sb.append(data[i]+" ");
				else 
					sb.append(data[i]);
			return sb.toString();
		}
		@Override
		public Iterator<T> iterator() { return new ReverseIterator(); }
		
		private class ReverseIterator implements Iterator<T>{
			int index = 0;

			@Override
			public boolean hasNext() { return index != N; }

			@Override
			public T next() { return data[index++]; }

			@Override
			public void remove() { throw new UnsupportedOperationException(); }
		}
	}
}
