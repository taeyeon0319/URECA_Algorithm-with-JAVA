package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_14940 {
	static int N, M;
	static int[][] graph;
	static int[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void bfs(int x, int y) {
		visited[x][y]=0;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			x = xy[0];
			y = xy[1];
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<M && visited[nx][ny]==-1 && graph[nx][ny]!=0) {
					visited[nx][ny]=visited[x][y]+1;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int x=0, y=0;
		graph = new int[N][M];
		visited= new int[N][M];
		for(int[] v : visited) {
			Arrays.fill(v, -1);
		}
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j]==2) {
					x=i;
					y=j;
				}
			}
		}
		bfs(x, y);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if (visited[i][j] == -1) {
					if(graph[i][j]==0) {
						sb.append(0);
					}else {
						sb.append(-1);
					}
				} else {
				    sb.append(visited[i][j]);
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

		br.close();
	}
}
