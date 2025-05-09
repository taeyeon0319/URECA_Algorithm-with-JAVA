package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_15663 {
	static int N, M;
	static int[] alist, blist;
	static boolean[] visited;
	
	public static void backtracking(int n, int a) {
		if(n==M) {
			for(int b : blist) {
				System.out.print(b+" ");
			}
			System.out.println();
			return;
		}
		int before = 0;
		for(int i=a;i<N;i++) {
//			if(visited[i]) continue;
			
			if(before!=alist[i]) {
				blist[n] = alist[i];
//				visited[i] = true;
				backtracking(n+1, i);
				before = alist[i];
				
//				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		alist = new int[N];
		blist = new int[M];
		for(int i=0;i<N;i++) {
			alist[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(alist);
		visited = new boolean[N];
		
		backtracking(0, 0);
		
		br.close();

	}
}
