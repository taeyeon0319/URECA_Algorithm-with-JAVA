package a0702.kruskal;

import java.io.*;
import java.util.*;
public class DisjointSetMain {
	static int N;
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
		
		//다르면 통합하자
//		if(aRoot<bRoot) p[bRoot] = aRoot;
//		else p[aRoot] = bRoot;
		p[bRoot] = aRoot; //p[aRoot]=aRoot이렇게 해도 상관없음(요구조건에 따라 달라짐)
		return true;
	}
	
	
	public static void main(String[] args) throws Exception {
		N=5;
		make();
		System.out.println("{0, 1, 2, 3, 4}");
		System.out.println(Arrays.toString(p));
		
		System.out.println("=====union=====");
		System.out.println(union(0, 1));
		System.out.println(Arrays.toString(p));
		System.out.println(union(2, 1));
		System.out.println(Arrays.toString(p));
		System.out.println(union(3, 2));
		System.out.println(Arrays.toString(p));
		System.out.println(union(4, 3));
		System.out.println(Arrays.toString(p));
		
		System.out.println("=====find=====");
		System.out.println(find(4));
		System.out.println(Arrays.toString(p));
		System.out.println(find(3));
		System.out.println(Arrays.toString(p));
		System.out.println(find(2));
		System.out.println(Arrays.toString(p));
		System.out.println(find(0));
		System.out.println(Arrays.toString(p));
	}

}
