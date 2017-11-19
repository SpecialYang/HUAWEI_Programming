package com.special.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年11月3日 上午8:19:46
*/
public class Pro46Improve {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int m,n,M,A,N,B;
			m = input.nextInt();
			n = input.nextInt();
			M = input.nextInt();
			A = input.nextInt();
			System.out.println(M + " " + A);
			for(int i = 1; i < m; i++){
				N = input.nextInt();
				B = input.nextInt();
				if(N == M) continue;
				for(int j = 1; j < N - M; j++)
					System.out.println((M + j) + " " + (A + ((B - A) / (N - M)) * j));
				System.out.println(N + " " + B);
				M = N;
				A = B;
			}
		}
	}

}
