package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_2178 {
	static int N, M;
	static int[][] graph;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void bfs(int x, int y) {
		ArrayDeque<int[]> q =new ArrayDeque<>();
		q.offer(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			x = xy[0];
			y = xy[1];
			for(int i=0;i<4;i++) {
				int nx = dx[i]+x;
				int ny = dy[i]+y;
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&graph[nx][ny]==1) {
					q.offer(new int[] {nx, ny});
					graph[nx][ny] = graph[x][y]+1;
				}
			}
		
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				graph[i][j] = (int) s.charAt(j)-'0';
			}
		}
		
		bfs(0, 0);
		
//		for(int[] g : graph) {
//			System.out.println(Arrays.toString(g));
//		}
		System.out.println(graph[N-1][M-1]);
		br.close();
	}
}
