package baekjoon2024;

import java.io.*;
import java.util.*;

public class Main_13549 {
	static int N, K;
	static int[] graph;
	static boolean[] visited;
	static int MAX=100001;
	
	public static void bfs(int a) {
		visited[a] = true;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(a);
		while(!q.isEmpty()) {
			int current = q.poll();
			if(current==K) {
				return;
			}
			
			int[] next = {current*2, current-1, current+1};
			
			for(int i=0;i<3;i++) {
				int n = next[i];
				if(n>=0 && n<MAX && !visited[n]) {
					visited[n]=true;
					if(i==0) {
						graph[n] = graph[current];
						q.addFirst(n);
					}else {
						graph[n] = graph[current]+1;
						q.addLast(n);
					}
				}
			}		
		}

	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		graph = new int[MAX];
		visited = new boolean[MAX];
		
		bfs(N);
		System.out.println(graph[K]);	
		
	}

}
