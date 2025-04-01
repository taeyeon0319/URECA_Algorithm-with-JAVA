package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_21736 {
	static int N, M;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static char[][] graph;
	static boolean[][] visited;
	static int count=0;
	
	public static void bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			x = xy[0];
			y = xy[1];
			
			for(int i=0;i<4;i++) {
				int nx = dx[i]+x;
				int ny = dy[i]+y;
				if(nx>=0 && nx<N && ny>=0 && ny<M && graph[nx][ny]!='X' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
					if(graph[nx][ny]=='P') {
						count+=1;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new char[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				graph[i][j] = s.charAt(j);
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(graph[i][j]=='I') {
					bfs(i, j);
				}
			}
		}
		System.out.println((count>0)?count:"TT");
		br.close();
	}
}
