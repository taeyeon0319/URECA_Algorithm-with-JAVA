package a0627.greedy;

import java.io.*;
import java.util.*;

public class Main_bj_1715_카드정렬하기_김태연 {
	static int[] cards;
	static int result;
	
	static int combine(int n, int s, int e) {
		if(n==1) {
			return result;
		}
		if (n==2) {
			System.out.println(cards[s]+" "+cards[e]);
			return cards[s]+cards[e];
		}
		if (n%2==0) {
			result += (combine(n/2, s, n/2-1) + combine(n/2, n/2, n-1))*2;
		}else {
			result += combine(n-1, s, n-2)*2+cards[e];
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		cards = new int[N];
		for(int i=0;i<N;i++) cards[i] = Integer.parseInt(br.readLine());
		Arrays.sort(cards);
		result = 0;
		
		combine(N, 0, N-1);
		
		System.out.println(result);

	}

}
