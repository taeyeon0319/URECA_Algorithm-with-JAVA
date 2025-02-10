package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_2638 {
	static int N, M;
	static int[][] graph;
	static int[] dx= {0, 0, 1, -1};
	static int[] dy= {1, -1, 0, 0};
	
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
		
//		while(!gone()) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					int cnt = 0;
					for(int k=0;k<4;k++) {
						int nx = dx[k]+i;
						int ny = dy[k]+j;
						if(0<=nx && nx<N && 0<=ny && ny<M) {
							if(graph[nx][ny]==0) {
								cnt+=1;
							}
						}
					}
					if(cnt>=2) {
						graph[i][j]=0;
					}
					
				}
			}
			for(int[] g : graph) {
				System.out.println(Arrays.toString(g));
			}
//		}
		
		
		
		
		
		br.close();
	}

	private static boolean gone() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(graph[i][j]!=0) {
					return true;
				}
			}
		}
		return false;
	}

}

