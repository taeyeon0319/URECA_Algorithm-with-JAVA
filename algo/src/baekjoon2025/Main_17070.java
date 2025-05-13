package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_17070 {
	static int N;
	static int[][] graph;
	static int status; //0가로 1세로 2대각선
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 1, 0};
	static int answer=0;
	
	public static void dfs(int x, int y, int status) {
			if(x==N-1 && y==N-1) {
				answer+=1;
				return;
			}
			
		
			for(int i=0;i<3;i++) {
				if((status==0 && i==2) ||(status==2 && i==0)) {
					continue;
				}else {
					int nx = dx[i] + x;
					int ny = dy[i] + y;
					
					if(nx>=N || ny>=N || graph[nx][ny]==1) continue;
					if(i==1) { //대각선으로 이동시
						if(graph[x+1][y]==1 || graph[x][y+1]==1) continue;
					}
					
					dfs(nx, ny, i);
					
				}
			}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1, 0);
		System.out.println(answer);
		br.close();

	}
}