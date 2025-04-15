package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_11286 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->{
			if(Math.abs(o1)==Math.abs(o2)) {
				return o1-o2;
			}
			return Math.abs(o1)-Math.abs(o2);
		});
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x!=0) {
				pq.add(x);
			}else {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				}else {
					sb.append(pq.poll()).append("\n");
					
				}
			}
		}
		System.out.println(sb);
		br.close();
	}
}
