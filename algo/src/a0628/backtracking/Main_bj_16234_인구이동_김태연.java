package a0628.backtracking;

import java.io.*;
import java.util.*;

public class Main_bj_16234_인구이동_김태연 {
	static int N, L, R;
	static int[][] people;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int p_sum, country_cnt;
	
	static void move_bfs(int x, int y) {
		visited[x][y] = true;
		p_sum = people[x][y];
		country_cnt = 1;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			x = xy[0];
			y = xy[1];
			for(int i=0;i<4;i++) {
				int nx = dx[i]+x;
				int ny = dy[i]+y;
				if(0<=nx && nx<N &&0<=ny && ny<N && !visited[nx][ny]) {
					int p_diff = Math.abs(people[nx][ny]-people[x][y]);
					if (p_diff>=L && p_diff<=R) {
						visited[nx][ny]=true;
						p_sum += people[nx][ny];
						country_cnt+=1;
						q.offer(new int[] {nx, ny});
					}
					
				}
			}
		}
		int p = (int)p_sum/country_cnt;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if (visited[i][j]) people[i][j] = p;
			}
		}
		
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		people = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				people[i][j]= Integer.parseInt(st.nextToken());

			}
		}
		
		visited = new boolean[N][N];
		move_bfs(0, 0);
		
		for(int[] a:people) System.out.println(Arrays.toString(a));

	}

}
