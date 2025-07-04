package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1167 {
	static int V;
	static List<int[]>[] tree;
	static boolean[] visited;
	static int[] dist;
	static int max = 0; //가장 먼 거리
	static int farthest = 0; //가장 먼 정점
	
	public static void dfs(int v, int sum) {
		visited[v] = true;
		
		for(int[] t : tree[v]) {
			if(!visited[t[0]]) {
				dfs(t[0], sum+t[1]);
			}
		}
		
		if(sum>max) {
			max = sum;
			farthest = v;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		
		tree = new List[V+1];
		for(int i=0;i<=V;i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0;i<V;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			while(true) {
				int e = Integer.parseInt(st.nextToken());
				if(e==-1) {
					break;
				}
				int d = Integer.parseInt(st.nextToken());
				tree[s].add(new int[] {e, d});
			}
		}
		
		visited = new boolean[V+1];
		dfs(1, 0);
		
		visited = new boolean[V+1];
		max = 0;
		dfs(farthest, 0);
		
//		visited = new boolean[V+1];
//		dist = new int[V+1];
//		dfs(1);
//		System.out.println(Arrays.toString(dist));
		
		System.out.println(max);
		//출력 확인
//		for(List<int[]> t : tree) {
//			for(int[] tt : t) {
//				System.out.print(Arrays.toString(tt));
//			}
//			System.out.println();
//		}
		br.close();
	}
}
