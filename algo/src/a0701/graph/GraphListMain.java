package a0701.graph;

import java.io.*;
import java.util.*;

//간선의 수가 많지 않을때(<정점*정점보다 작을 때)는 이 방법을 사용!
//인접리스트방법
public class GraphListMain {
	static int N;
	static List<Integer>[] g;
	static boolean[] v;
	
	static void dfs(int i) {q
		v[i] = true;
		System.out.println((char)(i+'A') + ""+i);
		for(int j:g[i]) {
			if(!v[j]) {
				dfs(j);
			}		
		}
	}
	
	static void bfs(int i) {
		v[i]=true;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(i);
		while(!q.isEmpty()) {
			i = q.poll();
			System.out.println((char)(i+'A') + ""+i);
			for(int j:g[i]) {
				if(!v[j]) {
					q.offer(j);
					v[j]=true;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/a0701/graph/input_graph.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		
		g = new List[N];
		v = new boolean[N];
		for(int i=0;i<g.length;i++) g[i] = new ArrayList<>(); //NullPointer안 나오게 꼭 필요! 완전 중요!! 이거 꼭 들어가야함★★★★★
		for(int i=0;i<E;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			g[from].add(to);
			g[to].add(from);
		}
		for(List<Integer> a:g) System.out.println(a);
		
//		dfs(0);
		bfs(0);
		sc.close();
	}

}

/*
x 
0 -> 1 2
1 -> 0 3 4
2 -> 0 4
3 -> 1 5
4 -> 1 2 5
5 -> 3 4 6
6 -> 5
*/