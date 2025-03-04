package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_2606 {
	static int N, M;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int cnt=0;
	public static void bfs(int n) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(n);
		visited[n]=true;
		while(!q.isEmpty()) {
			n = q.poll();
			for(int g : graph[n]) {
				if(!visited[g]) {
					q.offer(g);
					cnt+=1;
					visited[g]=true;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new List[N+1];
		for(int i=0;i<=N;i++) graph[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);	
		}
		for(int i=0;i<N+1;i++) {
			Collections.sort(graph[i]);
		}
		visited = new boolean[N+1];
		bfs(1);
		System.out.println(cnt);
		br.close();
	}
}