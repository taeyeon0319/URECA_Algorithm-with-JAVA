package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1463 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		dp[1]=0;
		if(N>=2) {
			dp[2]=1;
		}
		if(N>=3) {
			dp[3]=1;
		}
		
		if(N>=4) {
			for(int i=4;i<=N;i++) {
				int min = N-1;
				if(i%3==0) {
					min = Math.min(dp[i/3]+1, min);
				}
				if(i%2==0) {
					min = Math.min(dp[i/2]+1, min);
				}
				min = Math.min(dp[i-1]+1, min);
				dp[i] = min;
			}
		}
		System.out.println(dp[N]);
		br.close();
	}
}
