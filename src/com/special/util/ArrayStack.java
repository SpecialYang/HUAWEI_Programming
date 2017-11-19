package com.special.util;

import java.util.Iterator;

/** 
* ��������Ŀɵ�������ջ
* @author special
* @date 2017��11��18�� ����2:05:08
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
		if(N == data.length) resize(2 * data.length); //����Ϊ2��
		data[N++] = value;
	}
	
	public T pop(){
		T value = data[--N];
		data[N] = null;
		if(N > 0 && N == data.length / 4) 
			resize(data.length / 2);  //խ��Ϊԭ����һ��
		return value; 
	}
	/**
	 * ���Ĵ�С���ȴ���Ҫ�ı�ֵ�ļ��ϣ�Ȼ����ϵļ���һ��һ����ֵ��ȥ
	 * �����µļ��ϵ����ø�ֵ���ϵļ���
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
	 * ���������
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
