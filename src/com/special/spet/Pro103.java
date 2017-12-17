package com.special.spet;

import java.util.Scanner;

/** 
* 字符串按长度8切分
* 
* 思想：直接在原串后面填8个0
* 然后8个，8个的取，如果最后索引位于减去8的位置，说明整数倍，则不继续输出
* @author special
* @date 2017年12月17日 上午9:43:07
*/
public class Pro103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			while(n-- > 0){
				String str = input.next();
				str += "00000000";  //后面直接补八个0
				for(int i = 0; i < str.length() - 8; i += 8){
					System.out.println(str.substring(i,i + 8));
				}
			}
		}
	}	

}
