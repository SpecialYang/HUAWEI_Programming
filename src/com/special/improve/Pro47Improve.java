package com.special.improve;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/** 
*
* @author special
* @date 2017年11月4日 下午10:03:51
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
			Set<Integer> keys = new HashSet<Integer>(); //用set来保证key不重复
			int counts = 0;//记录上一次插入后的节点的数量
			int n = input.nextInt();
			int key = input.nextInt();
			int next;
			first = new Node(key);
			n--;
			while(n-- > 0){
				key = input.nextInt();
				next = input.nextInt();
				keys.add(key);
				if(keys.size() > counts){//若加入一个节点，数量变化，则说明不重复，可以进行插入操作
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
