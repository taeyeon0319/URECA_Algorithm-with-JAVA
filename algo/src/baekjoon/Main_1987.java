package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1987 {
	static int R, C;
	static char[][] board;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static boolean[] visited = new boolean[26];
	static int max = 0;
	
	public static void dfs(int x, int y, int cnt) {
		visited[board[x][y]-'A']=true;
		max = Math.max(max, cnt);
		for(int i=0;i<4;i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(0<=nx && nx<R && 0<=ny && ny<C && !visited[board[nx][ny]-'A']) {
				dfs(nx, ny, cnt+1);
			}
		}
		visited[board[x][y]-'A'] = false;
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); //세로
		C = Integer.parseInt(st.nextToken()); //가로
		
		board = new char[R][C]; //보드
		
		
		for(int i=0;i<R;i++) {
			String b = br.readLine();
			for(int j=0;j<b.length();j++) {
				board[i][j] = b.charAt(j);
			}
		}
	
		
		dfs(0, 0, 1);
		
		System.out.println(max);
	}

}
