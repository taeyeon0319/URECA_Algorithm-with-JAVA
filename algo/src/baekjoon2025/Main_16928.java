package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_16928 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graph = new List[101];
		for(int i=0;i<=100;i++) graph[i] = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
 		}
	
		boolean[] visited = new boolean[101];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(1);
		visited[1] = true;
		
		int[] result = new int[101];
		Arrays.fill(result, -1);
		result[1] = 0;
		
		while(!q.isEmpty() && !visited[100]) {
			int n = q.poll();
			for(int i=1;i<=6;i++) {
				int nn = n+i;
				if(0<nn && nn<=100 && !visited[nn]) {
					if(!graph[nn].isEmpty()) {
						nn = graph[nn].get(0);
					}
					if(!visited)
				}
			}
		}
		br.close();
	}
}