package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_11724 {
	static int N, M;
	static List<Integer>[] graph;
	static boolean[] visited;
	public static void bfs(int v) {
		visited[v] = true;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(v);
		while(!q.isEmpty()) {
			v = q.poll();
			for(int g : graph[v]) {
				if(!visited[g]) {
					q.offer(g);
					visited[g]=true;
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
		
		graph = new List[N+1];
		visited = new boolean[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		
		int result = 0;
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				bfs(i);
				result+=1;
			}
		}
		
		System.out.println(result);

		br.close();
	}
}
