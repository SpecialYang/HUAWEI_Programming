package com.special.util;

import java.util.Iterator;

/** 
* 基于数组的可迭代泛型栈
* @author special
* @date 2017年11月18日 下午2:05:08
*/
public class ArrayStack<T> implements Iterable<T>{
	private int N;
	private T[] data;
	
	public ArrayStack(int size){
		data = (T[]) new Object[size];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public void push(T value){
		if(N == data.length) resize(2 * data.length); //扩容为2倍
		data[N++] = value;
	}
	
	public T pop(){
		T value = data[--N];
		data[N] = null;
		if(N > 0 && N == data.length / 4) 
			resize(data.length / 2);  //窄容为原来的一半
		return value; 
	}
	/**
	 * 更改大小，先创建要改变值的集合，然后把老的集合一个一个赋值过去
	 * 最后把新的集合的引用赋值给老的集合
	 * @param max
	 */
	public void resize(int max){ 
		T[] temp = (T[]) new Object[max];
		for(int i = 0; i < N; i++)
			temp[i] = data[i];
		data = temp;
	}
	
	public Iterator<T> iterator(){
		return new ReverseArrayIterator();
	}
	/**
	 * 逆序迭代器
	 * @author Special
	 *
	 */
	private class ReverseArrayIterator implements Iterator<T>{
		private int i = N;
		public boolean hasNext(){ return i > 0; }
		public T next(){ return data[--i]; }
		public void remove(){ throw new UnsupportedOperationException(); }
	}
	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args){
		ArrayStack<Character> stack = new ArrayStack<Character>(10);
		for(int i = 0; i < 10; i++)
			stack.push((char) ('A' + i));
		for(Character item : stack)
			System.out.println(item);
	}
}
