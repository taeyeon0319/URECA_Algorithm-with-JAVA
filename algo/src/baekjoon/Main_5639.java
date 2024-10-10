package baekjoon;
import java.io.*;
import java.util.*;


public class Main_5639 {
	static class Node {
		int num;
		Node left;
		Node right;
		Node(int num){
			this.num = num;
			this.left = null;
			this.right = null;
		}
		
		void insert(int n) {
			if(this.num<n) {
				if(this.right==null) {
					this.right = new Node(n);
				}else {
					this.right.insert(n);
				}
			}else {
				if(this.left==null) {
					this.left = new Node(n);
				}else {
					this.left.insert(n);
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(br.readLine()));
		String s;
		while(true) {
			s = br.readLine();
			if(s==null||s.equals("")) break;
			int num = Integer.parseInt(s);
			root.insert(Integer.parseInt(s));
			
		}
		postOrder(root);
	}
	private static void postOrder(Node node) {
		if(node==null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.num);	
	}
}



