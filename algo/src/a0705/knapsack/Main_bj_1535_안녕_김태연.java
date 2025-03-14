package a0705.knapsack;
//dp로 풀기
import java.io.*;
import java.util.*;

public class Main_bj_1535_안녕_김태연 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] lose = new int[N+1];
		int[] get = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) lose[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) get[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[100+1]; //체력+1
		for(int i=0;i<N;i++) {
			for(int h=100;h>0;h--) {
				if(h>lose[i]) {
					dp[h]= Math.max(dp[h], get[i]+dp[h-lose[i]]);
				}else {
					dp[i] = dp[i];
				}
			}
			//System.out.println(Arrays.toString(dp));
		}
		System.out.println(dp[100]);

	}

}




/* 재귀로 품
public class Main_bj_1535_안녕_김태연 {
	static int N;
	static ArrayList<Integer> result = new ArrayList<>();
	static int[] lose, get;
	
	static void hi(int idx, int health, int happy) {
		if(idx==N) {
			result.add(happy);
			return;
		}
		hi(idx+1, health, happy);
		if(health-lose[idx]>0) hi(idx+1, health-lose[idx], happy+get[idx]);
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		lose = new int[N+1];
		get = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) lose[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) get[i] = Integer.parseInt(st.nextToken());
		
		hi(0, 100, 0);
		Collections.sort(result);
		System.out.println(result.get(result.size()-1));

	}

}
*/
