package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1697 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] count = new int[100001];
		Arrays.fill(count, Integer.MAX_VALUE);
		count[N] = 0;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(N);
		while(!q.isEmpty()) {
			int v = q.poll();
			
			int[] next = {v-1, v+1, v*2};
			for(int n:next) {
				if(n>=0 && n<100001&&count[n]>count[v]+1) {
					count[n] = count[v]+1;
					q.offer(n);
				}
			}
			
		}
		System.out.println(count[K]);
		br.close();
	}
}