package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1916 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<int[]>[] graph = new List[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b, c});
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		boolean[] visited= new boolean[N+1];
		
		for(int i=1;i<=N;i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			
			for(int j=1;j<N;j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					minVertex=j;
				}
			}
			if(minVertex==-1) break;
			visited[minVertex] = true;
			
			for(int[] g : graph[minVertex]) {
				if(!visited[g[0]] && distance[g[0]]>min+g[1]) {
					distance[g[0]] = min+g[1];
				}
			}
		}
		
		System.out.println(distance[end]);
		br.close();

	}
}
