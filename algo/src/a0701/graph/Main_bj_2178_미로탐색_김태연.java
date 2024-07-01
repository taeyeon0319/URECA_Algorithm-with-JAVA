package a0701.graph;

import java.io.*;
import java.util.*;

public class Main_bj_2178_미로탐색_김태연 {
	static int N, M; //NxM크기
	static int[][] map; //미로
	
	static int[] dx = {0, 0, 1, -1}; //이동(우-좌-하-상)
	static int[] dy = {1, -1, 0, 0};
	static boolean[][] visited; //방문처리
	
	//bfs(최단 거리, 최소의 칸 수)
	static void bfs(int i, int j) {
		visited[i][j] = true; //해당 위치 방문 처리
		ArrayDeque<int[]> q = new ArrayDeque<>(); // 큐
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) { 
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int k=0;k<4;k++) {
				int nx = dx[k]+i; //이동
				int ny = dy[k]+j;
				//map크기를 벗어나지 않아야함               방문한 적이 없어야함    이동할 수 있는 칸이여야 함
				if(0<=nx && nx<N && 0<=ny && ny<M && !visited[nx][ny] && map[nx][ny]==1) {
					visited[nx][ny]=true;
					map[nx][ny] += map[i][j]; //이동 칸 수를 나타내도록 전 칸의 수 +1
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//입력 - N, M
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//입력 - map
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		//방문 세팅
		visited = new boolean[N][M];
		
		//bfs
		bfs(0, 0);
		System.out.println(map[N-1][M-1]); //(N, M)위치의 칸 수
//		for(int[] a:map) System.out.println(Arrays.toString(a));
		/*
		[1, 0, 9, 10, 11, 12]
		[2, 0, 8, 0, 12, 0]
		[3, 0, 7, 0, 13, 14]
		[4, 5, 6, 0, 14, 15]
		 */

	}

}
