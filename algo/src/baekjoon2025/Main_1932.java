package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1932 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] graph = new int[N][N+2];
		int cnt = 2;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<cnt;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
			cnt+=1;
		}
		
		
		int answer = 0;
		if(N==1) {
			answer = graph[0][1];
		}else {
			cnt = 3;
			for(int i=1;i<N;i++) {
				for(int j=1;j<cnt;j++) {
					graph[i][j] += Math.max(graph[i-1][j-1], graph[i-1][j]);
				}
				cnt+=1;
			}
			
			answer = Arrays.stream(graph[N-1]).max().getAsInt();
		}
		
		
		System.out.println(answer);
		br.close();

	}
}
