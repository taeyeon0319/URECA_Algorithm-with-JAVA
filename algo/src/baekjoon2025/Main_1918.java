package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1918 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		ArrayDeque<Character> sign = new ArrayDeque<>();
		List<Character> answer = new ArrayList<>();
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			
			//c가 알파벳이면
			if(c>='A' && c<='Z') {
				answer.add(c);;
			}else {
				if(c=='(') {
					sign.push(c);
				}else if(c==')') {
					while(sign.peek() != '(') {
						answer.add(sign.pop());
					}
					sign.pop();
				}else {
					while(!sign.isEmpty() && check(sign.peek())>=check(c)) {
						answer.add(sign.pop());
					}
					sign.push(c);
				}
			}
		}
		while(!sign.isEmpty()) {
			answer.add(sign.pop());
		}
		
		
		for(char ch : answer) {
			System.out.print(ch);
		}
		br.close();
	}
	
	public static int check(char op) {
		if(op=='*' || op=='/') return 2;
		if(op=='+' || op=='-') return 1;
		return -1;
	}
}