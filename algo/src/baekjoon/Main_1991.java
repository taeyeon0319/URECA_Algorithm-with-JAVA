package baekjoon;
import java.io.*;
import java.util.*;

public class Main_1991 {
	//노드 생성
	static class Node{
		char value;
		Node left;
		Node right;
		
		public Node(char value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	static Node[] tree;
	//전위 순회
	public static void preorder(Node node) {
		if(node==null) return;
		System.out.print(node.value);
		preorder(node.left);
		preorder(node.right);
	}
	
	//중위 순회
	public static void inorder(Node node) {
		if(node==null) return;
		inorder(node.left);
		System.out.print(node.value);
		inorder(node.right);
	}
	
	//후위 순회
	public static void postorder(Node node) {
		if(node==null) return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.value);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		tree = new Node[N+1]; //노드 배열 생성
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			char parentValue = st.nextToken().charAt(0);
			char leftValue = st.nextToken().charAt(0);
			char rightValue = st.nextToken().charAt(0);
			
			if(tree[parentValue-'A']==null) { //만약 부모노드가 아직 생성되지 않았다면
				tree[parentValue-'A'] = new Node(parentValue); // 부모 노드를 생성해라.
			}
			if(leftValue !='.') {
				tree[leftValue-'A'] = new Node(leftValue);
				tree[parentValue-'A'].left = tree[leftValue-'A'];
			}
			if(rightValue != '.') {
				tree[rightValue-'A'] = new Node(rightValue);
				tree[parentValue-'A'].right = tree[rightValue-'A'];
			}
		}
		
		preorder(tree[0]);
		System.out.println();
		inorder(tree[0]);
		System.out.println();
		postorder(tree[0]);
	}
}

