package a0624.stackqueue;

import java.io.*;
import java.util.*;

public class Main_bj_10773_제로_김태연 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> s = new ArrayDeque<>(); 
		for(int i=0;i<K;i++) {
			int n = Integer.parseInt(br.readLine());
			if (n==0) {
				s.pop();
			}else {
				s.push(n);
			}
		}
		int result = 0;
		while(!s.isEmpty()) {
			result+=s.pop();
		}
		System.out.println(result);

	}

}
