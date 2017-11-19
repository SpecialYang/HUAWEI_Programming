package com.special.spet;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/** 
*
* @author special
* @date 2017年9月5日 上午7:26:02
*/
public class Pro08 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			Map<Integer,Integer> resultMap = new TreeMap<Integer,Integer>();
			int num = input.nextInt();
			while(num -- != 0){
				int key = input.nextInt();
				int value = input.nextInt();
				if(resultMap.get(key) == null)
					resultMap.put(key, value);
				else
					resultMap.put(key, resultMap.get(key) + value);
			}
			Set<Entry<Integer, Integer>> keySet = resultMap.entrySet();
			for(Entry<?, ?> item : keySet){
				System.out.println(item.getKey() + " " + item.getValue());
			}
		}
	}
}
