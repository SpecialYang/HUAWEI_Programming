package com.special.improve;

import java.util.Scanner;

/** 
* 采用头插法处理倒数第K个数
* 这样我们就可以求正数第K个就行了，而且求第0个时，不用额外判断索引（直接返回的就是头结点）
* @author special
* @date 2017年11月5日 上午9:12:45
*/
public class Pro49Improve {
	private static Node head;
	static class Node{
		int value;
		Node next;
		public Node(int value){
			this.value = value;
		}
	}
	public static Node getBackward(int k){
		Node p = head;
		int index = 0;
		while(p != null && index < k){
			p = p.next;
			index++;
		}
		return p;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			head = new Node(0);
			int value;
			while(n-- > 0){
				value = input.nextInt();
				Node p = new Node(value);
				p.next = head.next;
				head.next = p;
			}
			int k = input.nextInt();
			Node backwardK = getBackward(k);
			if(backwardK != null)
				System.out.println(backwardK.value);
		}
	}
}
