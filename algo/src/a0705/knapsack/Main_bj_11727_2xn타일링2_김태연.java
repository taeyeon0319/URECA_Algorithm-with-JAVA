package a0705.knapsack;

import java.io.*;
import java.util.*;

public class Main_bj_11727_2xn타일링2_김태연 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		if (n>=1) dp[1] =1;
		if(n>=2) dp[2] =3;
		for(int i=3;i<=n;i++) {
			dp[i] = (dp[i-1]+dp[i-2]*2) %10007;
		}
		
		System.out.println(dp[n]);
	}
}

/*
1 ->1
2 -> 3
3 -> 5
4 -> f(n-1)+2*f(n-2)
 * */