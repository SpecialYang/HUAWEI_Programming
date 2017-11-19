package com.special.spet;

import java.util.Scanner;

/** 
* 字符串之间的距离，编辑距离，将strA编辑成strB所需的最小代价
* 编辑操作包括插入一个字符、删除一个字符、替换一个字符
* * 分别对应的代价是ic、dc、rc，insert cost、delete cost、replace cost
* strA[x-1]代表strA的第x个字符，注意下标是从0开始的,strA[y-1]代表strA的第y个字符         
* 定义一个代价矩阵为(N+1)*(M+1)，M N 表示strA strB的长度        
* dp[x][y]表示strA的前x个字符串编辑成 strB的前y个字符所花费的代价       
* dp[x][y]是下面几种值的最小值：            
* 1、dp[x][y] = dp[x-1][y] + dc            
* dp[x-1][y]将strA的前x-1个字符编辑成strB的前y个字符的代价已知，            
* 那么将将strA的前x个字符编辑成strB的前y个字符的代价dp[x][y]就是dp[x-1][y] + dc            
* 相当于strA的前x-1个字符编辑成strB的前y个字符，现在变成了strA的前x个字符，增加了一个字符，要加上删除代价            
* 2、dp[x][y] = dp[x][y-1] + ic             
* dp[x][y-1]将strA的前x个字符编辑成strB的前y-1个字符的代价已知，            
* 现在变为strB的前y个字符，相应的在strA前x个操作代价的基础上插入一个字符            
* 3、dp[x][y] = dp[x-1][y-1]           
* dp[x-1][y-1]将strA的前x-1个字符编辑成strB的前y-1个字符的代价已知，             
* strA的第x个字符和strB的第y个字符相同，strA[x-1] == strB[y-1]，没有引入操作           
* 4、dp[x][y] = dp[x-1][y-1] + rc            
* strA的第x个字符和strB的第y个字符不相同，strA[x-1] ！= strB[y-1]，             
* 在strA的前x-1个字符编辑成strB的前y-1个字符的代价已知的情况下，         
* 计算在strA的前x字符编辑成strB的前y个字符的代价需要加上替换一个字符的代价、
* 
* 
* 动态规划优化编辑问题
* dp[i][j]表示A的i个字符表示为B的j个字符所需的最小编辑数
* 有3种情况：
* 1.dp[i - 1][j - 1] + 1 让A的i-1个字符编辑为B的j - 1个字符，然后对A的第i个字符进行替换
* 2.dp[i][j - 1] + 1     让A的i个字符编辑为B的j - 1个字符，然后添加A的第j个字符
* 3.dp[i - 1][j] + 1     让i - 1个字符编辑为j个字符，然后删除A的第i个字符
* 求这3种情况的最小值即为dp[i][j]的值
* @author special
* @date 2017年11月19日 下午3:17:49
*/
public class Pro51 {
	
	public static int getMinialEditLength(String str1,String str2){
		int length1 = str1.length();
		int length2 = str2.length();
		int[][] dp = new int[length1+1][length2+1];
		for(int i = 1; i <=length2; i++) dp[0][i] = i;
		for(int i = 1; i <=length1; i++) dp[i][0] = i;
		for(int i = 1; i <= length1; i++)
			for(int j = 1; j <= length2; j++){
				if(str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = dp[i - 1][j - 1] + 1;
				dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]) + 1, dp[i][j]);
			}
		return dp[length1][length2];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.nextLine();
			String str2 = input.nextLine();
			int minialEditLength = getMinialEditLength(str1,str2);
			System.out.println(minialEditLength);
		}
	}

}
