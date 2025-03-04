package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_7576 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] tomato = new int[N][M];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j]==1) {
					q.offer(new int[] {i, j});
				}
			}
		}
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			int x = xy[0];
			int y = xy[1];
			for(int i=0;i<4;i++) {
				int nx = dx[i]+x;
				int ny = dy[i]+y;
				if(0<=nx && nx<N && 0<=ny && ny<M && tomato[nx][ny]==0) {
					tomato[nx][ny] = tomato[x][y]+1;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		
		int max = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tomato[i][j]==0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, tomato[i][j]);
			}
		}
		
		System.out.println(max-1);
			
		br.close();
	}
}