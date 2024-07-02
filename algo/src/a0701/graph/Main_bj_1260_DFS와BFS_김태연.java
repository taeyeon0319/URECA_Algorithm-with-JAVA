package a0701.graph;

import java.io.*;
import java.util.*;

public class Main_bj_1260_DFS와BFS_김태연 {
	static int N, M, V;
	static boolean[] visited;
	static List<Integer>[] graph;
	
	static void dfs(int i) {
		visited[i] = true;
		System.out.print(i+" ");
		for(int j:graph[i]) {
			if(!visited[j]) {
				dfs(j);
			}
		}
	}
	
	static void bfs(int i) {
		visited[i] = true;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(i);
		while(!q.isEmpty()) {
			i = q.poll();
			System.out.print(i+" ");
			for(int j:graph[i]) {
				if(!visited[j]) {
					visited[j]=true;
					q.offer(j);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new List[N+1];
		for(int i=0;i<graph.length;i++) graph[i]= new ArrayList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		//sort해주기
		for (int i = 1; i <= N; i++) {
		    Collections.sort(graph[i]);
		}
		
//		for(List<Integer> a:graph) System.out.println(a);
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		
		visited = new boolean[N+1];
		bfs(V);
		
		br.close();

	}

}
