package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_16928 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graph = new List[101];
		for(int i=0;i<=100;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
 		}
		
		int[] count = new int[101];
		Arrays.fill(count, Integer.MAX_VALUE);
		count[1] = 0;
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(1);
		while(!q.isEmpty()&&count[100]==Integer.MAX_VALUE) {
			int num = q.poll();
			for(int i=1;i<=6;i++) {
				int nn = num+i;
				if(nn>100) {
					continue;
				}
				if(graph[nn].size()!=0) {
					nn = graph[nn].get(0);
				}
				if(nn>0&&nn<=100&&count[nn]>count[num]+1) {
					count[nn] = count[num]+1;
					q.offer(nn);
				}
			}
		}
		System.out.println(count[100]);
		
		br.close();
	}
}