package com.special.spet;

import java.util.Scanner;

/** 
* DNA����
* �൱��������ַ�����ͬʱ��һ�����ȣ��ҳ�������Ⱥ�GC������ߵĴ�
* ��������ĸ��Ȩ������һ�����˼��
* improve�����򻯰�ģ����ǲ����������
* @author special
* @date 2017��11��29�� ����2:21:18
*/

class AlaphTable{
	private int[] data;  //���ԭ�ַ�����Ԫ�ض�Ӧ��map����
	private String str;  //���ԭ�ַ�����Ԫ��
	private int length;  //Ŀ���ַ����ĳ���
	public AlaphTable(String str, int length){
		this.str = str;
		data = new int[str.length()];
		this.length = length;
	}
	public int toIndex(char ch) { return str.indexOf(ch); } 
	
	public void add(char ch){ data[toIndex(ch)]++; }
	
	public void subtract(char ch) { data[toIndex(ch)]--; }
	
	public double caculateRatioOfCG(){  //��ʵҲ���ó��Գ��ȣ�ֱ�ӱȽϴ���Ҳ�ǿ��Եģ��Ҷ��һ��
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
				alaphTable.subtract(str.charAt(i - length)); //��һ���ַ����еĵ�һ��Ԫ�ؼ�����һ
				alaphTable.add(str.charAt(i));   //�µ��ַ��������һ��Ԫ�ؼ�����һ
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
