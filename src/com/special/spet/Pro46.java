package com.special.spet;

import java.util.Scanner;

/** 
* ���Բ�ֵ
* �ӵڶ�������ʼ������֮������ȣ������
* ��С��ǰ��Ԫ�صı�ţ���ֻ��ӣ��������ֵ
* ������ǰ��Ԫ�صı�ţ�����Ӻ󣬲������ֵ
* �Ľ������Ȳ�Ҫ���룬�Ȳ�ֵ�꣬����ӣ�����������λ
* @author special
* @date 2017��11��2�� ����10:31:12
*/
class Node{
	int key;
	int value;
	
	public Node(int key, int value){
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return key + " " + value;
	}
	
}
public class Pro46 {
	/**
	 * �����ֵ������������˼���Ԫ��
	 * @param nodes ���Ԫ�ص�����
	 * @param index	��ǰ���һ��Ԫ�ص�������׼����index - 1 �� index ֮���ֵ
	 * @return
	 */
	public static int insert(Node[] nodes, int index){
		int numbers = 0;
		numbers = nodes[index].key - nodes[index - 1].key - 1;
		if(numbers == 0) return 0;
		nodes[index + numbers] = nodes[index]; //�Ȱ����һ��Ԫ�غ���
		int m = nodes[index - 1].key;
		int n = nodes[index].key;
		int A = nodes[index - 1].value;
		int B = nodes[index].value;
		for(int i = 1; i <= numbers; i++) //����֮����м�λ�ÿ�ʼ��ֵ
			nodes[index++] = new Node(m + i,A + ((B - A) / (n - m)) * i);
		return numbers;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int m = input.nextInt();
			int n = input.nextInt();
			Node[] nodes = new Node[1000];
			int index = 0;
			for(int i = 0; i < m;){
				int key = input.nextInt();
				int value = input.nextInt();
				if(index == 0){ //��һ��Ԫ��ֱ�Ӳ壬���ÿ���̫��
					nodes[index++] = new Node(key,value);
				}else if(key != nodes[index - 1].key){ //�����ǰ���ı�Ų�һ�£���ʼ׼������
					nodes[index] = new Node(key,value); //����
					if(key > nodes[index - 1].key)  //����֮�󣬷��ִ���ǰ����ţ���ʼ�м��ֵ
						index += insert(nodes,index);
					index++;
				}
				i++;
			}
			for(int i = 0; i < index; i++)
				System.out.println(nodes[i]);
		}
	}

}
