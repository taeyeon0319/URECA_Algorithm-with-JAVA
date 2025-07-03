package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_14502 {
	static int N, M;
	static int[][] graph;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int result = 0;
	
	public static void makewall(int c) {
		if(c==3) {
			spreadVirus();
			return;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(graph[i][j]==0) {
					graph[i][j] = 1;
					makewall(c+1);
					graph[i][j] = 0;
				}
			}
		}
	}
	
	public static void spreadVirus() {
		int[][] tempGraph = new int[N][M];
		for(int i=0;i<N;i++) {
			System.arraycopy(graph[i], 0, tempGraph[i], 0, M); //요거!!!!!!!!!!!!1
		}
		
		ArrayDeque<int[]> q= new ArrayDeque<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tempGraph[i][j]==2) {
					q.offer(new int[] {i, j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			int x = xy[0];
			int y = xy[1];
			for(int i=0;i<4;i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if(nx>=0 && nx<N && ny>=0 && ny<M && tempGraph[nx][ny]==0) {
					tempGraph[nx][ny] = 2;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		
		int cnt=0;
		for(int[] g : tempGraph) {
			for(int gg : g) {
				if(gg==0) cnt+=1;
			}
		}
		result = Math.max(result, cnt);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		makewall(0);
		System.out.println(result);
		
//		for(int[] g : graph) {
//			System.out.println(Arrays.toString(g));
//		}

		br.close();
	}
}
