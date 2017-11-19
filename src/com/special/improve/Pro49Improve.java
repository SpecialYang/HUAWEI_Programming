package com.special.improve;

import java.util.Scanner;

/** 
* ����ͷ�巨��������K����
* �������ǾͿ�����������K�������ˣ��������0��ʱ�����ö����ж�������ֱ�ӷ��صľ���ͷ��㣩
* @author special
* @date 2017��11��5�� ����9:12:45
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
