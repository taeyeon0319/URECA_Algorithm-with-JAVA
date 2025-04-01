package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_30804 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] tanghuru = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			tanghuru[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
}