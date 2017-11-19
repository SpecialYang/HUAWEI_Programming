package com.special.spet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** 
* 从单链表中删除指定的值
* @author special
* @date 2017年11月4日 下午8:58:35
*/
public class Pro47 {
	private static Node first = new Node(0); //链表的真正的头结点，为了方便删除操作的实现
	/**
	 * 嵌套类，作为链表的节点
	 * @author Special
	 *
	 */
	static class Node{
		int key;
		Node next;
		public Node(int key){
			this.key = key;
		}
	}
	/**
	 * 查找指定key的节点
	 * @param before
	 * @return 若存在，则返回该节点。否则返回NULL
	 */
	private static Node search(int before){
		Node item = first.next;
		while(item != null){
			if(item.key == before)
				return item;
			item = item.next;
		}
		return null;
	}
	/**
	 * delete the node by key 
	 * @param deleteKey
	 */
	private static void delete(int deleteKey){
		Node p = first; // the true head node
		Node t = p.next; // the first node
		while(t != null){
			if(t.key == deleteKey)
				p.next = t.next;
			p = t;
			t = t.next;
		}
	}
	/**
	 * 在before后面插入节点
	 * @param after
	 * @param before
	 */
	public static void insert(int after, int before){
		Node p = search(before);
		if(p == null) return;  //如果before不存在，也就无法插入
		Node t = new Node(after);
		t.next = p.next;
		p.next = t;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			Set<Integer> keys = new HashSet<Integer>(); //用set来保证key不重复
			int counts = 0;//记录上一次插入后的节点的数量
			int n = input.nextInt();
			int key = input.nextInt();
			int next;
			first.next = new Node(key);
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
			for(Node p = first.next; p != null; p = p.next)
				System.out.print(p.key + " ");
			System.out.println();
		}

	}

}
