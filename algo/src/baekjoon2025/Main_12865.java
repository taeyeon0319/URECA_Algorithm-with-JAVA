package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_12865 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] stuff = new int[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			stuff[i][0] = Integer.parseInt(st.nextToken());
			stuff[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] maxvalue = new int[N+1][K+1];
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=K;j++) {
				if(j<stuff[i-1][0]) {
					maxvalue[i][j] = maxvalue[i-1][j];
				}else {
					maxvalue[i][j] = Math.max(maxvalue[i-1][j], maxvalue[i-1][j-stuff[i-1][0]]+stuff[i-1][1]);
				}
				
			}
		}
		System.out.println(maxvalue[N][K]);
		
		br.close();
	}
}
