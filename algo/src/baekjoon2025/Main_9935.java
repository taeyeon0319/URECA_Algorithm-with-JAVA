package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_9935 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String check = br.readLine();
		
		List<Character> result = new ArrayList<>();

		for(int i=0;i<s.length();i++) {
			result.add(s.charAt(i));
			
			if(result.size() >= check.length()) {
				boolean ok = true;
				for(int j=0;j<check.length();j++) {
					if(result.get(result.size() - check.length() +j)!=check.charAt(j)) {
						ok = false;
						break;
					}
				}
				if(ok) {
					for(int j=0;j<check.length();j++) {
						result.remove(result.size()-1);
					}
				}
			}
		}
		if(result.isEmpty()) {
			System.out.println("FRULA");
		}else {
			StringBuilder sb = new StringBuilder();
			for(Character c : result) {
				sb.append(c);
			}
			System.out.println(sb);
		}
		br.close();
	}
}
