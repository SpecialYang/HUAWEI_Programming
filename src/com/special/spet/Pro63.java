package com.special.spet;

import java.util.Scanner;

/** 
* MP3光标位置
* 注意判断初始窗口很重要
* 然后可以根据初始窗口将小于等于4 和 大于 4结合起来
* @author special
* @date 2017年11月29日 下午6:51:19
*/
public class Pro63 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int songs = input.nextInt();
			String operations = input.next();
			int sizeOfSonsList = (songs / 4 == 0 ? songs : 4);
			/**
			 * 初始化 初始窗口的开始和结尾，和当前光标所指的位置（1开始）
			 */
			int start = 1;
			int end = sizeOfSonsList;
			int current = 1;
			for(int i = 0; i < operations.length(); i++){
				char item = operations.charAt(i);
				if(item == 'U'){
					current -= 1;
					if(current == 0){
						start = songs - sizeOfSonsList + 1;
						end = songs;
						current = songs;
					}else if(current < start){
						start -= 1;
						end -= 1;
					}
				}
				if(item == 'D'){
					current += 1;
					if(current > songs){
						start = 1;
						end = sizeOfSonsList;
						current = 1;
					}else if(current > end){
						start += 1;
						end += 1;
					}
				}
			}
			
			for(int i = start; i <= end; i++){
				if(i != end)
					System.out.print(i + " ");
				else
					System.out.println(i);
			}
			System.out.println(current);
		}
	}
}
