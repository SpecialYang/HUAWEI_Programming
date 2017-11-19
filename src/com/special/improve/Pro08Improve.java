package com.special.improve;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/** 
* �ϲ�����ļ�ֵ�ԣ�����������С��������
* @author special
* @date 2017��9��5�� ����7:26:02
*/
public class Pro08Improve {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			Map<Integer,Integer> resultMap = new TreeMap<Integer,Integer>();
			int num = input.nextInt();
			while(num -- != 0){
				int key = input.nextInt();
				int value = input.nextInt();
				Integer oldValue = resultMap.get(key);
				resultMap.put(key, (oldValue == null? 0: oldValue) + value);
			}
			for(Entry<?, ?> item : resultMap.entrySet()){
				System.out.println(item.getKey() + " " + item.getValue());
			}
		}
	}
}
