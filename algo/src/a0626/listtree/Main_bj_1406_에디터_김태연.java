package a0626.listtree;

import java.io.*;
import java.util.*;

public class Main_bj_1406_에디터_김태연 {
	static class Node{
		char value;
		Node left; //이전 노드
		Node right; //다음 노드
		
		Node(char value, Node left, Node right){
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String word = st.nextToken(); //초기 문자열을 입력받음
		
		Node current;
		Node root = new Node(' ', null, null); // 루트 노드 생성(더미노드)
		current = root;
		
		//초기 문자열을 이중 연결 리스트에 저장
		for(int i=0;i<word.length();i++) {
			current.right = new Node(word.charAt(i), current, null);// 더미 - a - b - c - d으로 저장
			current = current.right; 
		}
		
		Node temp = root.right; //더미 노드를 제외한 첫번째 실제 노드를 가리키는 포인터 설정
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); //명령어의 개수
		
		/*명령어 수행*/
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			char operation = st.nextToken().charAt(0); //명령어를 char로 변환
			
			if (operation=='L') {
				if(current.left==null) continue; //커서가 맨 왼쪽에 있으면 무시
				current = current.left; //커서를 왼쪽으로 이동
			}else if (operation=='D') {
				if(current.right==null) continue; //커서가 맨 오른쪽에 있으면 무시
				current = current.right; //커서를 오른쪽으로 이동
			}else if (operation=='B') {
				if(current.left==null) continue; //커서가 맨 왼쪽에 있으면 무시- 삭제할 게 없음
				else if(current.right==null) {
					current=current.left; //커서를 왼쪽으로 이동 후
					current.right=null; //오른쪽 삭제
				}
				else {
					current.left.right = current.right; //이전 노드와 다음 노드를 연결하여 현재 노드를 삭제
					current.right.left = current.left; //다음 노드와 이전 노드를 연결하여 현재 노드를 삭제
					current=current.left; //커서를 이전 노드로 설정
				}
			}else if (operation=='P') {
				char newWord = st.nextToken().charAt(0); //추가할 문자 입력
				Node newNode = new Node(newWord, null, null); //새로운 노드 생성
				if(current.left==null) {
					//맨 왼쪽에 삽입
					newNode.left =current;
					newNode.right = current.right;
					
					current.right.left = newNode;
					current.right = newNode;
					
					current = newNode; // 커서를 새로 삽입된 노드로 설정
				}
				else if(current.right==null) {
					//맨 오른쪽에 삽입
					newNode.left = current;
					newNode.right = current.right;
					current.right = newNode;
					current = newNode;
				}
				else {
					//중간에 삽입
					newNode.left =current;
					newNode.right = current.right;
					
					current.right.left = newNode;
					current.right = newNode;
				
					current=newNode;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		temp = root.right;
		while(temp!=null) {
//			System.out.println(temp.value);
			sb.append(temp.value);
			temp=temp.right;
		}
		System.out.println(sb);
		br.close();
	}
}


/*
 * 시간초과...
 public class Main_bj_1406_에디터_김태연 {
	static ArrayList<String> words;

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		words = new ArrayList<>();
		String w = br.readLine();
		
		for(int i=0;i<w.length();i++) {
			words.add(String.valueOf(w.charAt(i)));
		}
		
		int M = Integer.parseInt(br.readLine());
		int cursor = words.size();
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			String c = "";
		
			if (order.equals("L")) {
				if (cursor==0) continue;
				cursor-=1;
			}else if (order.equals("D")) {
				if (cursor==words.size()) continue;
				cursor+=1;
			}else if (order.equals("B")) {
				if (cursor==0) continue;
				words.remove(cursor-1);
				cursor-=1;
			}else if (order.equals("P")) {
				c = st.nextToken();
				words.add(cursor, c);
				cursor+=1;
			}
		}
		for(String result:words) System.out.print(result);
		br.close();
	}
}

 */