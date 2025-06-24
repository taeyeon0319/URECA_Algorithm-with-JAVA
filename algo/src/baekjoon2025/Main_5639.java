package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_5639 {
	static class Node{
		int num;
		Node left;
		Node right;
		
		Node(int n){
			this.num = n;
			this.left = null;
			this.right=null;
		}
		
		void insert(int n) {
			//만약 부모보다 작으면
			if(n<this.num) {
				//만약 부모의 left가 비어있으면
				if(this.left==null) {
					this.left = new Node(n);
				}else {
					this.left.insert(n);
				}
			}
			
			//만약 부모보다 크면
			else {
				if(this.right==null) {
					this.right = new Node(n);
				}else {
					this.right.insert(n);
				}
			}
		}
	}

	//후위 순회
	public static void postOrder(Node n) {
		if(n==null) return;
		postOrder(n.left);
		postOrder(n.right);
		System.out.println(n.num);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		if(s==null || s=="") return;
		Node root = new Node(Integer.parseInt(s));
		
		while((s=br.readLine())!=null) {
			if(s.equals("")) break;
			root.insert(Integer.parseInt(s));
		}
		postOrder(root);
		br.close();
	}
}
