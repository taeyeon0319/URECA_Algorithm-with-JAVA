package a0620.perm;

import java.io.*;
import java.util.*;

public class Main_bj_15651_N과M3_김태연 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	
	static int N;
	static int M;
	
	static int[] a;
	static int[] b;
//	static boolean[] v;
	
	
	static void perm(int cnt) {
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
		for(int i=0;i<N;i++) {
//			if (v[i]) continue;
//			v[i]=true;
			b[cnt]=a[i];
			perm(cnt+1);
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
        perm(0);
        System.out.println(sb.toString());
        br.close();  
	}

}
