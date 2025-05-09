package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_15654 {
	static int N, M;
	static int[] alist;
	static int[] blist;
	static boolean[] visited;

	
	public static void backtracking(int n) {
		if(n==M) {
			for(int b : blist) {
				System.out.print(b+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				blist[n] = alist[i];
				visited[i] = true;
				backtracking(n+1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		alist = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			alist[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(alist);
		visited = new boolean[N];
		
		blist = new int[M];
		backtracking(0);

	}

}
