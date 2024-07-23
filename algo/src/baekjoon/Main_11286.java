package baekjoon;
import java.io.*;
import java.util.*;

public class Main_11286 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
			if(Math.abs(o1)==Math.abs(o2)) {
				return o1-o2;
			}
			return Math.abs(o1)-Math.abs(o2);
		});

		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				if(!q.isEmpty()) {
					System.out.println(q.poll());
				}else {
					System.out.println(0);
				}
				
			}else {
				q.add(num);
			}
		}
		
	}

}

