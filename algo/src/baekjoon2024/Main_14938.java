package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_14938 {
	static int n, m, r;
	static List<int[]>[] graph;
	static int[] distance;
	static boolean[] visited;
	static List<Integer> ok;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //지역 개수
		m = Integer.parseInt(st.nextToken()); //예은이의 수색범위
		r = Integer.parseInt(st.nextToken()); //길의 개수
		
		st = new StringTokenizer(br.readLine());
		int[] item = new int[n+1];
		for(int i=1;i<=n;i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new List[n+1];
		for(int i=0;i<=n;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //지역번호 a
			int b = Integer.parseInt(st.nextToken()); //지역번호 b
			int l = Integer.parseInt(st.nextToken()); //길의 길이
			graph[a].add(new int[] {b, l});
			graph[b].add(new int[] {a, l});
		}
		
//		for(List<int[]> g : graph) {
//			for(int[] gg : g) {
//				System.out.print(Arrays.toString(gg));
//			}
//			System.out.println();
//		}
		
		distance = new int[n+1];
		visited =new boolean[n+1];
		for(int v=1;v<=n;v++) {
			Arrays.fill(distance, Integer.MAX_VALUE);
			Arrays.fill(visited, false);
			ok = new ArrayList<>();
			dijkstra(v);
			
			int sum = 0;
			for(Integer o : ok) {
				sum+=item[o];
			}
			result = Math.max(sum, result);
		}
		System.out.println(result);
		
		
		
	}

	private static void dijkstra(int v) {
		distance[v] = 0;
		
		for(int i=1;i<=n;i++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for(int j=1;j<=n;j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					minVertex = j;
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
		for(int i=1;i<=n;i++) {
			if(distance[i]<=m) {
				ok.add(i);
			}
		}
		
	}

}

