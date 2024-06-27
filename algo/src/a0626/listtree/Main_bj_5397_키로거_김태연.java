package a0626.listtree;
/*stack을 이용하는 방법 & ListIterator인터페이스 활용*/
import java.io.*;
import java.util.*;

public class Main_bj_5397_키로거_김태연 {
	static class Node{
		char value;
		Node left;
		Node right;
		Node(char value, Node left, Node right){
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		
		for(int i=0;i<T;i++) {
			Node current;
			Node root = new Node(' ', null, null); //더미노드 생성
			current = root;
			Node temp = root.right;
			
			String password = br.readLine();
			for(int j=0;j<password.length();j++) {
				char c = password.charAt(j);
				if (c=='<') { // 왼쪽으로 커서 이동
					if (current.left==null) continue;
					current = current.left;
					
				}else if(c=='>') { //오른쪽으로 커서 이동
					if(current.right==null) continue;
					current = current.right;
				}else if(c=='-') { //커서 앞 글자가 존재한다면 삭제
					if(current.left==null) continue;
					else if(current.right==null) {
						current = current.left;
						current.right=null;
					}
					else {
						current.left.right = current.right;
						current.right.left = current.left;
						current = current.left;
					}
					
				}else { //이외 알파벳
					Node newNode = new Node(c, current, current.right);
					if(current.right!=null) {
						current.right.left=newNode;
					}
					current.right = newNode;
					current = newNode;
				}
			}
			StringBuilder sb = new StringBuilder();
			temp = root.right;
			while(temp!=null) {
				sb.append(temp.value);
				temp=temp.right;
			}
			System.out.println(sb);
		}

	}

}
