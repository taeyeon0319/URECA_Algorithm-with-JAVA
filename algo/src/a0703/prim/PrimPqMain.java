package a0703.prim;

import java.io.*;
import java.util.*;

public class PrimPqMain {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		List<int[]>[] g = new List[N]; for(int i=0;i<N;i++) g[i] = new ArrayList<int[]>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int c = sc.nextInt();
				if(c!=0) g[i].add(new int[]{j, c}); 
			}
		}
		
		boolean[] v = new boolean[N];
		int[] minEdge = new int[N]; 
		for(int i=0;i<N;i++) minEdge[i] = Integer.MAX_VALUE;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1], o2[1]));
		int sum=0, cnt=0;
		minEdge[0]=0;
		pq.offer(new int[] {0, 0});
		while(!pq.isEmpty()) {
			int[] vw = pq.poll();
			int minVertex = vw[0];
			int min = vw[1];
			if(v[minVertex]) continue;
			
			v[minVertex]=true;
			sum+=min;
			if(cnt++==N-1) break;
			
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
