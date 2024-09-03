package baekjoon;
import java.io.*;
import java.util.*;


public class Main_11404 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); //도시의 개수
		int m = Integer.parseInt(br.readLine()); //버스의 개수
		List<int[]>[] graph = new List[n+1];
		for(int i=0;i<n+1;i++) {
			graph[i] = new ArrayList<int[]>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //시작 도시
			int b = Integer.parseInt(st.nextToken()); //도착 도시
			int c = Integer.parseInt(st.nextToken()); //필요한 비용
			graph[a].add(new int[] {b, c});
		}
		
		for(int start=1; start<=n;start++) {
			boolean[] visited= new boolean[n+1];
			int[] distance = new int[n+1];
			for(int i=0;i<n+1;i++) distance[i] = Integer.MAX_VALUE;
			
			distance[start] = 0;
			
			for(int i=1;i<n+1;i++) {
				int minVertex = -1;
				int min = Integer.MAX_VALUE;
				for(int j=1;j<n+1;j++) {
					if(!visited[j] && min>distance[j]) {
						min = distance[j];
						minVertex = j;
					}
				}
				
				if (minVertex==-1) break;
				visited[minVertex] = true;
				
				for(int[] g : graph[minVertex]) {
					if(!visited[g[0]] && distance[g[0]]>min+g[1]) {
						distance[g[0]] = min+g[1];
					}
				}
			}
			for(int i=1;i<n+1;i++) {
				if(distance[i]==Integer.MAX_VALUE) {
					System.out.print(0+" ");
				}else {
					System.out.print(distance[i]+" ");
				}
				
			}
			System.out.println();
		}
		
	}
	
}



