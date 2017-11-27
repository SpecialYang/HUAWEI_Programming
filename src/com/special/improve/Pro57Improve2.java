package com.special.improve;

import java.util.Arrays;
import java.util.Scanner;

/** 
*
* @author special
* @date 2017年11月26日 下午9:29:28
*/
class FixedMaxHeap {
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
}
public class Pro57Improve2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			int k = input.nextInt();
			int[] data = new int[n];
			FixedMaxHeap heap = new FixedMaxHeap(k);
			for(int i = 0; i < n; i++)
				data[i] = input.nextInt();
			for (int i = 0; i < k; i++)
				heap.push(data[i]);
			for(int i = k; i < n; i++){
				int num = data[i];
				if(num < heap.top()){
					heap.pop();
					heap.push(num);
				}
			}
			int[] result = new int[k];
			for(int i = 0; i < k; i++)
				result[i] = heap.pop();
			Arrays.sort(result);
			for (int i = 0; i < k; i++) {
				if (i < k - 1)
					System.out.print(result[i] + " ");
				else
					System.out.println(result[i]);
			/*for (int i = 0; i < k; i++) {
				if (i < k - 1)
					System.out.print(heap.pop() + " ");
				else
					System.out.println(heap.pop());
			}*/
			}
		}
	}

}
