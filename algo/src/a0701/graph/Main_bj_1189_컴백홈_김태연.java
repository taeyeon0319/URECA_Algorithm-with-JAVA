package a0701.graph;

import java.io.*;
import java.util.*;
public class Main_bj_1189_컴백홈_김태연 {
	static int R, C, K;
	static String[][] map;
	
	static int[] di = {0, 0, 1, -1};
	static int[] dj = {1, -1, 0, 0};
	static boolean[][] v;
	
	static int result = 0;
	static int cnt = 1;
	
	static void dfs(int i, int j) {
		v[i][j]=true;
		if (i==0 && j==(C-1) && cnt==K) {
			result+=1;
		}
		for(int k=0;k<4;k++) {
			int ni = di[k]+i;
			int nj = dj[k]+j;
			if(0<=ni&&ni<R&&0<=nj&&nj<C && !v[ni][nj] && !map[ni][nj].equals("T")) {
				cnt+=1;
				dfs(ni, nj);
				cnt-=1; //백트래킹
			}
		}
		v[i][j] = false; //백트래킹
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new String[R][C];
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = String.valueOf(s.charAt(j));
			}
		}
		
		v = new boolean[R][C];
		dfs(R-1, 0);
		System.out.println(result);

	}

}
