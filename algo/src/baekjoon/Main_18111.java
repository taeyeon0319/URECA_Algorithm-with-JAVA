package baekjoon;
import java.io.*;
import java.util.*;

public class Main_18111 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
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

