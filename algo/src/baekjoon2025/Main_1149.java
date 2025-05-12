package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1149 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][3];
		int[][] dp = new int[N][3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<3;i++) {
			dp[0][i] = graph[0][i];
		}
		for(int i=1;i<N;i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+graph[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+graph[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+graph[i][2];
		}
		System.out.println(Arrays.stream(dp[N-1]).min().getAsInt());
		br.close();
	}
}
