package a0705.knapsack;

import java.io.*;
import java.util.*;

public class Knapsack1Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/a0705/knapsack/input_knapsack.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		for(int i=0;i<N;i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		int[]dp = new int[W+1];
		for(int i=0;i<N;i++) {
			for(int w=W;w>0;w--) {
				if(weights[i]<=w) {
					dp[w]=Math.max(dp[w], profits[i]+dp[w-weights[i]]);
				}else {
					dp[i]= dp[i];
				}
			}
			System.out.println(Arrays.toString(dp));
		}
		System.out.println(dp[W]);
		sc.close();

	}

}

/*

4
10
5 10
4 40
6 30
3 50

 */
