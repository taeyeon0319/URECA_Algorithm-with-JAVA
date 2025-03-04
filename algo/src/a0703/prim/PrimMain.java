package a0703.prim;

import java.io.*;
import java.util.*;

public class PrimMain {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		List<int[]>[] g = new List[N]; for(int i=0;i<N;i++) g[i] = new ArrayList<int[]>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int c = sc.nextInt();
				if(c!=0) g[i].add(new int[]{j, c}); 
			}
		}
		
		boolean[] v = new boolean[N];
		int[] w = new int[N]; 
		for(int i=0;i<N;i++) w[i] = Integer.MAX_VALUE;
		
		int sum=0, cnt=0;
		w[0]=0;
		for(int i=0;i<N;i++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for(int j=0;j<N;j++) {
				if(!v[j] && min>w[j]) {
					min=w[j];
					minVertex=j;
				}
			}
			
			v[minVertex]=true;
			sum+=min;
			if(cnt++==N-1) break;
			
			for(int[] j:g[minVertex]) {
				if(!v[j[0]] && w[j[0]]>j[1]) {
					w[j[0]]=j[1]; //
				}
			}
			
		}
		System.out.println(sum);
		sc.close();
	}

}
