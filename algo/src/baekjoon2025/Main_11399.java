package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_11399 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] line = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(line);
		int answer = 0;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<i;j++) {
				answer += line[j];
			}
		}
		System.out.println(answer);
		br.close();
	}
}
