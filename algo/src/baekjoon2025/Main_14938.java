package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_14938 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //지역의 개수
		int M = Integer.parseInt(st.nextToken()); //예은이의 수색범위
		int R = Integer.parseInt(st.nextToken()); //길의 개수
		
		st = new StringTokenizer(br.readLine());
		int[] item = new int[N+1];
		for(int i=0;i<N;i++) {
			int t = Integer.parseInt(st.nextToken());
			item[i+1] = t;
		}
		
		List<int[]>[] graph = new List[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b, l});
			graph[b].add(new int[] {a, l});
		}
		
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		int realresult=0;
		
		for(int i=1;i<=N;i++) {
			int result = 0;
			Arrays.fill(dist, Integer.MAX_VALUE);
			Arrays.fill(visited, false);
			
			dist[i] = 0;
			
			for(int t=0;t<N;t++) {
				int min = Integer.MAX_VALUE;
				int minVertex=-1;
				
				
				for(int a=1;a<=N;a++) {
					if(!visited[a] && min>dist[a]) {
						min = dist[a];
						minVertex = a;
					}
				}

				if(minVertex==-1) break;
				visited[minVertex] = true;
				
				for(int[] g : graph[minVertex]) {
					if(!visited[g[0]] && dist[g[0]] > dist[minVertex] + g[1]) {
						dist[g[0]] = dist[minVertex] + g[1];
						
					}
				}
			}
			
			for(int j=1;j<=N;j++) {
				if(dist[j]<=M) {
					result += item[j];
				}
			}
			realresult = Math.max(realresult, result);
		}
		System.out.println(realresult);

		br.close();
	}
}
