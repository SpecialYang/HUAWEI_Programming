package com.special.spet;

import java.util.Scanner;

/** 
* �ַ���������8�з�
* 
* ˼�룺ֱ����ԭ��������8��0
* Ȼ��8����8����ȡ������������λ�ڼ�ȥ8��λ�ã�˵�����������򲻼������
* @author special
* @date 2017��12��17�� ����9:43:07
*/
public class Pro103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			while(n-- > 0){
				String str = input.next();
				str += "00000000";  //����ֱ�Ӳ��˸�0
				for(int i = 0; i < str.length() - 8; i += 8){
					System.out.println(str.substring(i,i + 8));
				}
			}
		}
	}	

}
