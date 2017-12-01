package com.special.improve;

import java.util.Scanner;

/** 
* 成绩排序
* 运用两个平行数组，还有插入排序，泛型方法，哈哈
* @author special
* @date 2017年12月1日 上午10:14:33
*/
public class Pro67Improve2 {
	private static boolean more(int grade1, int grade2) { return grade1 > grade2; }
	private static boolean less(int grade1, int grade2) { return grade1 < grade2; }
	
	private static <T> void exch(int index1, int index2, T[] array){
		T temp = array[index2];
		array[index2] = array[index1];
		array[index1] = temp;
	}
	public static void insertSort(String[] names, Integer[] grades, int sortKind){
		int length = names.length;
		if(sortKind == 0){
			for (int i = 0; i < length; i++)
				for (int j = i; j > 0 && more(grades[j], grades[j - 1]); j--) {
					exch(j, j - 1, names);
					exch(j, j - 1, grades);
				}
		}else{
			for (int i = 0; i < length; i++)
				for (int j = i; j > 0 && less(grades[j], grades[j - 1]); j--) {
					exch(j, j - 1, names);
					exch(j, j - 1, grades);
				}
		}
	}
	/**
	 * 有点啰嗦的插入，这个方法不用两两交换
	 * 只是常见的数组后移操作
	 * @param names
	 * @param grades
	 * @param sortKind
	 *//*
	public static void insertSort(String[] names, Integer[] grades, int sortKind){
		int length = names.length;
		if(sortKind == 0){
			for (int i = 1; i < length; i++){
				int temp = grades[i];
				String name = names[i];
				int j = i - 1;
				for (; j >= 0 && more(temp, grades[j]); j--){ 
					grades[j + 1] = grades[j];
					names[j + 1] = names[j];
				}
				grades[j + 1] = temp;
				names[j + 1] = name;
			}
		}else{
			for (int i = 1; i < length; i++){
				int temp = grades[i];
				String name = names[i];
				int j = i - 1;
				for (; j >= 0 && less(temp, grades[j]); j--){ 
					grades[j + 1] = grades[j];
					names[j + 1] = names[j];
				}
				grades[j + 1] = temp;
				names[j + 1] = name;
			}
		}
	}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int sortKind = input.nextInt();
			String[] names = new String[n];
			Integer[] grades = new Integer[n];
			for(int i = 0; i < n; i++){
				names[i] = input.next();
				grades[i] = input.nextInt();
			}
			insertSort(names,grades,sortKind);
			for(int i = 0; i < n; i++)
				System.out.println(names[i] + " " + grades[i]);
		}
	}

}
