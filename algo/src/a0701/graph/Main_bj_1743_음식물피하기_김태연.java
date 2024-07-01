package a0701.graph;

import java.io.*;
import java.util.*;

public class Main_bj_1743_음식물피하기_김태연 {
	static int N, M, K;
	static int[][] graph;
	static boolean[][] v;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int cnt;
	static void dfs(int i, int j) {
		v[i][j]=true;
		cnt+=1;
		for(int k=0;k<4;k++) {
			int nx = dx[k]+i;
			int ny = dy[k]+j;
			if(0<=nx&&nx<N &&0<=ny&&ny<M && !v[nx][ny] && graph[nx][ny]==1) {
				v[nx][ny] = true;
				dfs(nx, ny);
			}
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[r-1][c-1]=1;
		}
//		for(int[] a:graph) System.out.println(Arrays.toString(a));
		
		v = new boolean[N][M];
		int max = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				cnt = 0;
				if (graph[i][j]==1 && !v[i][j]) dfs(i, j);
				max = Math.max(max, cnt);
			}
		}
		System.out.println(max);

	}

}
