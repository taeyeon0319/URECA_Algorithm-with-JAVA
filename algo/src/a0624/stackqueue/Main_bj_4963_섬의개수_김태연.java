package a0624.stackqueue;

import java.io.*;
import java.util.*;

public class Main_bj_4963_섬의개수_김태연 {
	static int[][] map;
	static int w, h;
	static boolean[][] visited;
	static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	//bfs
	static void bfs(int i, int j) {
		visited[i][j] = true;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i =ij[0];
			j = ij[1];
			for(int k=0;k<8;k++) {
				int ni=dx[k]+i;
				int nj=dy[k]+j;
				if (0<=ni && ni<h && 0<=nj && nj<w && map[ni][nj]==1 && !visited[ni][nj]) {
					visited[ni][nj]=true;
					q.offer(new int[] {ni, nj});
				}
			}
		}
	}
	
	//dfs
	static void dfs(int i, int j) {
		visited[i][j] = true;
		for(int k=0;k<8;k++) {
			int ni = dx[k]+i;
			int nj = dy[k]+j;
			if (0<=ni && ni<h && 0<=nj&&nj<w && map[ni][nj]==1 && !visited[ni][nj]) {
				dfs(ni, nj);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true){
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			int result = 0;
			if (w==0 && h==0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if (map[i][j]==1 && !visited[i][j]) {
						//bfs(i, j);
						dfs(i, j);
						result+=1;
					}
				}
			}
			System.out.println(result);
		}
		br.close();
	}

}
