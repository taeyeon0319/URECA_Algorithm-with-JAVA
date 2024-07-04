package a0704.dijkstra;

import java.io.*;
import java.util.*;

public class DijkstraPqMain {
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
		int[] d = new int[N]; 
		for(int i=0;i<N;i++) d[i] = Integer.MAX_VALUE;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1], o2[1]));
		d[0]=0;
		pq.offer(new int[] {0, d[0]});
		while(!pq.isEmpty()) {
			int[] vw = pq.poll();
			int minVertex = vw[0];
			int min = vw[1];
			if(v[minVertex]) continue;
			
			v[minVertex]=true;
			if(minVertex==N-1) break;
			
			for(int[] j:g[minVertex]) {
				if(!v[j[0]] && d[j[0]]>min+j[1]) {
					d[j[0]]=min+j[1]; 
					pq.offer(new int[] {j[0], d[j[0]]});
					//pq.offer(j);
				}
			}
			
		}
		System.out.println(d[N-1]);
		sc.close();
	}

}
