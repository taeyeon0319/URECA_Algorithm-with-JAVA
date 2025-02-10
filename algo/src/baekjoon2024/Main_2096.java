package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_2096 {
	static int N;
	static int[][] graph;
	static int[][] maxDp, minDp;

//	public static void dpMax(int i) {
//		if(i==N) {
//			int Maxresult = dp[N-1][0];
//			for(int x=0;x<3;x++) {
//				Maxresult = Math.max(Maxresult, dp[N-1][x]);
//				
//			}
//			System.out.print(Maxresult+" ");
//			return;
//		}
//		int max = Math.max(graph[i][0], graph[i][1]);
//		dp[i][0] = dp[i-1][0] + max;
//		dp[i][1] = dp[i-1][1] + Math.max(max, graph[i][2]);
//		dp[i][2] = dp[i-1][2] + Math.max(graph[i][1], graph[i][2]);
//		dpMax(i+1);
//		
//	}
//	
//	public static void dpMin(int i) {
//		if(i==N) {
//			int Minresult = dp[N-1][0];
//			for(int x=0;x<3;x++) {
//				Minresult = Math.min(Minresult, dp[N-1][x]);
//			}
//			System.out.println(Minresult);
//			return;
//		}
//		int min = Math.min(graph[i][0], graph[i][1]);
//		dp[i][0] = dp[i-1][0] + min;
//		dp[i][1] = dp[i-1][1] + Math.min(min, graph[i][2]);
//		dp[i][2] = dp[i-1][2] + Math.min(graph[i][1], graph[i][2]);
//		dpMin(i+1);
//		
//	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new int[N][3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}
		int[][] maxDp = new int[N][3];
		int[][] minDp = new int[N][3];
		for(int i=0;i<3;i++) {
			maxDp[0][i] = graph[0][i];
			minDp[0][i] = graph[0][i];
		}
		
		for(int i=1;i<N;i++) {
			maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + graph[i][0];
			maxDp[i][1] = Math.max(Math.max(maxDp[i-1][0], maxDp[i-1][1]), maxDp[i-1][2])+graph[i][1];
			maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2]) + graph[i][2];
			
			minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + graph[i][0];
			minDp[i][1] = Math.min(Math.min(minDp[i-1][0], minDp[i-1][1]), minDp[i-1][2])+graph[i][1];
			minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2]) + graph[i][2];
		}

		int maxResult = Math.max(Math.max(maxDp[N-1][0], maxDp[N-1][1]), maxDp[N-1][2]);
        int minResult = Math.min(Math.min(minDp[N-1][0], minDp[N-1][1]), minDp[N-1][2]);

        System.out.print(maxResult + " " + minResult);
	}
}

