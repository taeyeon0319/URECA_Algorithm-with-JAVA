package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_11660 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				if(j>0) {
					dp[i][j] = dp[i][j-1]+Integer.parseInt(st.nextToken());
				}else {
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
		}

		for(int k=0;k<M;k++) {
			int result = 0;
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i=x1-1;i<x2;i++) {
				if(y1==1) {
					result += dp[i][y2-1];
				}else {
					result += dp[i][y2-1] - dp[i][y1-2];	
				}
			}
			System.out.println(result);
		}
		
		
		br.close();
	}
}
