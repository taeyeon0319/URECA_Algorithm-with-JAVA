package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_21736 {
	static int N, M;
	static String[][] graph;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int count = 0;
	static boolean[][] visited;
	
	public static void bfs(int x, int y) {
		visited[x][y] = true;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			x = xy[0];
			y = xy[1];
			for(int k=0;k<4;k++) {
				int nx = dx[k]+x;
				int ny = dy[k]+y;
				if(0<=nx && nx<N && 0<=ny && ny<M && !visited[nx][ny] && !graph[nx][ny].equals("X")) {
					if(graph[nx][ny].equals("P")) count+=1;
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new String[N][M];
		visited = new boolean[N][M];
		int doyeon_i = 0, doyeon_j=0;
		for(int i=0;i<N;i++) {
			String a = br.readLine();
			for(int j=0;j<M;j++) {
				graph[i][j] = Character.toString(a.charAt(j));
				if (graph[i][j].equals("I")) {
					doyeon_i = i;
					doyeon_j = j;
				}
			}
		}
		
		bfs(doyeon_i, doyeon_j);
		if(count==0) {
			System.out.println("TT");
		}else {
			System.out.println(count);
		}
		
		
	}

}

