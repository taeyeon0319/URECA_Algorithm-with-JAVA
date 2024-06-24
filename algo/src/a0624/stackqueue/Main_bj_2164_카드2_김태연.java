package a0624.stackqueue;

import java.io.*;
import java.util.*;

public class Main_bj_2164_카드2_김태연 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayDeque<Integer> q = new ArrayDeque<>(); 
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		
		while(q.size()>1) {
			q.poll();
			q.offer(q.poll());
		}
		System.out.println(q.poll());
	}

}
