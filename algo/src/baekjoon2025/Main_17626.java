package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_17626 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[1] = 1;
		
		int min = 0;
		for(int i=2;i<=n;i++) {
			min = Integer.MAX_VALUE;
			
			for(int j=1;j*j<=i;j++) {
				int temp = i-j*j;
				min = Math.min(min,  dp[temp]);
			}
			dp[i] = min+1;
		}
		System.out.println(dp[n]);
		
		br.close();
	}
}
