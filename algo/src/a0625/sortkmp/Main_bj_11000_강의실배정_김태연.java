package a0625.sortkmp;

import java.io.*;
import java.util.*;

public class Main_bj_11000_강의실배정_김태연 {
	static int N;
	static int[][] C;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		C = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			C[i][0] = Integer.parseInt(st.nextToken());
			C[i][1] = Integer.parseInt(st.nextToken());
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Arrays.sort(C, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		
		for(int[] time:C) {
			int start = time[0];
			int end = time[1];
			
			if (!pq.isEmpty() && pq.peek()<=start) {
				pq.poll();
			}
			pq.offer(end);
		}
		System.out.println(pq.size());
	}
}
