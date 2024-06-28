package a0627.greedy;

import java.io.*;
import java.util.*;

public class Main_bj_1715_카드정렬하기_김태연 {
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) pq.offer(Integer.parseInt(br.readLine())); 
		
		result = 0;
		//가장 작은 두개를 합치면 된다. 
		//가장 최근에 합친 카드 묶음도 선택 후보에 포함시켜야함.
		//항상 가장 작은 두 묶음을 고르기 위해 최소 힙 PriorityQueue활용
		while(pq.size()>1) {
			int temp1 = pq.poll();
			int temp2 = pq.poll();
			
			result+= temp1+temp2;
			pq.offer(temp1+temp2);
		}
		
		
		System.out.println(result);

	}

}
