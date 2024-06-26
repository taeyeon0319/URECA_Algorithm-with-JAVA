package a0626.listtree;

import java.io.*;
import java.util.*;

public class Main_bj_1991_트리순회_김태연 {
	static class CompleteBinaryTree<T>{
		final int SIZE;
		Object[] nodes;
		int lastIndex = 1;
		
		CompleteBinaryTree(int size) {
			SIZE = size*2;
			nodes = new Object[size*2+1];
		}
		
		//값 저장
		void add(Character parent, Character left, Character right) {
			if(parent!='.' && parent!='A') {
				lastIndex = Arrays.asList(nodes).indexOf(parent);
				nodes[lastIndex] = parent;
			}else {
				nodes[1]=parent;
			}
			if(left !='.') {
				nodes[lastIndex*2] = left;
			}
			if(right !='.') {
				nodes[lastIndex*2+1] = right;
			}
//			System.out.println(Arrays.toString(nodes));
		}
//		void add(Character t) {
//			boolean check = false;
//			for(int i=0;i<nodes.length;i++) {
//				if (t!='.' && t.equals(nodes[i])) check=true;
//			}
//			if(check==false) {
//				if(lastIndex==SIZE) {
//					System.out.println("포화상태!");
//					return;
//				}
//				nodes[++lastIndex]=t;
////				System.out.println(Arrays.toString(nodes));
//			}
//		}
		
		//출력
	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("[");
	        for (int i = 0; i <= SIZE; i++) {
	            sb.append(nodes[i]);
	            if (i < SIZE) {
	                sb.append(", ");
	            }
	        }
	        sb.append("]");
	        return sb.toString();
	    }
	    
		void preOrder(int i) {
			if(nodes[i]!=null) System.out.print(nodes[i]);
			if(i*2<=lastIndex)preOrder(i*2); //왼쪽 자식 노드
			if(i*2+1<=lastIndex)preOrder(i*2+1); //오른족 자식 노드
		}
		void inOrder(int i) { 
			if(i*2<=lastIndex)inOrder(i*2); //왼쪽 자식 노드
			if(nodes[i]!=null) System.out.print(nodes[i]);
			if(i*2+1<=lastIndex)inOrder(i*2+1); //오른족 자식 노드
		}
		void postOrder(int i) { 
			if(i*2<=lastIndex)postOrder(i*2); //왼쪽 자식 노드
			if(i*2+1<=lastIndex)postOrder(i*2+1); //오른족 자식 노드
			if(nodes[i]!=null) System.out.print(nodes[i]);
		}
	}
	
	public static void main(String[] args) throws Exception{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			CompleteBinaryTree<Character> tree = new CompleteBinaryTree<>(N);
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char p = st.nextToken().charAt(0);
				char l = st.nextToken().charAt(0);
				char r = st.nextToken().charAt(0);
				
				tree.add(p, l, r);
				
			}
//			System.out.println(tree);
			tree.preOrder(1);
			System.out.println();
			tree.inOrder(1);
			System.out.println();
			tree.postOrder(1);
			
			br.close();
	}
	
}
