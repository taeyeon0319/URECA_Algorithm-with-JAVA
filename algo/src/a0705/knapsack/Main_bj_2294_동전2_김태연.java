package a0705.knapsack;

import java.io.*;
import java.util.*;

public class Main_bj_2294_동전2_김태연 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		
		for(int i=0;i<N;i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		//dp선언
		int[] dp = new int[K+1];
		Arrays.fill(dp, -1);
		dp[0]=0;
		
		for(int i=0;i<=K;i++) {
			int min = Integer.MAX_VALUE;
			for(int c:coins) {
				if(i-c>=0 && dp[i-c]!=-1) min=Math.min(min, dp[i-c]+1);
			}
			if(min!=Integer.MAX_VALUE) {
				dp[i] = min;
			}
		}
		System.out.println(dp[K]);
		
	}
}

/*
 0 -> 0
 1 -> 1
 2 -> 2
 3 -> 3
 4 -> 5
 f(n) = f(n-1)+f(n-2) 
 * */