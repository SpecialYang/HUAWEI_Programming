package com.special.improve;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/** 
*
* @author special
* @date 2017年11月18日 下午10:06:18
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
/**
 * 改进后的四则运算
 * 可以边遍历边求值
 * 每次遇到加号或者减号或者右括号则可以把之前的求值了
 * 遇到乘号或者除号则需要判断前面的是否也是乘除，若不是，则直接进栈
 * 否则对前一项进行求值
 * @author Special
 *
 */
public class Pro50Improve1 {
	private static ArrayStack<Character> ops;
	private static ArrayStack<Integer> nums;
	
	public static void caculate(){
		while(!ops.isEmpty() && ops.top() != '('){
				char op = ops.pop();
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
	private static boolean isNum(char ch){ return ch >= '0' && ch <= '9'; }
	
	public static void caculate(String s){
		for(int i = 0; i < s.length(); i++){
			char item = s.charAt(i);
			if(isNum(item)){
				int total = 0;
				do{
					total = total * 10 + (s.charAt(i++) - '0');
				}while(i < s.length() && isNum(s.charAt(i)));
				nums.push(total);
				i--;
			}
			else if(item == '+' || item == '-'){
				/**
				 * 判断是否是负号
				 */
				if(item == '-' && (i == 0 || s.charAt(i - 1) == '('))
					nums.push(0);
				caculate();
				ops.push(item);
			}
			else if(item == '*' || item == '/'){
				while(!ops.isEmpty() && (ops.top() == '*' || ops.top() == '/')){
					char op = ops.pop();
					int num = nums.pop();
					switch(op){
					case '*': num = nums.pop() * num;break;
					case '/': num = nums.pop() / num;break;
					}
					nums.push(num);
				}
				ops.push(item);
			}
			else if(item == '('){
				ops.push(item);
			}
			else if(item == ')'){
				caculate();
				ops.pop();
			}
			else
				System.out.println("Invalid input!");
		}
		caculate();
	}
	
	public static String changeBracket(String s){
		char[] sArr = s.toCharArray();
		for(int i = 0; i < s.length(); i++){
			if(sArr[i] == '[' || sArr[i] == '{')
				sArr[i] = '(';
			else if(sArr[i] == ']' || sArr[i] == '}')
				sArr[i] = ')';
		}
		return new String(sArr);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String s = input.nextLine();
			int length = s.length();
			ops = new ArrayStack<Character>(length);
			nums = new ArrayStack<Integer>(length);
			s = changeBracket(s);
			caculate(s);
			System.out.println(nums.top());
		}
	}
}
