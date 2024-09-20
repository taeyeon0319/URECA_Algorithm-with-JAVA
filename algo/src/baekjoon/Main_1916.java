package baekjoon;
import java.io.*;
import java.util.*;

public class Main_1916 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //도시
		int M = Integer.parseInt(br.readLine()); //버스
		List<int[]>[] graph = new List[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new int[] {B, C});
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[N+1];
		boolean[] v = new boolean[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[start] = 0;
		for(int i=0;i<N;i++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			
			for(int j=1;j<=N;j++) {
				if(!v[j] && min>distance[j]) {
					min = distance[j];
					minVertex = j;
				}
			}
			
			if(minVertex==-1) break; //더이상 방문할 노드가 없으면 종료!
			v[minVertex] = true;
			
			for(int[] g : graph[minVertex]) {
				if(!v[g[0]] && distance[g[0]]>min+g[1]) {
					distance[g[0]] = min+g[1];
				}
			}
		}
		
//		for(List<int[]> g : graph) {
//			for(int[] a : g) {
//				System.out.print(Arrays.toString(a));
//			}
//			System.out.println();
//		}
//		
//		System.out.println(Arrays.toString(distance));
		System.out.println(distance[end]);
	}

}

