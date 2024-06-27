package a0627.greedy;

import java.io.*;
import java.util.*;

public class Main_bj_13305_주유소_김태연 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		long[] road = new long[N-1];
		long[] price = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N-1;i++) road[i] = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) price[i] = Long.parseLong(st.nextToken());
		
		long result = 0;
		long minPrice = price[0];
		for(int i=0;i<N-1;i++) {
			if(price[i]<minPrice) {
				minPrice = price[i];
			}
			result+=minPrice*road[i];
		}

		System.out.println(result);
	}

}
