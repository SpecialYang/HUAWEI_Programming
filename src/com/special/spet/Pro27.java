package com.special.spet;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 素数伴侣
* 匈牙利算法！！！！！！！！！！！！
* 其实就是二分图的最大匹配问题
* 有2个点集，找出最大可连接边的数目，每条边都不共用任意节点，且两端节点横跨在两个点集
* 所以，变换此题，因为素数只能是奇数，而奇数只能有奇数与偶数相加得到
* 所以可以分为2个点集，一个奇数点集，一个偶数点集，求奇数到偶数的最大匹配
* 
* 外层，暴力考虑左边每个点对枚举的每个左边的点，要找右边一个点来匹配。
* 那就是对左边的点，我们看他连出去的边，或者说，能连到的右边的点
* 有2种情况：
* 1、右边的点没人匹配——我直接贪心匹配上去
* 2、右边的点有人匹配——考虑把目前与这个右边的点 x 匹配的左边的点 pre[x]，重新匹配一个其他的点，如果成功了，
* 那pre[x]原来匹配的点x就释放开了，我可以直接占领上去。
* 最后统计匹配成功多少个左边的点就行了。
* @author special
* @date 2017年9月25日 下午1:20:41
*/
public class Pro27 {
	private static int maxn = 600000 + 5;
	private static boolean[] prime = new boolean[maxn];
	private static boolean[] flag; 
	private static int[]     nums;
	private static int[][]   edge; //能够相加为素数的两个值
	private static int[]     pre;  //右边点集对应的左边的点集
	private static int       n;
	
	/**
	 * 素数打表
	 */
	public static void getPrime(){
		Arrays.fill(prime, true);
		for(int i = 2;i < maxn; i++)
			if(prime[i])
				for(int j = i + i; j < maxn; j += i){
					prime[j] = false;
				}
	}
	
	public static boolean dfs(int i){
		for(int j = 1; j <= n; j++){
			if(edge[i][j] > 0){
				/**
				 * 如果当前节点已经访问，则试着访问点连接的下一个节点
				 */
				if(flag[j]) continue;
				flag[j] = true;
				/**
				 * 若当前节点没有被占有或者被占有，但是通过可以找到一条增广路径找到未被占有点
				 * 则就把当前考察节点i与j连接起来
				 */
				if(pre[j] == 0 || dfs(pre[j])){
					pre[j] = i;
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		getPrime();
		while(input.hasNext()){
			n = input.nextInt();
			nums   = new int[n + 1];
			edge = new int[n + 1][n + 1];
			pre  = new int[n + 1];
			for(int i = 1; i <= n; i++)
				nums[i] = input.nextInt();
			for(int i = 1; i < n; i++)
				for(int j = i + 1; j <= n; j++){
					if(prime[nums[i] + nums[j]]){
						if((nums[i] & 1) == 1) edge[i][j] = 1;
						else                   edge[j][i] = 1;
					}
				}
			int ans = 0;
			for(int i = 1; i <= n; i++){
				flag = new boolean[n + 1];
				if(dfs(i)) ans++;
			}
			System.out.println(ans);
		}
	}

}
