package com.special.improve;

import java.util.Scanner;

/** 
* ������
* �и��ص���� ƽ���� - β�� Ӧ����������10��
* ��������Ӧʼ�ձ���redix��i��һλ����Ϊ10��100��1000......
* @author special
* @date 2017��12��11�� ����11:49:29
*/
public class Pro98Improve1 {

	public static int getCount(int n){
		int count = 0;
		int redix = 1;
		for(int i = 0; i <= n; i++){
			if(redix <= i)
				redix *= 10;
			if(i * (i - 1) % redix == 0)
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int count = getCount(n);
			System.out.println(count);
		}
	}

}
