package com.special.improve;

import java.util.Scanner;

/** 
* ������˹��Ƴ�������
* ������
* ����֧��������ʽ�ˣ����������Ŷ��У�������ȷ������ƥ��
* @author special
* @date 2017��12��1�� ����4:18:55
*/

class InformationOfMatrix{
	int row;
	int col;
	public InformationOfMatrix(int row, int col){
		this.row = row;
		this.col = col;
	}
	public int getMutipleTimes(InformationOfMatrix B) { return this.row * this.col * B.col; }
}
public class Pro69Improve2 {
	
	public static class ArrayStack<T>{
		int N;
		T[] data;
		public ArrayStack(int size){ data = (T[]) new Object[size]; }
		public boolean isEmpty(){ return N == 0; }
		public void push(T value) { data[N++] = value; }
		public T pop(){ return data[--N]; }
		public T top(){ return data[N - 1]; }
		public int size(){ return N; }
	}
	public static int getCaulateTimes(InformationOfMatrix[] inputMatrixs, String rule){
		ArrayStack<Character> letters = new ArrayStack<Character>(rule.length());
		ArrayStack<InformationOfMatrix> matrixs = new ArrayStack<InformationOfMatrix>(inputMatrixs.length);
		int index = 0;
		int result = 0;
		InformationOfMatrix A,B;
		for(int i = 0; i < rule.length(); i++){
			char item = rule.charAt(i);
			if(item == '(') letters.push(item); //��Ϊ�����Ž�ջ
			else if(item == ')'){ 
				if(letters.size() > 2){  //�����Ŵ�һ��������������˼
					char temp = letters.pop();
					letters.pop();
					if(letters.top() != '('){ //�ж��������  ((AB)C)
						B = matrixs.pop();
						A = matrixs.pop();
						result += A.getMutipleTimes(B);
						matrixs.push(new InformationOfMatrix(A.row,B.col));
					}else letters.push(temp);
				}
			}
			else{
				if(!letters.isEmpty() && letters.top() != '('){
					B = inputMatrixs[index++];
					letters.pop();
					A = matrixs.pop();
					result += A.getMutipleTimes(B);
					matrixs.push(new InformationOfMatrix(A.row,B.col));
				}else
					matrixs.push(inputMatrixs[index++]);
				letters.push(item);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			InformationOfMatrix[] inputMatrixs = new InformationOfMatrix[n];
			for(int i = 0; i < n; i++){
				int row = input.nextInt();
				int col = input.nextInt();
				inputMatrixs[i] = new InformationOfMatrix(row,col);
			}
			String rule = input.next();
			int result = getCaulateTimes(inputMatrixs,rule);
			System.out.println(result);
		}
	}
}
