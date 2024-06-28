package a0627.greedy;

import java.io.*;
import java.util.*;

public class Main_bj_11047_동전0_김태연 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," "); 
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		
		int result = 0;
		
		for(int i=0;i<N;i++) {
			coin[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=N-1;i>=0;i--) {
			if(K>=coin[i]) {
				result += K/coin[i];
				K = K%coin[i];
			}
		}
		System.out.println(result);

	}

}
