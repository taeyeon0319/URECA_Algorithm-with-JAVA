package a0621.combsubs;

import java.io.*;
import java.util.*;

public class Main_bj_15650_N과M2_김태연 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	
	static int N;
	static int M;
	
	static int[] a;
	static int[] b;
//	static boolean[] v;
	
	
	static void comb(int cnt, int start) {
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				sb.append(b[i]);
				if(i<M-1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<N;i++) {
//			if (v[i]) continue;
//			v[i]=true;
			b[cnt]=a[i];
			comb(cnt+1, i+1);
//			v[i]=false;
		}
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		a = new int[N];
		for(int i=0;i<N;i++) {
			a[i]=i+1;
		}
		b = new int[M];
//		v = new boolean[N];
        comb(0, 0);
        System.out.println(sb.toString());
        br.close();  
	}

}
