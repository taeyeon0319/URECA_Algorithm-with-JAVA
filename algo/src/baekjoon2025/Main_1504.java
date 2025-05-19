package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1504 {
	static int N, E;
	static List<int[]>[] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new List[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		int[] dist1 = getminDist(1);
	    int[] distV1 = getminDist(v1);
	    int[] distV2 = getminDist(v2);
	    
	    long path1 = (long)dist1[v1] + distV1[v2] + distV2[N];
	    long path2 = (long)dist1[v2] + distV2[v1] + distV1[N];
	    
	    long result = Math.min(path1, path2);
	    System.out.println(result >= Integer.MAX_VALUE ? -1 : result);
		
		br.close();
	}

	private static int[] getminDist(int start) {
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
		pq.offer(new int[] {start, 0}); //노드번호, 거리
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int current = now[0];
			int dist = now[1];
			
			if(distance[current]<dist) continue;
			
			for(int[] next : graph[current]) {
				int nextNode = next[0];
				int nextDist = dist+next[1];
				
				if(distance[nextNode] > nextDist) {
					distance[nextNode] = nextDist;
					pq.offer(new int[] {nextNode, nextDist});
				}
			}
		}
		
		return distance;
	}
	
	
}

