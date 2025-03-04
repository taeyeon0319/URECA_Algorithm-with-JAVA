package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_11659 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] list = new int[N+1];
		int[] prefixsum = new int[N+1];
		
		st =new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			list[i] = Integer.parseInt(st.nextToken());
			prefixsum[i] = prefixsum[i-1]+list[i];
			
		}
		StringBuilder sb = new StringBuilder();
		for(int a=0;a<M;a++) {
			st =new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(prefixsum[j]-prefixsum[i-1]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
