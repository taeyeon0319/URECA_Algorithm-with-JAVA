package baekjoon;
import java.io.*;
import java.util.*;

public class Main_1918 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		ArrayDeque<Character> sign = new ArrayDeque();//연산자 저장소
		List<Character> answer = new ArrayList<>();
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			//알파벳이면
			if(c>='A' && c<='Z') {
				answer.add(c);
			}else {
				if(c=='(') {
					sign.push(c);
				}else if(c==')') {
					while(!sign.isEmpty() && sign.peek() !='(') {
						answer.add(sign.pop());
					}
					sign.pop();
				}
				
				else {
					while(!sign.isEmpty() && precedence(sign.peek()) >= precedence(c)) {
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
	
	}
	
	public static int precedence(char op) {
		if(op=='(' || op==')') return 0;
		if(op=='+' || op=='-') return 1;
		if(op=='*' || op=='/') return 2;
		return -1;
	}
}
