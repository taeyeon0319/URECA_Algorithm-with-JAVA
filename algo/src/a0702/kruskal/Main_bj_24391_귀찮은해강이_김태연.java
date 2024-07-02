package a0702.kruskal;

import java.io.*;
import java.util.*;

public class Main_bj_24391_귀찮은해강이_김태연 {
	static int N, M;
	static int[] building;
	
	static int find(int a) {
		if(building[a]==a) return a;
		return building[a]=find(building[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false;
		if(aRoot>bRoot) building[aRoot] = bRoot;
		else building[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		building = new int[N+1];
		for(int i=0;i<N+1;i++) building[i]=i;
		for(int k=0;k<M;k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			union(i, j);

		}
		
		int[] code = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int k=0;k<N;k++) {
			code[k] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		

		for (int i = 0; i < N - 1; i++) {
            int a = code[i];
            int b = code[i + 1];

            int r1 = find(a); //부모를 찾아
            int r2 = find(b); //부모를 찾아

            if (r1 != r2) result++;
        }

		System.out.println(result);

	}

}
