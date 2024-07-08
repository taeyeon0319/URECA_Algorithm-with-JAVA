package a0708.algorithm;

import java.io.*;
import java.util.*;
public class Main_bj_14502_연구소_김태연 {
	static int N, M;
	static int[][] graph;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int result = 0;
	
	/*벽을 만들자*/
	static void makewall(int cnt) {
		if(cnt==3) {
			spreadVirus();
			return;

		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(graph[i][j]==0) {
					graph[i][j]=1;
					makewall(cnt+1);
					graph[i][j]=0;
				}
			}
		}
	}
	
	/*바이러스 퍼트려!!*/
	static void spreadVirus() {
		int[][] tempGraph = new int[N][M];
		for(int i=0;i<N;i++){
			System.arraycopy(graph[i], 0, tempGraph[i], 0, M);
		}

		ArrayDeque<int[]> q = new ArrayDeque<>();
		for(int x=0;x<N;x++) {
			for(int y=0;y<M;y++) {
				if (tempGraph[x][y]==2) {
					q.offer(new int[] {x, y});
				}
			}
		}
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			int x = xy[0];
			int y = xy[1];
			for(int k=0;k<4;k++) {
				int nx = dx[k]+x;
				int ny = dy[k]+y;
				if(0<=nx && nx<N && 0<=ny && ny<M  && tempGraph[nx][ny]==0) {
					tempGraph[nx][ny] = 2;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		
		int cnt=0;
		//안전 영역 크기 개수 세기
		for(int[] a:tempGraph) {
			for(int b:a) {
				if(b==0) cnt+=1;
			}
		}
		result = Math.max(result, cnt);
	}
	
	public static void main(String[] args) throws Exception {
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
		
		makewall(0);
		System.out.println(result);
		
		
	}

}
