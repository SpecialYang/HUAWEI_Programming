package com.special.spet;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017��9��6�� ����9:43:08
*/
/**
 * �鲢����Ҫ������Ԫ�ص����͵�Ϊʵ��Comparable����
 * @author Special
 * ������û��ʵ��Comparable�ӿڣ���ᱨת�ͳ���
 */
class MergeSort{
	
	//�鲢�����еĸ�������
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
		// �鲢���̣���ʵ���Խ�һ���Ż�Ϊ���ڶѵĹ鲢���̣�ʹ���ӶȽ�Ϊlog(n)
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
