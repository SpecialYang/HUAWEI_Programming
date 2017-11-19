package com.special.spet;

import java.util.Scanner;

/** 
* 单链表求倒数第K个
* 用两个指针，先让一个先走k个，然后一起走，第一个到达末尾时，第二个正好处于第K个
* @author special
* @date 2017年11月5日 上午8:40:46
*/
public class Pro49 {
	private static Node head = new Node(0); //头结点
	static class Node{
		int value;
		Node next;
		
		public Node(int value){
			this.value = value;
		}
	}
	
	public static Node getBackWard(int index){
		Node p = head;
		if(index < 1) return p;
		Node q = head;
		while(index-- > 0){
			q = q.next;
			if(q == null) return null;
		}
		while(q != null){
			p = p.next;
			q = q.next;
		}
		return p;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int value;
			Node p = head;
			while(n-- > 0){
				value = input.nextInt();
				p.next = new Node(value);
				p = p.next;
			}
			int k = input.nextInt();
			Node backwardK = getBackWard(k);
			if(backwardK != null)
				System.out.println(backwardK.value);
		}
	}

}
