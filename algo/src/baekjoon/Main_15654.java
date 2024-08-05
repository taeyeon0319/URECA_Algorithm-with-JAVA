package baekjoon;
import java.io.*;
import java.util.*;

public class Main_15654 {
	static int N, M;
	static int[] num, newnum;
	static boolean[] visited;

	public static void perm(int cnt) {
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				System.out.print(newnum[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			newnum[cnt] = num[i];
			perm(cnt+1);
			visited[i]=false;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		visited = new boolean[N];
		newnum = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		perm(0);
		
		
	}

}

