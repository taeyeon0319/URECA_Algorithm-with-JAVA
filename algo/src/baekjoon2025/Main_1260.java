package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1260 {
	static int N, M, V;
	static boolean[] visited;
	static List<Integer>[] graph;
	
	public static void dfs(int v) {
		visited[v] = true;
		System.out.print(v+" ");
		for(int g : graph[v]) {
			if(!visited[g]) {
				dfs(g);
			}
		}
	}
	
	public static void bfs(int v) {
		visited[v] = true;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(v);
		while(!q.isEmpty()) {
			v = q.poll();
			System.out.print(v+" ");
			for(int g : graph[v]) {
				if(!visited[g]) {
					q.offer(g);
					visited[g] = true;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		graph = new List[N+1];
		for(int i=0;i<=N;i++) graph[i] = new ArrayList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		for(List<Integer> g : graph) {
			Collections.sort(g);
		}
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
		
		br.close();
	}
}