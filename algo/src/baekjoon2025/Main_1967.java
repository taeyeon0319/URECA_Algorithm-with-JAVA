package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1967 {
	static int n;
	static List<int[]>[] graph;
	static boolean[] visited;
	static int max=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		graph = new List[n+1];
		for(int i=0;i<=n;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=1;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}
//		for(List<int[]> g : graph) {
//			for(int[] gg : g) {
//				System.out.print(Arrays.toString(gg));
//			}
//			System.out.println();
//		}
		for(int i=1;i<graph.length;i++) {
			visited = new boolean[n+1];
			dfs(i, 0);
		}
		System.out.println(max);
		br.close();
	}
	
	private static void dfs(int node, int distance) {
		visited[node] = true;
		max = Math.max(distance, max);
		
		for(int[] g : graph[node]) {
			if(!visited[g[0]]) {
				dfs(g[0], distance+g[1]);
			}
		}
		
	}
}
