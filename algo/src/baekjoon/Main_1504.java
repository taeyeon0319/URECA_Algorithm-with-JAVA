package baekjoon;
import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	int end;
	int value;
	
	Node(int end, int value){
		this.end = end;
		this.value = value;
	}
	
	@Override
	public int compareTo(Node o) {
		return value - o.value;
	}
}
public class Main_1504 {
	static int N, E;
	static List<Node>[] graph;
	static int[] distance;
	static boolean[] visited;
	static final int INF = 200000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		//1->x->y->N과 1->y->x->N중 최소값을 찾아야한다.
		long route1 = dijkstra(1, x) + dijkstra(x, y) + dijkstra(y, N);
		long route2 = dijkstra(1, y) + dijkstra(y, x) + dijkstra(x, N);
		

        long result = Math.min(route1, route2);
        if (result >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

	}

	private static int dijkstra(int start, int end) {
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		pq.offer(new Node(start, 0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int minVertex = current.end;
			int min = current.value;
			
			if(!visited[minVertex]) {
				visited[minVertex] = true;
				
				for(Node node : graph[minVertex]) {
					if(!visited[node.end] && distance[node.end]>min+node.value) {
						distance[node.end] = min+node.value;
						pq.add(new Node(node.end, distance[node.end]));
					}
				}
			}
		}
		return distance[end] == Integer.MAX_VALUE ? INF : distance[end];
	}

}

