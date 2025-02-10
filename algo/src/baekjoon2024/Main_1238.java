package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_1238 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // N명의 학생
		int M = Integer.parseInt(st.nextToken()); // M개의 단방향 도로
		int X = Integer.parseInt(st.nextToken()); // 파티가 벌어지는 마을
		
		List<int[]>[] graph = new List[N+1];
		for(int i=0;i<=N;i++) graph[i] = new ArrayList<int[]>();
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			graph[start].add(new int[] {end, T});
		}
//		for(int i=1;i<=N;i++) {
//			for(int[] g : graph[i]) {
//				System.out.print(Arrays.toString(g)+" ");
//			}
//			System.out.println();
//		}
		
		int[] distance = dijkstra(N, X, graph);
		
		int[] result = new int[N+1];
		int maxresult = 0;
		for(int i=1;i<=N;i++) {
			result[i] = distance[i]+dijkstra(N, i, graph)[X];
			maxresult = Math.max(maxresult, result[i]);
//			System.out.println("2에서 오는 값"+distance[i]);
//			System.out.println("2로 가는 값"+dijkstra(N, i, graph)[X]);
		}
		System.out.println(maxresult);
		
		
	}
	private static int[] dijkstra(int N, int start, List<int[]>[] graph) {
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		boolean[] visited = new boolean[N+1];

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1], o2[1]));
		distance[start] = 0;
		pq.add(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] current = pq.poll();
			int currentNode = current[0];
			int currentDist = current[1];
			
			if(visited[currentNode]) continue;
			visited[currentNode] = true;
			
			for(int[] neighbor : graph[currentNode]) {
				int nextNode = neighbor[0];
				int nextDist = currentDist + neighbor[1];
				
				if(distance[nextNode] > nextDist) {
					distance[nextNode] = nextDist;
					pq.add(new int[] {nextNode, nextDist});
				}
			}
		}
		return distance;
		
	}
}

