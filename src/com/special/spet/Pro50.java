package com.special.spet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* 不是标准带括号的四则表达式求值
* 中缀表达式转换为后缀表达式
* 注意减号和符号的判断
* 注意ArrayStack是我自己自定义的，注意我的pop()会返回值
* @author special
* @date 2017年11月18日 下午6:55:20
*/
class ArrayStack<T>{
	private int N;
	private T[] data;
	
	public ArrayStack(int size){
		data = (T[]) new Object[size];
	}
	public boolean isEmpty(){
		return N == 0;
	}
	public int size(){
		return N;
	}
	public void push(T value){
		data[N++] = value;
	}
	public T pop(){
		return data[--N];
	}
	public T top(){
		if(N == 0) return null;
		else       return data[N - 1];
	}
}
public class Pro50 {
	private static ArrayStack<Character> ops;
	private static List<Integer> numcnt;
	private static ArrayStack<Integer> nums;
	
	public static int caculate(String expression){
		int index = 0;
		int length = expression.length();
		for(int i = 0; i < length; i++){
			char item = expression.charAt(i);
			if(isNum(item)){
				int total = 0;
				int count = numcnt.get(index);
				while(count-- > 0)
					total = total * 10 + (expression.charAt(i++) - '0');
				i--;
				nums.push(total);
				index++;
			}
			else{
				char op = item;
				int num = nums.pop();
				switch(op){
				case '+': num = nums.pop() + num;break;
				case '-': num = nums.pop() - num;break;
				case '*': num = nums.pop() * num;break;
				case '/': num = nums.pop() / num;break;
				}
				nums.push(num);
			}
		}
		return nums.pop();
	}
	private static boolean isNum(char ch){ return ch >= '0' && ch <= '9'; }
	public static String getTailExpression(String s){
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < s.length(); i++){
			char item = s.charAt(i);
			if(isNum(item)){
				int count = 0;
				do{
					count++;
					result.append(s.charAt(i++));
				}while(i < s.length() && isNum(s.charAt(i)));
				i--;
				numcnt.add(count);
			}
			else if(item == '+' || item == '-'){
				/**
				 * 判断是否是负号
				 */
				if(item == '-' && (i == 0 || s.charAt(i - 1) == '(' || s.charAt(i - 1) == '[' || s.charAt(i - 1) == '}')){
					result.append(0);
					numcnt.add(1);
				}
				while(!ops.isEmpty() && (ops.top() == '+' || ops.top() == '-' || ops.top() == '*' || ops.top() == '/')){
					result.append(ops.pop());
				}
				ops.push(item);
			}
			else if(item == '*' || item == '/'){
				while(!ops.isEmpty() && (ops.top() == '*' || ops.top() == '/')){
					result.append(ops.pop());
				}
				ops.push(item);
			}
			else if(item == '(' || item == '[' || item == '{')
				ops.push(item);
			else if(item == ')'){
				while(ops.top() != '(')
					result.append(ops.pop());
				ops.pop();
			}
			else if(item == ']'){
				while(ops.top() != '[')
					result.append(ops.pop());
				ops.pop();
			}
			else if(item == '}'){
				while(ops.top() != '{')
					result.append(ops.pop());
				ops.pop();
			}
			else
				System.out.println("Invalid input!");
		}
		while(!ops.isEmpty())
			result.append(ops.pop());
		return result.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String s = input.nextLine();
			int length = s.length();
			ops = new ArrayStack<Character>(length);
			nums = new ArrayStack<Integer>(length);
			numcnt = new ArrayList<Integer>();
			String tailExpression = getTailExpression(s);
			int result = caculate(tailExpression);
			System.out.println(result);
		}
	}

}
