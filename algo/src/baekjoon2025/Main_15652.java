package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_15652 {
	static int N, M;
	static int[] alist;
	static int[] blist;

	
	public static void backtracking(int n, int anum) {
		if(n==M) {
			for(int b : blist) {
				System.out.print(b+" ");
			}
			System.out.println();
			return;
		}
		for(int i=anum;i<N;i++) {
			blist[n] = alist[i];
			backtracking(n+1, i);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		alist = new int[N];
		for(int i=0;i<N;i++) {
			alist[i] = i+1;
		}
		blist = new int[M];
		backtracking(0, 0);

	}

}
