package a0702.kruskal;

import java.io.*;
import java.util.*;
public class KruskalMain {
	static int N;
	static int[][] g = new int[N][3];
	static int[] p;
	
	static void make() {
		p = new int[N];
		for(int i=0;i<N;i++) p[i]=i;
		
	}
	static int find(int a) {
		if(p[a]==a) return a; //부모 찾기
		return p[a]=find(p[a]);
	}	
	static boolean union(int a, int b) {
		int aRoot = find(a); //a의 부모 찾기
		int bRoot = find(b); //b의 부모 찾기
		if (aRoot==bRoot) return false; //둘은 이미 같은 조직(식구)임(부모가 같기 때문)
		
		p[bRoot] = aRoot; //p[aRoot]=aRoot이렇게 해도 상관없음(요구조건에 따라 달라짐)
		return true;
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/a0702/kruskal/input_kruskal.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E= sc.nextInt();
		g = new int[E][3];
		for(int i=0;i<E;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			g[i]=new int[]{from, to, cost};
		}
		//for(int[] e:g) System.out.println(Arrays.toString(a));
		Arrays.sort(g, (o1, o2)->Integer.compare(o1[2], o2[2]));//Integer, long, double, float만 이거
//		for(int[] e:g) System.out.println(Arrays.toString(a));
		make();
		int sum=0, cnt=0;
		for(int[] e:g) {
			if(union(e[0], e[1])) {
				sum+=e[2];
				if(++cnt==N-1) break;
				
			}
		}
		System.out.println(sum);
		sc.close();
	}

}
