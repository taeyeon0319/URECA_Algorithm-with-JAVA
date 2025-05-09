package baekjoon2025;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	int end; // 도착 정점
	int weight; // 비용(가중치)
	Node(int end, int weight){
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		return weight - o.weight; //weight가 작은 node가 우선순위 큐에서 먼저 나옴
	}
}
public class Main_1916_2 {
	static int N, M;
	static ArrayList<ArrayList<Node>> graph;
	static int[] distance;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		
		distance = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(start, end)+"\n");
		br.close();

	}
	
	//다익스트라 알고리즘
	public static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		pq.offer(new Node(start, 0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end; 
			
			if(!visited[cur]) {
				visited[cur] = true;
				
				for(Node node : graph.get(cur)) {
					if(!visited[node.end] && distance[node.end] > distance[cur] + node.weight) {
						distance[node.end] = distance[cur] + node.weight;
						pq.offer(new Node(node.end, distance[node.end]));
					}
				}
			}
		}
		return distance[end];
		
	}
}
