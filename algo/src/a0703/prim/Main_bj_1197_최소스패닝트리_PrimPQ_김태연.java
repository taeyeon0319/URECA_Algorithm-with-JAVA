package a0703.prim;

import java.util.*;
import java.io.*;

public class Main_bj_1197_최소스패닝트리_PrimPQ_김태연 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); //정점의 개수
		int E = sc.nextInt(); //간선의 개수
		
		List<int[]>[] g = new List[V]; for(int i=0;i<V;i++) g[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
            int u = sc.nextInt(); // 정점 u
            int v = sc.nextInt(); // 정점 v
            int w = sc.nextInt(); // 가중치 w
            g[u - 1].add(new int[]{v - 1, w}); // u에서 v로 가는 가중치 w의 간선 추가
            g[v - 1].add(new int[]{u - 1, w}); // 양방향 그래프인 경우 추가
        }
		boolean[] v = new boolean[V];
		int[] minEdge = new int[V];
		for(int i=0;i<V;i++) minEdge[i] = Integer.MAX_VALUE;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		int sum=0, cnt=0;
		minEdge[0]=0;
		pq.offer(new int[] {0, 0});
		for(int i=0;i<V+1;i++) {
			int minVertex=-1;
			int min = Integer.MAX_VALUE;
			for(int j=0;j<V;j++) {
				if(!v[j] && min>minEdge[j]) {
					min=minEdge[j];
					minVertex=j;
				}
			}
			
			v[minVertex] = true;
			sum+=min;
			if(cnt++==V-1) break;
			for(int[] j:g[minVertex]) {
				if(!v[j[0]] && minEdge[j[0]]>j[1]) {
					minEdge[j[0]]=j[1];
					pq.offer(j);
				}
			}
		}
		System.out.println(sum);
		
		sc.close();

	}

}
