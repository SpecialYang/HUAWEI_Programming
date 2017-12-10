package com.special.spet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* 投票统计
* 
* 用两个平行数组
* @author special
* @date 2017年12月10日 上午11:52:13
*/
public class Pro93 {
	private static List<String> candidates;
	private static List<Integer>    votes;
	
	private static int findCandidate(String candidate){
		return candidates.indexOf(candidate);
	}
	private static void addCandidate(String candidate){
		if(findCandidate(candidate) == -1) {
			candidates.add(candidate);
			votes.add(0);
		}
	}
	private static boolean voteCandidate(String candidate){
		int index = findCandidate(candidate);
		if(index == -1) return false;
		else{
			int value = votes.get(index);
			votes.set(index, ++value);
			return true;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int invalid = 0;
			candidates = new ArrayList<>();
			votes = new ArrayList<>();
			for(int i = 0; i < n; i++)
				addCandidate(input.next());
			int m = input.nextInt();
			for(int i = 0; i < m; i++)
				if(!voteCandidate(input.next()))
					invalid++;
			for(int i = 0; i < candidates.size(); i++)
				System.out.println(candidates.get(i) + " : " + votes.get(i));
			System.out.println("Invalid : " + invalid);
		}
	}

}
