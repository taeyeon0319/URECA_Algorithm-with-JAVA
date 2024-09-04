package baekjoon;
import java.io.*;
import java.util.*;

public class Main_2206 {
	static int N, M;
	static int[][] graph;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[][][] visited;
	
	public static int bfs(int x, int y, int broken) {
		visited[x][y][broken] = 1;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y, broken});
		while(!q.isEmpty()) {
			int[] xyb = q.poll();
			x = xyb[0];
			y = xyb[1];
			broken = xyb[2];
			if(x==N-1 && y==M-1) {
				return visited[x][y][broken];
			}
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					//벽을 부수지 않고 이동하는 경우
					if(graph[nx][ny]==0 && visited[nx][ny][broken]==0) {
						visited[nx][ny][broken] = visited[x][y][broken]+1;
						q.offer(new int[] {nx, ny, broken});
					}
					
					//벽을 부수고 이동하는 경우
					if(graph[nx][ny]==1 && broken==0 && visited[nx][ny][1]==0) {
						visited[nx][ny][1] = visited[x][y][broken]+1;
						q.offer(new int[] {nx, ny, 1});
					}
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		visited = new int[N][M][2];
		
		for(int i=0;i<N;i++) {
			String num = br.readLine();
			for(int j=0;j<M;j++) {
				graph[i][j] = (int) num.charAt(j)-'0';
			}
		}
		
		System.out.println(bfs(0, 0, 0));
	}
}



