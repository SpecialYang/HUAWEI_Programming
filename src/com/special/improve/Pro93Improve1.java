package com.special.improve;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/** 
* 票数统计
* 
* linkedHashMap的应用
* @author special
* @date 2017年12月10日 下午3:00:58
*/
public class Pro93Improve1 {
	private static Map<String,Integer> map;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			map = new LinkedHashMap<>();
			for(int i = 0; i < n; i++)
				map.put(input.next(), 0);
			int m = input.nextInt();
			int count = 0;
			for(int i = 0; i < m; i++){
				String item = input.next();
				if(map.containsKey(item))
					map.put(item, map.get(item) + 1);
				else count++;
			}
			for(String item : map.keySet())
				System.out.println(item + " : " + map.get(item));
			System.out.println("Invalid : " + count);
		}	
	}

}
