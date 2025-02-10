package baekjoon2024;
import java.io.*;
import java.util.*;


public class Main_test {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //정점
		int E = Integer.parseInt(st.nextToken()); //간선
		
		List<int[]>[] graph = new List[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
	
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //a정점
			int b = Integer.parseInt(st.nextToken()); //b정점
			int c = Integer.parseInt(st.nextToken()); //거리
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		long r1 = dijkstra(1, x, graph) + dijkstra(x, y, graph) + dijkstra(y, N, graph);
		long r2 = dijkstra(1, y, graph) + dijkstra(y, x, graph) + dijkstra(x, N, graph);
		
		long result = Math.min(r1, r2);
		if(result >= 200000000) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
		
		
	}
	
	public static int dijkstra(int start, int end, List<int[]>[] graph) {
		int[] distance = new int[graph.length];
	    boolean[] visited = new boolean[graph.length];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start]=0;
		
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
		q.add(new int[] {start, 0});
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int currentNode = current[0];
			int currentDist = current[1];
			
			if(visited[currentNode]) continue;
			visited[currentNode] = true;
			
			for(int[] g : graph[currentNode]) {
				int nextNode = g[0];
				int nextDist = currentDist+g[1];
				
				if(distance[nextNode]>nextDist) {
					distance[nextNode] = nextDist;
					q.add(new int[] {nextNode, nextDist});
				}
			}
		}
		return distance[end] == Integer.MAX_VALUE ? 200000000 : distance[end];
	}

}
