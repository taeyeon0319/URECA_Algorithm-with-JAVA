package a0705.knapsack;

import java.io.*;
import java.util.*;

public class Main_bj_1463_1로만들기_김태연 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		dp[1] = 1;
		int[] num = {1, 2, 3};
		
		for(int i=0;i<=n;i++) {
			int min = Integer.MAX_VALUE;
			for(int m:num) {
				
			}
		}
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