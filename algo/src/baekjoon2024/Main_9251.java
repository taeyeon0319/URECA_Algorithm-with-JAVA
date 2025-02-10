package baekjoon2024;
import java.io.*;
import java.util.*;


public class Main_9251 {
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String wordFirst = br.readLine();
		String wordSecond = br.readLine();
		
		int[][] dp = new int[wordFirst.length()+1][wordSecond.length()+1];
		
		for(int i=1;i<=wordFirst.length();i++) {
			for(int j=1;j<=wordSecond.length();j++) {
				if(wordFirst.charAt(i-1)==wordSecond.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		
		System.out.println(dp[wordFirst.length()][wordSecond.length()]);
		
		
	}
		
}

/*
   A C A Y K P
C  0 1 1 1 1 1   
A  1 1 2 2 2 2
P  1 1 2 2 2 3
C  1 2 2 2 2 3
A  1 2 3 3 3 3
K  1 2 3 3 4 4
*/



