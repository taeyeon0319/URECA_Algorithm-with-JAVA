package a0705.knapsack;

import java.io.*;
import java.util.*;

public class Main_bj_11726_2xn타일링_김태연 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		if (n>=1) dp[1] =1;
		if(n>=2) dp[2] =2;
		for(int i=3;i<=n;i++) {
			dp[i] = (dp[i-1]+dp[i-2]) %10007;
		}
		
		System.out.println(dp[n]);
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