package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_2638 {
	static int N, M;
	static int[][] graph;
	static boolean[][] isout;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer= 0;
		while(!cheesegone()) {
			bfs();
			for(int i=1;i<N-1;i++) {
				for(int j=1;j<M-1;j++) {
					if(graph[i][j]==0) continue;
					if(check(i, j)) {
						graph[i][j] = 0;
					}
				}
			}
			answer+=1;
		}

		System.out.println(answer);
		br.close();
	}
	
	//외부표시
	public static void bfs() {
		isout = new boolean[N][M];
		isout[0][0] = true; //외부임
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0});
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			int x = xy[0];
			int y = xy[1];
			for(int i=0;i<4;i++) {
				int nx =dx[i] +x;
				int ny = dy[i] + y;
				if(nx<0 || nx>=N ||ny<0 || ny>=M) continue;
				if(isout[nx][ny] || graph[nx][ny]!=0) continue;
				isout[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
	}
	
	//적어도 2변 이상 접촉하는지 체크
	public static boolean check(int x, int y) {
		int cnt = 0;
		for(int i=0;i<4;i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(isout[nx][ny]) {
				cnt+=1;
			}
			if(cnt>=2) {
				return true;
			}
		}
		return false;
	}
	
	
	//모든 치즈가 사라졌는지 확인
	public static boolean cheesegone() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(graph[i][j]==1) {
					return false;
				}
			}
		}
		return true;
		
	}
}
