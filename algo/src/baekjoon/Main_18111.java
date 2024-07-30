package baekjoon;
import java.io.*;
import java.util.*;

public class Main_18111 {
	static int N, M, B;
	static int[][] land;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		land = new int[N][M];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				land[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, land[i][j]);
				max = Math.max(max, land[i][j]);
			}
		}
		
		PriorityQueue<int[]> result = new PriorityQueue<>((o1, o2) -> {
			if(o1[0]!=o2[0]) {
				return Integer.compare(o1[0], o2[0]);
			}else {
				return Integer.compare(o2[1], o1[1]);
			}
		});
		for(int v=min;v<=max;v++) {
			int c = B;
			int time=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					int diff = land[i][j] -v;
					if(diff>0) {
						time+=2*diff;
						c+=diff;
					}else {
						time-=1*diff;
						c+=diff;
					}
				}
			}
			if(c>=0) {
				result.offer(new int[] {time, v});
			}
		}
		int[] r = result.peek();
		System.out.println(r[0]+" "+r[1]);
	}

}

