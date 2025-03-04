package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_10026 {
	static int N;
	static Character[][] graph;
	static Character[][] graph_rg;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int result =0;
	public static void bfs(int x, int y, Character c) {
		graph[x][y] = 'O';
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			x = xy[0];
			y = xy[1];
			for(int i=0;i<4;i++) {
				int nx = dx[i]+x;
				int ny = dy[i]+y;
				
				if(nx>=0 && nx<N && ny>=0 && ny<N) {
					if(graph[nx][ny]==c) {
						q.offer(new int[] {nx, ny});
						graph[nx][ny] = 'O';
					}
					
				}
			}
		}
		result +=1;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		graph = new Character[N][N];
		graph_rg = new Character[N][N];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				graph[i][j] = s.charAt(j);
				graph_rg[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(graph[i][j]!='O') {
					bfs(i, j, graph[i][j]);
				}
				for(Character[] a : graph) {
					System.out.println(Arrays.toString(a));
				}
				System.out.println("=============");
				
			}
		}
		
		for(Character[] a : graph) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println(result);
		
		br.close();
	}
}
