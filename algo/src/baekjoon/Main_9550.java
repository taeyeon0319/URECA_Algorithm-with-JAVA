package baekjoon;
import java.io.*;
import java.util.*;

public class Main_9550 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int sum=0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int a = Integer.parseInt(st.nextToken());
				sum += a/K;
			}
			System.out.println(sum);
		}
		
		br.close();
	}
}

