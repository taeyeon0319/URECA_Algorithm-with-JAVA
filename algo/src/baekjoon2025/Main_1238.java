package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1238 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //학생 수
		int M = Integer.parseInt(st.nextToken()); //단방향 도로 수
		int X = Integer.parseInt(st.nextToken()); //최종 도착지
		
		List<int[]>[] graph = new List[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			graph[s].add(new int[] {e, T});
		}
		
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		int[][] alldist = new int[N+1][N+1];
		int x = 1;
		
		for(int start=1;start<=N;start++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
			Arrays.fill(visited, false);
			
			dist[start] = 0;
			
			for(int i=0;i<=N;i++) {
				int min = Integer.MAX_VALUE;
				int minVertex=-1;
				
				for(int j=1;j<=N;j++) {
					if(!visited[j] && min > dist[j]) {
						min = dist[j];
						minVertex = j;
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
			for(int i=1;i<=N;i++) {
				alldist[x][i] = dist[i];
			}
			x+=1;
		}
		
		int result = 0;
		for(int i=1;i<=N;i++) {
			result = Math.max(result, alldist[i][X]+alldist[X][i]);
		}
		System.out.println(result);
		br.close();
	}
}
