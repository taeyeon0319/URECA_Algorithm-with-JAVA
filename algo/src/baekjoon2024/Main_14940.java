package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_14940 {
	static int N, M;
	static int[][] graph;
	static int[][] answer;
	static int twoi = 0, twoj = 0;
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			x = xy[0];
			y = xy[1];

			for(int k=0;k<4;k++) {
				int nx = dx[k] + x;
				int ny = dy[k] + y;
				if(0<=nx && nx<N && 0<=ny && ny<M && answer[nx][ny]==0 && graph[nx][ny]==1) {
					answer[nx][ny] = answer[x][y]+1;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		graph = new int[N][M];
		answer = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 2) {
					twoi = i;
					twoj = j;
				}
			}
		}
		
		bfs(twoi, twoj);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(graph[i][j]==1 && answer[i][j]==0) {
					System.out.print(-1 + " ");
				}else {
					System.out.print(answer[i][j] + " ");
				}
			}
			System.out.println();
		}

	}

}

