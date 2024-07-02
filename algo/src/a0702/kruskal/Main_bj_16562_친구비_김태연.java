package a0702.kruskal;

import java.io.*;
import java.util.*;

public class Main_bj_16562_친구비_김태연 {
	static int N, M, k;
	static int[] money;
	static int[] friend;
	
	static int find(int a) {
		if(friend[a]==a) return a;
		return friend[a]=find(friend[a]);
	}
	static boolean union(int v, int w) {
		int vRoot = find(v);
		int wRoot = find(w);
		if(vRoot==wRoot) return false;
		
		if(vRoot<wRoot) friend[wRoot]=vRoot;
		else friend[vRoot] = wRoot;
		return true;
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		money = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		friend = new int[N+1];
		for(int i=1;i<N+1;i++) friend[i] = i;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			union(v, w);
		}
		for(int i=1;i<N+1;i++) {
			find(i);
		}
		
		int[] result = new int[N];
		for(int i=1;i<N+1;i++) {
			boolean s = false;
			for(int j=0;j<i;j++) {
				if (friend[i] == friend[j]) s = true;
			}
			if (s==false) result[friend[i]] = Math.max(result[friend[i]], money[i]);
		}
		
		System.out.println(Arrays.toString(result));
//		if (result>k) System.out.println("Oh no");
//		else System.out.println(result);
	}
}
