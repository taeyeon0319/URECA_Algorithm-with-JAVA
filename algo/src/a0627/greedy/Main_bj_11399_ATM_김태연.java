package a0627.greedy;

import java.io.*;
import java.util.*;

public class Main_bj_11399_ATM_김태연 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(P);
		int result = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<=i;j++) {
				result += P[j];
			}
		}
		
		System.out.println(result);

	}

}
