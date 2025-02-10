package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_11660 {
	static int N, M;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				dp[i][j+1] = dp[i][j] + Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<M;i++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
//			System.out.println(dp[x2][y2]);
			for(int j=x1;j<=x2;j++) {
				sum+=dp[j][y2]-dp[j][y1-1];
			}
			
			System.out.println(sum);

		}
		
//		for(int[] a:dp) {
//			System.out.println(Arrays.toString(a));
//		}
	}
}

/* bfs - 시간초과
public class Main_11660 {
	static int N, M;
	static int[][] graph;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static boolean[][] v;
	
	public static void bfs(int x1, int y1, int x2, int y2) {
		int result = 0;
		v[x1][y1] = true;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x1, y1});
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			x1 = xy[0];
			y1 = xy[1];
			result+=graph[x1][y1];
			for(int k=0;k<4;k++) {
				int nx = dx[k]+x1;
				int ny = dy[k]+y1;
				if(x1<=nx && nx<=x2 && y1<=ny && ny<=y2 && !v[nx][ny]) {
					v[nx][ny]=true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		System.out.println(result);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			v = new boolean[N][N];
			bfs(x1-1, y1-1, x2-1, y2-1);
		}
	}

} 
 */

