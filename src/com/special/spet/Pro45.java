package com.special.spet;

import java.util.Scanner;

/** 
* ��ȡ�ַ���
* ���������ȷ�ı�ʾ��˵�Ǻ����ַ�ռ1���ֽڣ�����ռ2���ֽ�
* C��C++�����Ļ��ȽϷ��㣬��Ϊ���ַ������ռһ���ֽ�
* ��Java���ַ���ռ2���ֽڣ��������������Ҫ�����Java
* 
* �������ע��Java��char���޷����͵ģ�ȡֵ��ΧΪ0��65536�������˺��֣�,����toCharArray()��ʵ���Ѻ��ַֿ�
* �������ע��C/C++��char���з����͵ģ�ȡֵ��ΧΪ-128��127���������˺��֣�,���Կ���ͨ��ÿ���ַ��ı���ֵС��0���ж�
* 
* 
* ��Ҫ�ô����������֣�ȷ����Ӧ��Ŀ��Ҫ��
* ���⼼�ɣ�
* 1.�����ַ������Ӧ��intֵ�Ǵ���127
* 2.����һ��������������ǰ�ַ�Ϊ���֣����2�������1��ģ���ֽ�
* @author special
* @date 2017��10��26�� ����1:46:23
*/
public class Pro45 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.next();
			int n = input.nextInt();
			int count = 0;
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < str.length() && count < n; i++){
				if(str.charAt(i) > 127){
					count += 2;
					if(count > n) break;
				}
				else   
					count++;
				result.append(str.charAt(i));
			}
			System.out.println(result);
		}

	}

}
