package a0701.graph;

import java.io.*;
import java.util.*;

public class Main_bj_2606_바이러스_김태연 {
	static int N, M;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int result = 0;
	
	static void dfs(int i) {
		visited[i] = true;
		for(int j:graph[i]) {
			if(!visited[j]) {
				result+=1;
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
			for(int j:graph[i]) {
				if(!visited[j]) {
					result+=1;
					q.offer(j);
					visited[j]=true;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new List[N+1];
		for(int i=0;i<graph.length;i++) graph[i]=new ArrayList<>();
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		for(int i=0;i<N+1;i++) {
			Collections.sort(graph[i]);
		}
		
		visited = new boolean[N+1];
//		dfs(1);
		bfs(1);
		System.out.println(result);
		
		

	}

}
