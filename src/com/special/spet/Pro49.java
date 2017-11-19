package com.special.spet;

import java.util.Scanner;

/** 
* ������������K��
* ������ָ�룬����һ������k����Ȼ��һ���ߣ���һ������ĩβʱ���ڶ������ô��ڵ�K��
* @author special
* @date 2017��11��5�� ����8:40:46
*/
public class Pro49 {
	private static Node head = new Node(0); //ͷ���
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
