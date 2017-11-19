package com.special.spet;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年9月6日 上午9:43:08
*/
/**
 * 归并排序，要求数组元素的类型的为实现Comparable类型
 * @author Special
 * 若类型没有实现Comparable接口，则会报转型出错！
 */
class MergeSort{
	
	//归并过程中的辅助数组
	private static Comparable[] aux;
	
	public static void sort(Comparable[] array){
		aux = new Comparable[array.length];
		sort(array, 0, array.length - 1);
	}
	
	private static void sort(Comparable[] array, int low, int high){
		if(low >= high) return;
		int mid = low + (high - low) / 2;
		sort(array, low, mid);
		sort(array, mid + 1, high);
		merge(array , low , mid, high);
	}
	
	private static void merge(Comparable[] array, int low, int mid, int high){
		int i = low, j = mid + 1;
		for(int k = low; k <= high; k++)
			aux[k] = array[k];
		// 归并过程，其实可以进一步优化为基于堆的归并过程，使复杂度将为log(n)
		for(int k = low; k <= high; k++){
			if(i > mid)                   array[k] = aux[j++];
			else if(j > high)             array[k] = aux[i++];
			else if(less(aux[i], aux[j])) array[k] = aux[i++];
			else                          array[k] = aux[j++];
		}
	}
	
	private static boolean less(Comparable a,Comparable b){
		return a.compareTo(b) < 0;
	}
}

public class Pro14 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			String[] inputStrings = new String[num];
			int index = 0;
			while( num -- > 0){
				String str = input.next();
				inputStrings[index++] = str;
			}
			MergeSort.sort(inputStrings);
			for(String item : inputStrings)
				System.out.println(item);
		}
	}

}
