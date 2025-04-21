package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_11403 {
	static int N;
	static List<Integer>[] graph;
	static boolean[] visited;
	public static void bfs(int start) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(start);
		while(!q.isEmpty()) {
			int n = q.poll();
			for(Integer g : graph[n]) {
				if(visited[g]==false) {
					visited[g]=true;
					q.offer(g);
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new List[N];
		
		for(int i=0;i<N;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n==1) {
					graph[i].add(j);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			visited = new boolean[N];
			bfs(i);
			for(boolean v : visited) {
				if(v) {
					sb.append(1).append(" ");
				}else {
					sb.append(0).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

		br.close();
	}
}
