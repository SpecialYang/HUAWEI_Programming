package com.special.improve;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/** 
*
* @author special
* @date 2017��11��4�� ����10:03:51
*/
public class Pro47Improve {

	private static Node first;
	
	static class Node{
		int key;
		Node next;
		public Node(int key){
			this.key = key;
		}
	}
	
	private static void delete(int deleteKey){
		Stack<Node> stack = new Stack<Node>();
		while(first != null){
			if(first.key != deleteKey)
				stack.push(first);
			first = first.next;
		}
		while(!stack.isEmpty()){
			stack.peek().next = first;
			first = stack.pop();
		}
	} 
	
	public static void insert(int after, int before){
		Node p = first;
		Node s = new Node(after);
		while(p != null){
			if(p.key == before){
				s.next = p.next;
				p.next = s;
			}
			p = p.next;
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			Set<Integer> keys = new HashSet<Integer>(); //��set����֤key���ظ�
			int counts = 0;//��¼��һ�β����Ľڵ������
			int n = input.nextInt();
			int key = input.nextInt();
			int next;
			first = new Node(key);
			n--;
			while(n-- > 0){
				key = input.nextInt();
				next = input.nextInt();
				keys.add(key);
				if(keys.size() > counts){//������һ���ڵ㣬�����仯����˵�����ظ������Խ��в������
					counts++;
					insert(key,next);
				}
			}
			int deleteKey = input.nextInt();
			delete(deleteKey);
			for(Node p = first; p != null; p = p.next)
				System.out.print(p.key + " ");
			System.out.println();
		}

	}
}
