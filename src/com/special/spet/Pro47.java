package com.special.spet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** 
* �ӵ�������ɾ��ָ����ֵ
* @author special
* @date 2017��11��4�� ����8:58:35
*/
public class Pro47 {
	private static Node first = new Node(0); //�����������ͷ��㣬Ϊ�˷���ɾ��������ʵ��
	/**
	 * Ƕ���࣬��Ϊ����Ľڵ�
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
	 * ����ָ��key�Ľڵ�
	 * @param before
	 * @return �����ڣ��򷵻ظýڵ㡣���򷵻�NULL
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
	 * ��before�������ڵ�
	 * @param after
	 * @param before
	 */
	public static void insert(int after, int before){
		Node p = search(before);
		if(p == null) return;  //���before�����ڣ�Ҳ���޷�����
		Node t = new Node(after);
		t.next = p.next;
		p.next = t;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			Set<Integer> keys = new HashSet<Integer>(); //��set����֤key���ظ�
			int counts = 0;//��¼��һ�β����Ľڵ������
			int n = input.nextInt();
			int key = input.nextInt();
			int next;
			first.next = new Node(key);
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
			for(Node p = first.next; p != null; p = p.next)
				System.out.print(p.key + " ");
			System.out.println();
		}

	}

}
