package a0702.kruskal;

import java.io.*;
import java.util.*;

public class Main_bj_1197_최소스패닝트리_김태연 {
	static int V, E;
	static int[][] g;
	static int[] p;
	
	static void make() {
		p = new int[V+1];
		for(int i=0;i<V+1;i++) p[i]=i;
	}
	
	static int find(int a) {
		if(p[a]==a) return a;
		return p[a]=find(p[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a); //a의 부모 찾기
		int bRoot = find(b); //b의 부모 찾기
		if (aRoot==bRoot) return false; //둘은 이미 같은 조직(식구)임(부모가 같기 때문)
		
		//다르면 통합하자
//		if(aRoot<bRoot) p[bRoot] = aRoot;
//		else p[aRoot] = bRoot;
		p[bRoot] = aRoot; //p[aRoot]=aRoot이렇게 해도 상관없음(요구조건에 따라 달라짐)
		return true;
	}
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		g = new int[E+1][3];
		for(int i=1;i<E+1;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			g[i]=new int[] {from, to, cost};
		}
		
		Arrays.sort(g, (o1, o2)->Integer.compare(o1[2], o2[2]));
//		for(int[] e:g) System.out.println(Arrays.toString(e));
		make();
		int sum=0, cnt=0;
		for(int[] e: g) {
			if(union(e[0], e[1])) {
				sum+=e[2];
				if(++cnt==V-1) break;
			}
		}
		System.out.println(sum);
		sc.close();

	}

}
