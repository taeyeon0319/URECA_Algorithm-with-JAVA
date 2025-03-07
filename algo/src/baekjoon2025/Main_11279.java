package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_11279 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for(int i=0;i<N;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x>0) {
				pq.add(x);
			}else if(x==0) {
				if(!pq.isEmpty()) {
					System.out.println(pq.poll());
				}else {
					System.out.println(0);
				}
			}
		}
		br.close();
	}
}
