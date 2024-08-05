package baekjoon;
import java.io.*;
import java.util.*;

public class Main_11725 {
	static int N;
	static List<Integer>[] g;
	static boolean[] visited;
	static int[] parent;
	public static void bfs(int v) {
		visited[v]=true;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(v);
		while(!q.isEmpty()) {
			v = q.poll();
			for(int a : g[v]) {
				if(!visited[a]) {
					parent[a] = v;
					visited[a] = true;
					q.offer(a);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		g = new List[N+1];
		visited = new boolean[N+1];
		for(int i=0;i<g.length;i++) g[i] = new ArrayList<>();
		for(int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a].add(b);
			g[b].add(a);
		}
		
		parent = new int[N+1];
		bfs(1);

		for(int i=2;i<=N;i++) {
			System.out.println(parent[i]);
		}
			
	}
		
	

}


