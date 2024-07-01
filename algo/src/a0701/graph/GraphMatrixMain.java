package a0701.graph;

import java.io.*;
import java.util.*;
//배열 방법
public class GraphMatrixMain {
	static int N;
	static int[][] g;
	static boolean[] v;
	
	static void dfs(int i) {
		v[i] = true;
		System.out.println((char)(i+'A') + ""+i);
		for(int j=0;j<N;j++) {
			if (g[i][j]!=0 && !v[j]) {
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
			for(int j=0;j<N;j++) {
				if(g[i][j]!=0 && !v[j]) {
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
		
		g = new int[N][N];
		v = new boolean[N];
		for(int i=0;i<E;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			g[from][to] = 1;
			g[to][from] = 1;
		}
//		for(int[] a:g) System.out.println(Arrays.toString(a));
		
//		dfs(0);
		bfs(0);
		sc.close();
	}

}

/*
x 0 1 2 3 4 5 6
0 . 1 1 . . . .
1 1 . . 1 1 . .
2 1 . . . 1 . .
3 . 1 . . . 1 .
4 . 1 1 . . 1 .
5 . . . 1 1 . 1
6 . . . . . 1 .
*/