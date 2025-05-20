package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1753 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine()); //시작 정점
		
		List<int[]>[] graph = new List[V+1];
		for(int i=0;i<=V;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new int[] {v, w});
		}
		
		int[] distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;
		
//		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
//		pq.offer(new int[] {K, 0});
//		
//		while(!pq.isEmpty()) {
//			int[] now = pq.poll();
//			int current = now[0];
//			int value = now[1];
//			
//			if(distance[current]<value) continue;
//			
//			for(int[] g : graph[current]) {
//				if(distance[g[0]]>value + g[1]) {
//					distance[g[0]]= value+g[1];
//					pq.offer(new int[] {g[0], distance[g[0]]});
//				}
//			}
//		}
		
		boolean[] visited = new boolean[V+1];
		Arrays.fill(visited, false);
		for(int i=1;i<=V;i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for(int j=1;j<=V;j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					minVertex = j;
				}
			}
			if(minVertex==-1) continue;
			visited[minVertex] = true;
			
			for(int[] g : graph[minVertex]) {
				if(!visited[g[0]] && distance[g[0]]>min + g[1]) {
					distance[g[0]] = min+g[1];
				}
			}
		}
		for(int i=1;i<=V;i++) {
			if(distance[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}

		br.close();
	}
}
