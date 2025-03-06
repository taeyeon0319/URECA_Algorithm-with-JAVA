package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_2630 {
	static int N;
	static int[][] graph;
	static int result_w;
	static int result_b;
	
	public static void paper(int n, int row, int col) {
		int color = graph[row][col];
		boolean check = true;
		for(int i=row;i<row+n;i++) {
			for(int j=col;j<col+n;j++) {
				if(graph[i][j]!=color) {
					check=false;
					break;
				}
			}
			if(!check) break;
		}
		if(check) {
			if(color==0) result_w++;
			else result_b++;
		}else {
			paper(n/2, row, col);
			paper(n/2, row, col+n/2);
			paper(n/2, row+n/2, col);
			paper(n/2, row+n/2, col+n/2);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		paper(N, 0, 0);
		System.out.println(result_w);
		System.out.println(result_b);

		br.close();
	}
}
