package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_9461 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[101];
		for(int i=1;i<=3;i++) {
			dp[i] = 1;
		}
		dp[4] = 2; 
		dp[5] = 2;
		for(int i=6;i<=100;i++) {
			dp[i] = dp[i-1]+dp[i-5];
		}
		System.out.println(Arrays.toString(dp));
		for(int i=0;i<T;i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
		br.close();
	}
}
