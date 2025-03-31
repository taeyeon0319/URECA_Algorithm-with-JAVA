package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_18111 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		int[][] land = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				land[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, land[i][j]);
				max = Math.max(max, land[i][j]);
			}
		}
		
		PriorityQueue<int[]> result = new PriorityQueue<>((o1, o2)->{
			if(o1[0]!=o2[0]) {
				return o1[0]-o2[0]; //최소시간이니 오름차순
			}else {
				return o2[1]-o1[1]; //땅의 높이 최대이니 내림차순
			}
		});
		for(int m=min;m<=max;m++) {
			int basket = B;
			int time=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					int diff = land[i][j]-m;
					if(diff>=0) {
						basket+=diff;
						time+=2*diff;
					}else {
						basket+=diff;
						time+=Math.abs(diff);
					}
				}
			}
			if(basket>=0) {
				result.offer(new int[] {time, m});

			}
		}
		int[] r = result.peek();
		System.out.println(r[0]+" "+r[1]);
	
	
		br.close();
	}
}