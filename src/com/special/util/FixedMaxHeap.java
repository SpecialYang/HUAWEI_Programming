package com.special.util;
/** 
*
* @author special
* @date 2017年11月26日 下午8:35:11
*/
public class FixedMaxHeap {
	private int N;
	private int[] data;
	
	public FixedMaxHeap(int size){
		data = new int[size + 1];
	}
	public boolean isEmpty(){ return N == 0; }
	public void makeHeap(){
		rise(N);
		sick(1);
	}
	public void push(int value){
		data[++N] = value;
		exch(1,N);
		makeHeap();
	}
	public int top(){ return data[1]; }
	
	public int pop(){ 
		int value = data[1];
		exch(1,N);
		N--;
		makeHeap();
		return value;
	}
	public void sick(int index){
		int max = index;
		if(index * 2 <= N && data[max] < data[index * 2])
			max = index * 2;
		if(index * 2 + 1 <= N && data[max] < data[index * 2 + 1])
			max = index * 2 + 1;
		if(max != index){
			exch(max,index);
			sick(max);
		}
	}
	public void rise(int index){
		if(data[index] > data[index / 2 == 0 ? 1 : index / 2]){
			exch(index,index / 2);
			rise(index / 2);
		}
	}
	private void exch(int i, int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	public static void main(String[] args){
		FixedMaxHeap heap = new FixedMaxHeap(100);
		heap.push(1);
		heap.push(3);
		heap.push(5);
		heap.push(7);
		heap.push(2);
		while(!heap.isEmpty())
			System.out.println(heap.pop());
	}
}
