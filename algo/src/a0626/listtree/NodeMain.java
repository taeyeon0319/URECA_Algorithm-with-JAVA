package a0626.listtree;

import java.io.*;
import java.util.*;

public class NodeMain {
	static class Node{
		int vertex; //정점 번호(data)
		Node link; //다음 정점(next/right)
		Node(int vertex, Node link){
			this.vertex=vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			//return vertex+"->"+link;
			return ""+(char)(vertex+'A')+vertex+"->"+link;
		}
	}
	
	static int N;
	static Node[] g;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_graph.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //-- 정점의 개수
		int E = sc.nextInt(); //-- 간선의 개수
		g = new Node[N];
		for(int i=0;i<E;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			g[from]=new Node(to, g[from]); // addfirst
			//g[to] = new Node(from, g[to]);
		}
		
		for(int i=0;i<N;i++) {
			System.out.print(""+(char)(i+'A')+i+": ");
			for(Node j=g[i];j!=null;j=j.link) {
				System.out.print(""+(char)(j.vertex+'A')+j.vertex+"->");
			}
			System.out.println("null");
		}
		System.out.println();
		
		//for(Node a:g) System.out.println(a); System.out.println();
//		for(int i=0;i<N;i++) {
//			System.out.println(""+(char)(i+'A')+i+": "+g[i]);
//		}
		sc.close();
	}
}
/*
 
 ....A0     정점의 개수 : 7  간선의 개수 : 8
 .../.\     0 1  0 2
 ..B1.C2   
 ./.\./     1 3  1 4  2 4
 D3.E4      
 ..\.|      3 5  4 5
 ...F5-G6   5 6
 
 */
