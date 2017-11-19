package com.special.spet;

import java.util.Arrays;
import java.util.Scanner;

/** 
* ��������
* �������㷨������������������������
* ��ʵ���Ƕ���ͼ�����ƥ������
* ��2���㼯���ҳ��������ӱߵ���Ŀ��ÿ���߶�����������ڵ㣬�����˽ڵ����������㼯
* ���ԣ��任���⣬��Ϊ����ֻ����������������ֻ����������ż����ӵõ�
* ���Կ��Է�Ϊ2���㼯��һ�������㼯��һ��ż���㼯����������ż�������ƥ��
* 
* ��㣬�����������ÿ�����ö�ٵ�ÿ����ߵĵ㣬Ҫ���ұ�һ������ƥ�䡣
* �Ǿ��Ƕ���ߵĵ㣬���ǿ�������ȥ�ıߣ�����˵�����������ұߵĵ�
* ��2�������
* 1���ұߵĵ�û��ƥ�䡪����ֱ��̰��ƥ����ȥ
* 2���ұߵĵ�����ƥ�䡪�����ǰ�Ŀǰ������ұߵĵ� x ƥ�����ߵĵ� pre[x]������ƥ��һ�������ĵ㣬����ɹ��ˣ�
* ��pre[x]ԭ��ƥ��ĵ�x���ͷſ��ˣ��ҿ���ֱ��ռ����ȥ��
* ���ͳ��ƥ��ɹ����ٸ���ߵĵ�����ˡ�
* @author special
* @date 2017��9��25�� ����1:20:41
*/
public class Pro27 {
	private static int maxn = 600000 + 5;
	private static boolean[] prime = new boolean[maxn];
	private static boolean[] flag; 
	private static int[]     nums;
	private static int[][]   edge; //�ܹ����Ϊ����������ֵ
	private static int[]     pre;  //�ұߵ㼯��Ӧ����ߵĵ㼯
	private static int       n;
	
	/**
	 * �������
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
				 * �����ǰ�ڵ��Ѿ����ʣ������ŷ��ʵ����ӵ���һ���ڵ�
				 */
				if(flag[j]) continue;
				flag[j] = true;
				/**
				 * ����ǰ�ڵ�û�б�ռ�л��߱�ռ�У�����ͨ�������ҵ�һ������·���ҵ�δ��ռ�е�
				 * ��Ͱѵ�ǰ����ڵ�i��j��������
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
