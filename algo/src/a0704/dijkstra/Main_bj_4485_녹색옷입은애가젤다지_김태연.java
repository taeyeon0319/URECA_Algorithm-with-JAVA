package a0704.dijkstra;

import java.io.*;
import java.util.*;

public class Main_bj_4485_녹색옷입은애가젤다지_김태연 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = 0; //몇번 테스트 케이스인지
		while(true) {
			t+=1;
			int N = Integer.parseInt(br.readLine());
			if (N==0) break; //N이 0이면 종료
			System.out.print("Problem "+t+": ");
			
			int[][] graph = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean[][] v = new boolean[N][N];
			int[][] d = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					d[i][j] = Integer.MAX_VALUE;
				}
			}
			
			PriorityQueue<int[]>pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[2],o2[2]));
			d[0][0] = graph[0][0];
			pq.offer(new int[] {0, 0, d[0][0]});
			while(!pq.isEmpty()) {
				int[] vw = pq.poll();
				int minx = vw[0];
				int miny = vw[1];
				int min = vw[2];
				if(v[minx][miny]) continue;
				
				v[minx][miny]=true;
				if(minx==N-1&&miny==N-1) break;
				
				for(int i=0;i<4;i++) {
					int nx = dx[i]+minx;
					int ny = dy[i]+miny;
					if(0<=nx && nx<N && 0<=ny && ny<N && !v[nx][ny] && d[nx][ny]>min+graph[nx][ny]) {
						d[nx][ny] = min+graph[nx][ny];
						pq.offer(new int[] {nx, ny, d[nx][ny]});
					}
				}
				
			}
//			for(int[] a:d) System.out.println(Arrays.toString(a));
			System.out.println(d[N-1][N-1]);
			
			
		}

	}

}
