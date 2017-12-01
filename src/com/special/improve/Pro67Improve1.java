package com.special.improve;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* �ɼ�����
* ͨ������һ��Ͱ����СΪ100
* Ȼ��ÿ��ͰλΪһ�����������ͬ�ɼ�����
* ע�ⶨ��������Ӧ�ö�����ÿһ����г�ʼ����
* ����ֻ���ڶ��з����˿ռ䣨���ݱ�����Ϊ������0������δ������ݡ�
* @author special
* @date 2017��12��1�� ����9:27:25
*/
public class Pro67Improve1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int sortKind = input.nextInt();
			List<String>[] bucket = new ArrayList[101];
			for(int i = 0; i < 101; i++)
				bucket[i] = new ArrayList<String>();
			for(int i = 0; i < n; i++){
				String name = input.next();
				int grade = input.nextInt();
				bucket[grade].add(name);
			}
			if(sortKind == 0){
				for (int i = 100; i >= 0; i--)
					for (int j = 0; j < bucket[i].size(); j++)
						System.out.println(bucket[i].get(j) + " " + i);
			}
			else{
				for(int i = 1; i < 101; i++)
					for(int j = 0; j < bucket[i].size(); j++)
						System.out.println(bucket[i].get(j) + " " + i);
			}
		}
	}
}
