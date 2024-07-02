package a0702.kruskal;

import java.io.*;
import java.util.*;

public class TopologicalSortBfsMain {
	static int N, M;
	static List<Integer>[] g;
	static int[] indegree; //각 정점들의 진입차수
	
	static void bfs() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		//PriorityQueue<Integer> q = new PriorityQueue<>(); //정점 오름차순
		for(int i=1;i<N+1;i++) {
			if(indegree[i]==0) q.offer(i);
		}
		while(!q.isEmpty()) {
			int i = q.poll();
			System.out.print(i + " ");
			for(int j:g[i]) {
				if(--indegree[j]==0) {
					q.offer(j);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/a0702/kruskal/input_topologicalsort.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		g = new List[N+1]; for(int i=1;i<N+1;i++) g[i]=new ArrayList<>();
		indegree = new int[N+1];
		for(int i=0;i<M;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			g[from].add(to);
			indegree[to]++; //진입차수누적(들어오는 수에 누적)
		}
		
		for(List<Integer> a:g) System.out.println(a);
		System.out.println("진입차수 : "+Arrays.toString(indegree)); //3에 2개(1, 2)가 들어오는 것을 확인할 수 있다. 
		
		bfs();
		sc.close();
	}

}

