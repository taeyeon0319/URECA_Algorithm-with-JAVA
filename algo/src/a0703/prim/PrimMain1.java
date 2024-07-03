package a0703.prim;

import java.io.*;
import java.util.*;

public class PrimMain1 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/a0703/prim/input_prim.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		List<int[]>[] g = new List[N]; for(int i=0;i<N;i++) g[i] = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int c = sc.nextInt();
				if(c!=0) g[i].add(new int[]{j, c}); //인접정점번호, 비용
			}
		}
		
//		for (List<int[]> list : g) {
//		    for (int[] arr : list) {
//		        System.out.println(Arrays.toString(arr));
//		    }
//		}
		boolean[] v = new boolean[N];
		int[] minEdge = new int[N]; //Arrays.fill(minEdge, Integer.MAX_VALUE);
		for(int i=0;i<N;i++) minEdge[i] = Integer.MAX_VALUE;
		
		int sum=0, cnt=0;
		minEdge[0]=0;
		System.out.println(Arrays.toString(minEdge)); System.out.println();
		for(int i=0;i<N;i++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for(int j=0;j<N;j++) {
				if(!v[j] && min>minEdge[j]) {
					min=minEdge[j];
					minVertex=j;
				}
			}
			
			v[minVertex]=true;
			sum+=min;
			System.out.println(Arrays.toString(v)); //방문처리확인
			System.out.println("minVertex="+minVertex+" min="+min+" sum="+sum);
			if(cnt++==N-1) break;
			
			for(int[] j:g[minVertex]) {
				if(!v[j[0]] && minEdge[j[0]]>j[1]) {
					minEdge[j[0]]=j[1]; //
				}
			}
			
		}
		System.out.println(sum);
		sc.close();
	}

}
