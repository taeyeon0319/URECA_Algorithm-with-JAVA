package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_13549 {
	static int N, K;
	static boolean[] visited; 
	static int[] time;
	static int max = 100001;
	
	public static void bfs(int x) {
		visited[x] = true;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(x);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur==K) {
				return;
			}
			int[] newx = new int[3];
			newx[1] = cur-1;
			newx[2] = cur+1;
			newx[0] = cur*2;
			for(int i=0;i<3;i++) {
				int newnum = newx[i];
				
				if(newnum>=0 && newnum<max && !visited[newnum]) {
					visited[newnum]=true;
					
					if(i!=0) {
						time[newnum] = time[cur]+1;	
						q.addLast(newnum);
					}else {
						time[newnum] = time[cur];
						q.addFirst(newnum);
					}
				}
			}
			
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[max];
		time = new int[max];
		
		bfs(N);
		System.out.println(time[K]);
		
		br.close();
	}
}
