package baekjoon;
import java.io.*;
import java.util.*;

public class Main_17626 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 1;
		if(N>=2) {
			for(int i=1;i<=N;i++) {
				int a = (int)Math.sqrt(i);
				if(Math.sqrt(i)==a) {
					dp[i]=1;
				}else {
					for(int j=a;j>0;j--) {
						int p = (int) Math.pow(j, 2);
						dp[i] = Math.min(dp[p]+dp[i-p], dp[i]);
					}
				}
			}
		}

		System.out.println(dp[N]);
	}

}

