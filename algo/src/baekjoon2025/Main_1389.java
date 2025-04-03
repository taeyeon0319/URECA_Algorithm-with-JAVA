package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1389 {
	static int N, M;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int[] distance;
	
	public static int bfs(int v) {
		visited[v] = true;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(v);
		while(!q.isEmpty()) {
			v = q.poll();
			for(Integer g : graph[v]) {
				if(!visited[g]) {
					distance[g] = distance[v]+1;
					q.offer(g);
					visited[g]=true;
				}
			}
		}
		int sum = 0;
		for(int k=0;k<distance.length;k++) {
			sum+=distance[k];
		}
		return sum;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //유저의 수
		M = Integer.parseInt(st.nextToken()); //친구 관계의 수
		
		graph = new List[N+1];

		for(int i=0;i<=N;i++) {
			graph[i]=new ArrayList<>();
		}
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			graph[B].add(A);
		}

		int min = Integer.MAX_VALUE;
		int answerPerson=0;
		for(int i=1;i<=N;i++) {
			visited = new boolean[N+1];
			distance = new int[N+1];
			if(bfs(i)<min) {
				answerPerson=i;
				min = bfs(i);
			}
			
		}
		System.out.println(answerPerson);
		
	}
}