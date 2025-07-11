package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_11779 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); //도시 개수
		int m = Integer.parseInt(br.readLine()); //버스 개수
		List<int[]>[] graph = new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[s].add(new int[] {e, c});
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		boolean[] visited= new boolean[n+1];
		Arrays.fill(visited, false);
		
		int[] prev = new int[n+1]; //경로 저장용(전 단계만 저장)
		
		distance[start] = 0;
	
		
		for(int i=0;i<n;i++) {
			int min = Integer.MAX_VALUE;
			int minVertex=-1;
			for(int j=1;j<=n;j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					minVertex=j;
				}
			}
			if(minVertex==-1) break;
			visited[minVertex] = true;
			
			for(int[] g : graph[minVertex]) {
				if(!visited[g[0]] && distance[g[0]] > distance[minVertex] + g[1]) {
					distance[g[0]] = distance[minVertex] + g[1];
					prev[g[0]] = minVertex;
					
				}
			}
		}
		
		System.out.println(distance[end]);

		ArrayList<Integer> route = new ArrayList<>();
		int cur = end;
		while(cur!=0) {
			route.add(cur);
			cur = prev[cur];
		}
		System.out.println(route.size());
		for(int i=route.size()-1;i>=0;i--) {
			System.out.print(route.get(i)+" ");
		}
		br.close();
	}
}