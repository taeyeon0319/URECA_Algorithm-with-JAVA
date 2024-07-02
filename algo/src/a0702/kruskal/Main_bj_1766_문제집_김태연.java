package a0702.kruskal;

import java.io.*;
import java.util.*;

public class Main_bj_1766_문제집_김태연 {
	static int N, M;
	static List<Integer>[] g;
	static int[] indegree;
	
	static void bfs() {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i=1;i<N+1;i++) {
			if(indegree[i]==0) q.offer(i);
		}
		while(!q.isEmpty()) {
			int i=q.poll();
			System.out.print(i+" ");
			for(int j:g[i]) {
				if(--indegree[j]==0) {
					q.offer(j);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		g = new List[N+1]; for(int i=1;i<N+1;i++) g[i]=new ArrayList<>();
		indegree = new int[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a].add(b);
			indegree[b]++;
		}
//		System.out.println(Arrays.toString(indegree));
		bfs();
		br.close();

	}

}
