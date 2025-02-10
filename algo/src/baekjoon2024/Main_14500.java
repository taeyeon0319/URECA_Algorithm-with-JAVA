package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_14500 {
	static int N, M;
	static int[][] paper;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static boolean[][] v;
	static int result;
	
	//깊이 4에서 종료
	public static void dfs(int x, int y, int count, int sum) {
		if(count==4) {
			result = Math.max(result, sum);
			return;
		}
		for(int i=0;i<4;i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			if(0<=nx && nx<N && 0<=ny && ny<M && !v[nx][ny]) {
				v[nx][ny] = true;
				if(count==2) {
					dfs(x, y, count+1, sum+paper[nx][ny]);
				}
				dfs(nx, ny, count+1, sum+paper[nx][ny]);
				v[nx][ny] = false;
			}
		}	
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];

		result = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		v = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				v[i][j] = true;
				dfs(i, j, 1, paper[i][j]);
				v[i][j] = false;
			}
		}
		System.out.println(result);
	}
		

}

