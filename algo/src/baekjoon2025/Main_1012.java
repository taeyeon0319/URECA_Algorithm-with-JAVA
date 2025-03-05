package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1012 {
	static int M, N, K;
	static int[][] graph;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void bfs(int x, int y) {
		graph[x][y]=0;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			x = xy[0];
			y = xy[1];
			for(int i=0;i<4;i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if(nx>=0 && nx<N && ny>=0 && ny<M && graph[nx][ny]==1) {
					graph[nx][ny]=0;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //배추밭의 가로길이
			N = Integer.parseInt(st.nextToken()); //배추밭의 세로길이
			K = Integer.parseInt(st.nextToken()); //배추가 심어져있는 위치의 개수
			graph = new int[N][M];
			
			for(int j=0;j<K;j++) {
				st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				graph[n][m] = 1;
			}
			int result = 0;
			for(int x=0;x<N;x++) {
				for(int y=0;y<M;y++) {
					if(graph[x][y]==1) {
						bfs(x, y);
						result+=1;
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
		
		
		br.close();
	}
}
