package a0702.kruskal;

import java.io.*;
import java.util.*;

public class Main_bj_2252_줄세우기_김태연 {
	static int N, M;
	static List<Integer>[] g;
	static int[] indegree;
	
	static void bfs() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for(int i=1;i<N+1;i++) {
			if(indegree[i]==0) q.offer(i); //진입차수가 0인 정점
		}
		while(!q.isEmpty()) {
			int i = q.poll();
			System.out.print(i + " ");
			for(int j:g[i]) {
				if(--indegree[j]==0) { //진입차수가 0인 정점
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
			g[a].add(b); //a가 b보다 앞에 서야 함으로 a->b 단방향
			indegree[b]++;//b에 들어오는 진입차수 누적
		}
		bfs();
		br.close();
	}

}
