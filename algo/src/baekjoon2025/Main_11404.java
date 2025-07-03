package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_11404 {
	static int N, M;
	static final int INF = 987654321;
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); //도시의 개수
		M = Integer.parseInt(br.readLine()); //버스의 개수
		
		int[][] arr = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j] = INF;
				
				if(i==j) {
					arr[i][j] = 0;
				}
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[a][b] = Math.min(arr[a][b], c);
		}
		
		//플로이드 와샬 알고리즘
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(arr[i][j] == INF) {
					arr[i][j] = 0;
				}
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		

		br.close();
	}
}