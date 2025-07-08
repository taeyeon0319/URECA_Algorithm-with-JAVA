package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_17144 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[R][C];
		int[] air = new int[2];
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for(int t=0;t<T;t++) {
			int index = 0;
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(graph[i][j]>0) {
						q.offer(new int[] {i, j, graph[i][j]});
					}
					if(graph[i][j]==-1) {
						air[index] = i;
						index+=1;
					}
				}
			}
			
			while(!q.isEmpty()) {
				int[] ij = q.poll();
				int i = ij[0];
				int j = ij[1];
				int value = ij[2];
				
				int div = (int) value/5;
				for(int k=0;k<4;k++) {
					int nx = dx[k]+i;
					int ny = dy[k]+j;
					if(nx>=0 && nx<R && ny>=0 && ny<C && graph[nx][ny]!=-1) {
						graph[nx][ny] += div;
						graph[i][j] -= div;
					}
				}
			}

			int one = air[0];
			int two = air[1];
			
			//위 공기청정기
			for(int x=one-1;x>0;x--) {
				graph[x][0] = graph[x-1][0];
			}
			for(int y=0;y<C-1;y++) {
				graph[0][y] = graph[0][y+1];
			}
			for(int x=0;x<one;x++) {
				graph[x][C-1] = graph[x+1][C-1];
			}
			for(int y=C-1;y>1;y--) {
				graph[one][y] = graph[one][y-1];
			}
			graph[one][1] = 0;
			
			//아래 공기청정기
			for(int x=two+1;x<R-1;x++) {
				graph[x][0] = graph[x+1][0];
			}
			for(int y=0;y<C-1;y++) {
				graph[R-1][y] = graph[R-1][y+1];
			}
			for(int x=R-1;x>=two;x--) {
				graph[x][C-1] = graph[x-1][C-1];
			}
			for(int y=C-1;y>1;y--) {
				graph[two][y] = graph[two][y-1];
			}
			graph[two][1] = 0;
		}
		
		
		int result = 0;
		for(int[] g : graph) {
			for(int gg : g) {
				if(gg>0) {
					result+=gg;
				}
			}
//			System.out.println(Arrays.toString(g));
		}
		
		System.out.println(result);
		br.close();
	}
}
