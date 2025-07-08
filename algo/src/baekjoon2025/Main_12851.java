package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_12851 {
	static int N, K;
	static int[] count = new int[100001];
	static int[] ways = new int[100001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Arrays.fill(count, Integer.MAX_VALUE);
		count[N] = 0;
		ways[N] = 1;
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(N);
		
		while(!q.isEmpty()) {
			int v = q.poll();
			
			int[] next = {v-1, v+1, v*2};
			for(int n : next) {
				if(n < 0 || n>100000) continue;
				if(count[n] > count[v]+1) {
					count[n] = count[v]+1;
					ways[n] = ways[v];
					q.offer(n);
				}else if(count[n]==count[v]+1) {
					ways[n] += ways[v];
				}
			}
		}
		System.out.println(count[K]);
		System.out.println(ways[K]);
		
		br.close();
	}
}
