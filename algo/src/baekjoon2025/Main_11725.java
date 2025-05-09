package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_11725 {
	static int N;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int[] result;
	
	public static void bfs(int v) {
		visited[v]=true;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(v);
		while(!q.isEmpty()) {
			v = q.poll();
			for(int g : graph[v]) {
				if(!visited[g]) {
					visited[g]=true;
					q.offer(g);
					result[g] = v;
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new List[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		visited = new boolean[N+1];
		result = new int[N+1];
		bfs(1);
		for(int i=2;i<=N;i++) {
			System.out.println(result[i]);
		}
		br.close();

	}

	

}
