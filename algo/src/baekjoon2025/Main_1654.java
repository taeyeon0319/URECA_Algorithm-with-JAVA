package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1654 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] lines = new int[K];
		
		long max = 0;
		long min = 1;
		for(int i=0;i<K;i++) {
			lines[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lines[i]);
		}
		
		while(min<=max) {
			long mid = (max+min)/2;
			long sum=0;
			for(int l : lines) {
				sum+=(l/mid);
			}
			if(sum>=N) {
				min = mid+1;
			}else {
				max = mid-1;
			}
		}
		System.out.println(max);
		
		br.close();
	}
}
