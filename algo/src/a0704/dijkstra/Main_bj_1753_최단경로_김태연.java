package a0704.dijkstra;

import java.io.*;
import java.util.*;

public class Main_bj_1753_최단경로_김태연 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		List<int[]>[] g =new List[V+1]; 
		for(int i=0;i<=V;i++) g[i]=new ArrayList<int[]>();
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			g[u].add(new int[] {v, w});
		}


		boolean[] v = new boolean[V+1];
		int[] d = new int[V+1];
		for(int i=0;i<V+1;i++) d[i]=Integer.MAX_VALUE;
		
		d[K]=0;
		for(int i=1;i<=V;i++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for(int j=1;j<=V;j++) {
				if(!v[j] && min>d[j]) {
					min=d[j];
					minVertex = j;
				}
			}
			if (minVertex==-1) break;
			v[minVertex]=true;
//			if(minVertex==V) break;
			
			for(int[] j:g[minVertex]) {
				if(!v[j[0]] && d[j[0]]>min+j[1]) {
					d[j[0]]=min+j[1];
				}
			}
		}
		for(int i=1;i<=V;i++) {
			if (d[i]==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(d[i]);
		}
		br.close();
	}

}
