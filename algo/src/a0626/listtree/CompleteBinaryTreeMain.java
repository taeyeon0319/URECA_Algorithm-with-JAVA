package a0626.listtree;

import java.io.*;
import java.util.*;

public class CompleteBinaryTreeMain {
	static class CompleteBinaryTree<T>{
		final int SIZE;
		Object[] nodes;
		int lastIndex;
		
		CompleteBinaryTree(int size) {
			SIZE = size;
			nodes = new Object[size+1]; //0인덱스 미사용 - 1번인덱스가 root노드임
			
		}
		
	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("[");
	        for (int i = 0; i < SIZE; i++) {
	            sb.append(nodes[i]);
	            if (i < SIZE - 1) {
	                sb.append(", ");
	            }
	        }
	        sb.append("]");
	        return sb.toString();
	    }
	    
		void add(T t) {
			if(lastIndex==SIZE) {
				System.out.println("포화상태!");
				return;
			}
			nodes[++lastIndex]=t;
			System.out.println(Arrays.toString(nodes));
		}

		void bfs(int i) {
			ArrayDeque<Integer> q = new ArrayDeque<>();
			q.offer(i);
			while(!q.isEmpty()) {
				i = q.poll();
				System.out.print(nodes[i]+" ");
				if(i*2<=lastIndex)q.offer(i*2); //왼쪽 자식 노드
				if(i*2+1<=lastIndex)q.offer(i*2+1); //오른족 자식 노드
			}
		}
		/*전위순회*/
		void preOrder(int i) { 
			System.out.print(nodes[i]+" ");
			if(i*2<=lastIndex)preOrder(i*2); //왼쪽 자식 노드
			if(i*2+1<=lastIndex)preOrder(i*2+1); //오른족 자식 노드
		}
		
		/*중위순회*/
		void inOrder(int i) { 
			if(i*2<=lastIndex)inOrder(i*2); //왼쪽 자식 노드
			System.out.print(nodes[i]+" ");
			if(i*2+1<=lastIndex)inOrder(i*2+1); //오른족 자식 노드
		}
		
		/*후위순회*/
		void postOrder(int i) { 
			if(i*2<=lastIndex)postOrder(i*2); //왼쪽 자식 노드
			if(i*2+1<=lastIndex)postOrder(i*2+1); //오른족 자식 노드
			System.out.print(nodes[i]+" ");
		}
		
	}
	public static void main(String[] args) {
		int size = 12;
		CompleteBinaryTree<Character> tree = new CompleteBinaryTree<>(size);
		for(int i='A';i<'A'+size;i++) tree.add((char)i);
		
		System.out.println(tree);
		tree.bfs(1);
		System.out.println();
		tree.preOrder(1);
		System.out.println();
		tree.inOrder(1);
		System.out.println();
		tree.postOrder(1);
		

	}

}
