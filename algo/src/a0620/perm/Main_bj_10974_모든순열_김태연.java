package a0620.perm;

import java.io.*;
import java.util.*;

public class Main_bj_10974_모든순열_김태연 {
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	
	static int[] a;
	static int[] b;
	static boolean[] v;
	
	static void perm(int cnt) {
		if(cnt==N) {
			for(int i=0;i<N;i++) {
				sb.append(b[i]);
				if(i<N-1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<N;i++) {
			if (v[i]) continue;
			v[i]=true;
			b[cnt]=a[i];
			perm(cnt+1);
			v[i]=false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		a = new int[N];
		for(int i=0;i<N;i++) {
			a[i]=i+1;
		}
		b = new int[N];
		v = new boolean[N];
        perm(0);
        System.out.println(sb.toString());
        br.close();  
	}
}
