package a0628.backtracking;

import java.io.*;
import java.util.*;

public class Main_bj_6603_로또_김태연 {
	static int k, S[], result[];
	static boolean[] visited;
	
	static void sixNum(int idx, int cnt) {
		if (cnt==6) {
			Arrays.sort(result);
			for(int a:result) System.out.print(a + " ");
			System.out.println();
			return;
		}
		for(int i=idx;i<k;i++) {
			if(!visited[i]) {
				visited[i]=true;
				result[cnt] = S[i];
				sixNum(i, cnt+1);
				visited[i]=false;
			}
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k==0) break;
			
			S = new int[k];
			for(int i=0;i<k;i++) {
				S[i]=Integer.parseInt(st.nextToken());
			}
			
			result = new int[6];
			visited = new boolean[k];

			sixNum(0, 0);
			System.out.println();

		}


	}

}
