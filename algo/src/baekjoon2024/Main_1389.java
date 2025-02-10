package baekjoon2024;

import java.io.*;
import java.util.*;

public class Main_1389 {
	static int N, M;
	static List<Integer>[] graph;
	static boolean[] v;
	static int[] b;
	
	public static int bfs(int i) {
		v[i]=true;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(i);
		b[i]=0;
		while(!q.isEmpty()) {
			i = q.poll();
			for(int j:graph[i]) {
				if(!v[j]) {
					b[j] = b[i]+1;
					q.offer(j);
					v[j]=true;
				}
			}
		}
		int sum = 0;
		for(int k=0;k<b.length;k++) {
			sum+=b[k];
		}
		return sum;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new List[N+1];

		for(int i=0;i<graph.length;i++) graph[i] = new ArrayList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		int m = Integer.MAX_VALUE;
		int index = 0;
		for(int i=1;i<=N;i++) {
			b = new int[N+1];
			v = new boolean[N+1];
			if(bfs(i)<m) {
				index = i;
				m = bfs(i);
			}
		}
		System.out.println(index);
	}

}
