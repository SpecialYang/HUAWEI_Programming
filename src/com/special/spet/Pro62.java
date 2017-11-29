package com.special.spet;

import java.util.Scanner;

/** 
* DNA序列
* 相当于求给定字符串，同时给一个长度，找出这个长度含GC比例最高的串
* 我用了字母表，权当试验一下这个思想
* improve给出简化版的（就是不用求比例）
* @author special
* @date 2017年11月29日 下午2:21:18
*/

class AlaphTable{
	private int[] data;  //组成原字符串的元素对应的map数组
	private String str;  //组成原字符串的元素
	private int length;  //目标字符串的长度
	public AlaphTable(String str, int length){
		this.str = str;
		data = new int[str.length()];
		this.length = length;
	}
	public int toIndex(char ch) { return str.indexOf(ch); } 
	
	public void add(char ch){ data[toIndex(ch)]++; }
	
	public void subtract(char ch) { data[toIndex(ch)]--; }
	
	public double caculateRatioOfCG(){  //其实也不用除以长度，直接比较次数也是可以的，我多次一举
		return (data[toIndex('C')] + data[toIndex('G')]) / (double) length;
	}
}
public class Pro62 {
	public static AlaphTable alaphTable;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int length = input.nextInt();
			alaphTable = new AlaphTable("ACGT",length);
			double maxRatio = 0;
			int maxEnd = 0;
			for(int i = 0; i < length; i++)
				alaphTable.add(str.charAt(i));
			maxRatio = alaphTable.caculateRatioOfCG();
			maxEnd = length;
			for(int i = maxEnd; i < str.length(); i++){
				alaphTable.subtract(str.charAt(i - length)); //上一个字符序列的第一个元素计数减一
				alaphTable.add(str.charAt(i));   //新的字符序列最后一个元素计数加一
				double temp = alaphTable.caculateRatioOfCG();
				if(temp > maxRatio){
					maxRatio = temp;
					maxEnd = i + 1;
				}
			}
			System.out.println(str.substring(maxEnd - length,maxEnd));
		}
	}

}
