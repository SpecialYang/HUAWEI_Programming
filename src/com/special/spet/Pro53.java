package com.special.spet;

import java.util.Scanner;

/** 
* 表达式求值
* @author special
* @date 2017年11月25日 上午10:05:21
*/
class Stack<T>{
	private int N;
	private T[] data;
	
	public Stack(int size) {data = (T[]) new Object[size];}
	public boolean isEmpty() {return N == 0;}
	public int size() {return N;}
	public void push(T value) { data[N++] = value;}
	public T pop() {return data[--N];}
	public T top() {return data[N - 1];}
}
public class Pro53 {
	private static Stack<Character> ops;
	private static Stack<Integer> nums;
	
	private static boolean isNum(char ch) { return ch >= '0' && ch <= '9';}
	
	private static void caculate(){
		while(!ops.isEmpty() && ops.top() != '('){
			int num = nums.pop();
			char op = ops.pop();
			switch(op){
				case '+': num = nums.pop() + num; break;
				case '-': num = nums.pop() - num; break;
				case '*': num = nums.pop() * num; break;
				case '/': num = nums.pop() / num; break;
			}
			nums.push(num);
		}
	}
	
	public static int caculate(String expression){
		int length = expression.length();
		for(int i = 0; i < length; i++){
			char item = expression.charAt(i);
			if(isNum(item)){
				int total = 0;
				do{
					/**
					 * 注意此处不能用item,因为在循环内，它是一直变得
					 */
					total = total * 10 + (expression.charAt(i) - '0');
					i++;
				}while(i < length && isNum(expression.charAt(i)));
				nums.push(total);
				i--;
			}else if(item == '+' || item == '-'){
				if(item == '-' && (i == 0 || expression.charAt(i - 1) == '('))
					nums.push(0);
				caculate();
				ops.push(item);
			}else if(item == '*' || item == '/'){
				if(!ops.isEmpty() && (ops.top() == '*' || ops.top() == '/')){
					int num = nums.pop();
					char op = ops.pop();
					switch(op){
						case '*': num = nums.pop() * num; break;
						case '/': num = nums.pop() / num; break;
					}
					nums.push(num);
				}
				ops.push(item);
			}else if(item == '(') ops.push(item);
			 else if(item == ')'){
				 caculate();
				 ops.pop();
			 }else  System.out.println("illegal argument");
		}
		caculate();
		return nums.top();
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String expression = input.nextLine();
			int length = expression.length();
			ops = new Stack<Character>(length);
			nums = new Stack<Integer>(length);
			int result = caculate(expression);
			System.out.println(result);
		}

	}

}
