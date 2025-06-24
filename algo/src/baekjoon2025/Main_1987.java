package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1987 {
	static int R, C;
	static char[][] alphabet;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static boolean[] visited =new boolean[26];
	
	static int result = 0;

	public static void dfs(int x, int y, int depth) {
		result = Math.max(result, depth);
		
		for(int i=0;i<4;i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
				
			if(nx>=0 && nx<R && ny>=0 && ny<C) {
				char nextChar = alphabet[nx][ny];
				if(!visited[nextChar - 'A']) {
					visited[nextChar-'A']=true;
					dfs(nx, ny, depth+1);
					visited[nextChar-'A'] =false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabet = new char[R][C];
		
	
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				alphabet[i][j] = s.charAt(j);
			}
		}
		
		visited[alphabet[0][0] - 'A']=true;
		dfs(0, 0, 1);
		
		
		System.out.println(result);
		br.close();
	}
}
