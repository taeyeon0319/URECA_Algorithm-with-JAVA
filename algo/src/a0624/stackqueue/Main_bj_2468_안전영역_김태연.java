package a0624.stackqueue;

import java.io.*;
import java.util.*;

public class Main_bj_2468_안전영역_김태연 {
	static int[][] map;
	static int N;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int min = 100;
	static int max = 1;
	
	//bfs
	static void bfs(int i, int j, int h) {
		visited[i][j] = true;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i =ij[0];
			j = ij[1];
			for(int k=0;k<4;k++) {
				int ni=dx[k]+i;
				int nj=dy[k]+j;
				if (0<=ni && ni<N && 0<=nj && nj<N && map[ni][nj]>h && !visited[ni][nj]) {
					visited[ni][nj]=true;
					q.offer(new int[] {ni, nj});
				}
			}
		}
	}
	
	//dfs
	static void dfs(int i, int j, int h) {
		visited[i][j] = true;
		for(int k=0;k<4;k++) {
			int ni = dx[k]+i;
			int nj = dy[k]+j;
			if (0<=ni && ni<N && 0<=nj&&nj<N && map[ni][nj]>h && !visited[ni][nj]) {
				dfs(ni, nj, h);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		ArrayList<Integer> resultList = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				min = Math.min(min,  map[i][j]);
				max = Math.max(max,  map[i][j]);
			}
		}
		for(int h=min;h<=max;h++) {
			visited = new boolean[N][N];
			int cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if (map[i][j]>h && !visited[i][j]) {
						dfs(i, j, h);
						cnt+=1;
					}
				}
			}
			resultList.add(cnt);
			
		}

		Collections.sort(resultList);
		System.out.println(Math.max(1, resultList.get(resultList.size()-1)));
		
		br.close();
	}

}
