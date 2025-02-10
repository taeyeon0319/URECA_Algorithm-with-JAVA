package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_15666 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] triangle = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<i+1;j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=N-2;i>=0;i--) {
			for(int j=0;j<=i;j++) {
				triangle[i][j] = Math.max(triangle[i+1][j], triangle[i+1][j+1]) + triangle[i][j];
			}
		}
		System.out.println(triangle[0][0]);
		
	}

}

