package com.special.spet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/** 
* 成绩排序
* 定义了两个比较器，可以传入sort函数中
* @author special
* @date 2017年12月1日 上午8:57:59
*/

class Score{
	String name;
	int grade;
	
	public Score(String name, int grade){
		this.name = name;
		this.grade = grade;
	}
	public String toString(){
		return name + " " + grade;
	}
}
public class Pro67 {
	/**
	 * 上升比较器
	 * @author Special
	 *
	 */
	static class ASCCompator implements Comparator<Score>{
		@Override
		public int compare(Score o1, Score o2) {
			// TODO Auto-generated method stub
			if(o1.grade < o2.grade) return -1;
			else if(o1.grade > o2.grade) return 1;
			else                         return 0;
		}
	}
	/**
	 * 下降比较器
	 * @author Special
	 *
	 */
	static class DESCCompator implements Comparator<Score>{
		@Override
		public int compare(Score o1, Score o2) {
			// TODO Auto-generated method stub
			if(o1.grade > o2.grade) return -1;
			else if(o1.grade < o2.grade) return 1;
			else                         return 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int sortKind = input.nextInt();
			Score[] scores = new Score[n];
			for(int i = 0; i < n; i++)
				scores[i] = new Score(input.next(),input.nextInt());
			if(sortKind == 0)
				Arrays.sort(scores,new DESCCompator());
			else 
				Arrays.sort(scores,new ASCCompator());
			for(Score item : scores)
				System.out.println(item);
		}
	}

}
