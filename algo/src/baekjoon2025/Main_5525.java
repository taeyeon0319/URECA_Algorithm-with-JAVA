package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_5525 {

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] s = br.readLine().toCharArray();
		
		int result = 0;
		int count = 0; //IOI개수세기
		
		for(int i=1;i<M-1;i++) {
			if(s[i-1]=='I'&&s[i]=='O'&&s[i+1]=='I') {
				count+=1;
				if(count==N) {
					result+=1;
					count--;
				}
				i++; //다음 I로 넘어가기 위해서 
			}else {
				count=0;
			}
		}
		System.out.println(result);
		br.close();
	}
}
