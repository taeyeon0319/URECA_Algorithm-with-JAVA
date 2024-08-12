package baekjoon;
import java.io.*;
import java.util.*;

public class Main_1932 {
	static int N, M;
	static int[] num, result;


	static void perm(int start, int cnt) {
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		int before = -1;
		for(int i=start;i<N;i++) {
			int now = num[i];
			if(before != now) {
				before = now;
				result[cnt] = num[i];
				perm(i, cnt+1);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		result = new int[M];
		perm(0, 0);
		
		
	}

}

