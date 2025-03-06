package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_2805 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for(int i=0;i<N;i++) {	
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		
		int min = 0;
		int mid;
		while(min<=max) {
			mid = (max+min)/2;
			long sum = 0;
			for(int t : trees) {
				if(mid<t) {
					sum += t-mid;
				}
			}
			if(sum>=M) {
				min = mid+1;
			}else {
				max = mid-1;
			}
		}
		System.out.println(max);
		
		br.close();
	}
}
