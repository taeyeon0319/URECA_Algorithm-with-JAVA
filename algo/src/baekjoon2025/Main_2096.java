package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_2096 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][3];
		int[][] max_result = new int[N][3];
		int[][] min_result = new int[N][3];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<3;i++) {
			max_result[0][i] = graph[0][i];
			min_result[0][i] = graph[0][i];
		}
		
		for(int i=1;i<N;i++) {
			max_result[i][0] = Math.max(max_result[i-1][0], max_result[i-1][1]) + graph[i][0];
			max_result[i][1] = Math.max(max_result[i-1][0], Math.max(max_result[i-1][1], max_result[i-1][2]))+ graph[i][1];
			max_result[i][2] = Math.max(max_result[i-1][1], max_result[i-1][2])+graph[i][2];
			
			min_result[i][0] = Math.min(min_result[i-1][0], min_result[i-1][1]) + graph[i][0];
			min_result[i][1] = Math.min(min_result[i-1][0], Math.min(min_result[i-1][1], min_result[i-1][2]))+ graph[i][1];
			min_result[i][2] = Math.min(min_result[i-1][1], min_result[i-1][2])+graph[i][2];
		}
		
		System.out.print(Arrays.stream(max_result[N-1]).max().getAsInt()+" ");
		System.out.println(Arrays.stream(min_result[N-1]).min().getAsInt());

		br.close();
	}
}
