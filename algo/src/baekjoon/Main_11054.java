package baekjoon;
import java.io.*;
import java.util.*;

public class Main_11054 {
	static int N;
	static int[] r_dp, l_dp;
	static int[] A;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		A = new int[N];
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		r_dp = new int[N];
		l_dp = new int[N];
		
		for(int i=0;i<N;i++) {
			LIS(i); //순방향
			LDS(i); //역방향
//			System.out.println(LIS(i)+LDS(i));
//			System.out.println(+i+" : " + Arrays.toString(r_dp));
		}
		
		
		int max=-1;
		for(int i=0;i<N;i++) {
			max = Math.max(LIS(i)+LDS(i), max);
		}
		System.out.println(max-1);
	}

	private static int LIS(int index) {
		if(r_dp[index]==0) {
			r_dp[index]=1;
			
			for(int i=index-1;i>=0;i--) {
				if(A[i] < A[index]) {
					r_dp[index] = Math.max(r_dp[index], LIS(i)+1);
				}
			}
		}
		return r_dp[index];
	}
	
	private static int LDS(int index) {
		if(l_dp[index]==0) {
			l_dp[index]=1;
			
			for(int i=index;i<A.length;i++) {
				if(A[i]<A[index]) {
					l_dp[index] = Math.max(l_dp[index], LDS(i)+1);
				}
			}
		}
		return l_dp[index];
	}

}

