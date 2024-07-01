package a0701.graph;

import java.io.*;
import java.util.*;

public class GraphNodeMain {
	static int N;
	static Node[] g;
	static boolean[] v;
	
	static class Node{
		int vertex;
		Node link;
		Node(int vertex, Node link){
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return ""+(char)(vertex+'A')+vertex+"->"+link;
		}
	}
	
	
	static void dfs(int i) {
		v[i] = true;
		System.out.println((char)(i+'A') + ""+i);
		for(Node j=g[i]; j!=null;j=j.link) { //N->0
			if(!v[j.vertex]) {
				dfs(j.vertex);
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
			for(Node j=g[i];j!=null;j=j.link) {
				if(!v[j.vertex]) {
					q.offer(j.vertex);
					v[j.vertex]=true;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/a0701/graph/input_graph.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		
		g = new Node[N];
		v = new boolean[N];
		for(int i=0;i<E;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			g[from] = new Node(to, g[from]);
			g[to] = new Node(from, g[to]);
		}
//		for(Node a:g) System.out.println(a);
//		for(int i=0;i<N;i++) System.out.println(""+(char)(i+'A')+": "+g[i]);
//		dfs(0);
		bfs(0);
		sc.close();
	}

}

/*
x 
0 -> 2->1->Null
1 -> 4->3->0->Null
2 -> 4->0->Null
3 -> 5->1->Null
4 -> 5->2->1->Null
5 -> 6->4->3->Null
6 -> 5->Null
*/