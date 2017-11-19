package com.special.spet;

import java.util.Scanner;

/** 
* 线性插值
* 从第二个数开始，进来之后，若相等，不添加
* 若小于前驱元素的编号，则只添加，不处理插值
* 若大于前驱元素的编号，则添加后，并处理插值
* 改进：则先不要加入，先插值完，再添加，避免数组移位
* @author special
* @date 2017年11月2日 下午10:31:12
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
	 * 处理插值，并返回添加了几个元素
	 * @param nodes 存放元素的数组
	 * @param index	当前最后一个元素的索引，准备在index - 1 与 index 之间插值
	 * @return
	 */
	public static int insert(Node[] nodes, int index){
		int numbers = 0;
		numbers = nodes[index].key - nodes[index - 1].key - 1;
		if(numbers == 0) return 0;
		nodes[index + numbers] = nodes[index]; //先把最后一个元素后移
		int m = nodes[index - 1].key;
		int n = nodes[index].key;
		int A = nodes[index - 1].value;
		int B = nodes[index].value;
		for(int i = 1; i <= numbers; i++) //后移之后的中间位置开始插值
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
				if(index == 0){ //第一个元素直接插，不用考虑太多
					nodes[index++] = new Node(key,value);
				}else if(key != nodes[index - 1].key){ //如果与前驱的编号不一致，开始准备插入
					nodes[index] = new Node(key,value); //插入
					if(key > nodes[index - 1].key)  //插入之后，发现大于前驱编号，开始中间插值
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
