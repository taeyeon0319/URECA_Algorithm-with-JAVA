package a0708.algorithm;

import java.io.*;
import java.util.*;

public class Main_bj_17471_게리맨더링_김태연 {
	static int N;
	static int[] people;
	static List<Integer>[] g;
	static boolean[] visited;
	static int minResult = Integer.MAX_VALUE;
	static int total=0;
	
	static void bfs(int v) {
		int sum = people[v];
		visited[v] = true;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(v);
		while(!q.isEmpty()) {
			v = q.poll();
			for(int j:g[v]) {
				if(!visited[j-1]) {
					q.offer(j-1);
					sum += people[j-1];
					visited[j-1]=true;
				}
			}
		}
		minResult = Math.min(Math.abs(sum*2-total), minResult);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		people = new int[N];
		for(int i=0;i<N;i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		g = new List[N];
		for(int i=0;i<g.length;i++) g[i] = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			for(int j=0;j<n;j++) {
				int num = Integer.parseInt(st.nextToken());
				g[i].add(num);
			}
		}
		visited = new boolean[N];
		//for(List<Integer> a : g) System.out.println(a);
		for(int i=0;i<N;i++) {
			total+=people[i];
		}
		bfs(3);
		System.out.println(minResult);
		

	}

}
/*https://haerang94.tistory.com/391*/