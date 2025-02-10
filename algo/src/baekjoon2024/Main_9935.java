package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_9935 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine(); //입력 문자열
		String bomb = br.readLine(); //폭발 문자열
		
		Stack<Character> stack = new Stack<>();
		
		
		for(int i=0;i<s.length();i++) {
			stack.push(s.charAt(i));
			
			if(stack.size() >= bomb.length()) {
				boolean isBomb = true;
				
				for(int j=0;j<bomb.length();j++) {
					if(stack.get(stack.size() - bomb.length()+j)!=bomb.charAt(j)) {
						isBomb = false;
						break;
					}
				}
				
				if(isBomb) {
					for(int j=0;j<bomb.length();j++) {
						stack.pop();
					}
				}
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(Character st : stack) {
			sb.append(st);
		}
		if(sb.length()!=0) {
			System.out.println(sb);
		}else {
			System.out.println("FRULA");
		}
		
	}

}

