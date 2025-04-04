package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_2667 {
	static int N;
	static int[][] graph;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int count;
	public static void bfs(int x, int y) {
		graph[x][y] = 0;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			x = xy[0];
			y = xy[1];
			for(int i=0;i<4;i++) {
				int nx = dx[i]+x;
				int ny = dy[i]+y;
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&graph[nx][ny]==1) {
					q.offer(new int[] {nx, ny});
					graph[nx][ny]=0;
					count+=1;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				graph[i][j] = (int) s.charAt(j)-'0';
			}
		}
		
		List<Integer> result = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(graph[i][j]==1) {
					count=1;
					bfs(i, j);
					result.add(count);
				}
			}
		}
		result.sort((o1, o2) ->{
			return o1-o2;
		});
		System.out.println(result.size());
		for(Integer r : result) {
			System.out.println(r);
		}
		br.close();
	}
}
