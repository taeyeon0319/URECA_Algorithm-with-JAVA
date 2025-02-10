package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_15663 {
	static int N, M;
	static int[] num, newnum;
	static List<Integer>[] g;
	static boolean[] v;
	
	public static void perm(int cnt) {
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				System.out.print(newnum[i]+" ");
			}
			System.out.println();
			return;
		}
		int before = 0;
		for(int i=0;i<N;i++) {
			if(v[i]) continue;
			if(before!=num[i]) {
				newnum[cnt] = num[i];
				v[i] = true;
				perm(cnt+1);
				before = num[i];
				v[i] = false;
			}
			
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		num = new int[N];
		newnum = new int[M];
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		v = new boolean[N];
		perm(0);
		
			
	}
}
