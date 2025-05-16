package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1991 {
	static Node[] tree;
	static class Node{
		char me;
		Node left;
		Node right;
		Node(char m){
			this.me = m;
			this.left=null;
			this.right=null;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N =Integer.parseInt(br.readLine());
		
		tree = new Node[N+1];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			char node = st.nextToken().charAt(0);
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);
			
			if(tree[node-'A']==null) {
				tree[node-'A'] = new Node(node);
			}
			if(l!='.') {
				tree[l-'A'] = new Node(l);
				tree[node-'A'].left = tree[l-'A'];
			}
			if(r!='.') {
				tree[r-'A']=new Node(r);
				tree[node-'A'].right = tree[r-'A'];
			}
			
		}
		
		preorder(tree[0]);
		System.out.println();
		inorder(tree[0]);
		System.out.println();
		postorder(tree[0]);
		System.out.println();
		
		br.close();
	}
	
	public static void preorder(Node n) {
		if(n==null) return;
		System.out.print(n.me);
		preorder(n.left);
		preorder(n.right);
	}
	public static void inorder(Node n) {
		if(n==null) return;
		inorder(n.left);
		System.out.print(n.me);
		inorder(n.right);
	}
	public static void postorder(Node n) {
		if(n==null) return;
		postorder(n.left);
		postorder(n.right);
		System.out.print(n.me);
		
	}
}