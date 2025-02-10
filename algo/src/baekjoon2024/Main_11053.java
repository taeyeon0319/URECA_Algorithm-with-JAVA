package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_11053 {
	static int N;
	static int[] A, dp;
	
	static int LIS(int N) {
		if(dp[N] == 0) {
			dp[N] = 1;	// 1로 초기화 
			for(int i=0;i<N;i++) {
				
			}
		}
		return dp[N];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N];
		dp[0] = 1;
		
		for(int i=1;i<N;i++) {
			int max=0;
			int index=0;
			for(int j=i-1;j>=0;j--) {
				if(A[j]<A[i]) {
					if(max<dp[j]) {
						max=dp[j];
						index = j;
					}
				}
			}
			if(max==0) {
				dp[i]=1;
			}else {
				dp[i] = dp[index]+1;
			}
		}
		
		int result = dp[0];
		for(int i=1;i<N;i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
//		System.out.println(Arrays.toString(dp));
		
		
		
	}
	

}


