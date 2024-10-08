package baekjoon;
import java.io.*;
import java.util.*;

public class Main_13458 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] test = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			test[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long sum = 0;
		for(int t : test) {
			sum +=1;
			t-=B;
			if(t>0) {
				sum+=(t/C);
				if(t%C!=0) {
					sum+=1;
				}
			}
		}
		System.out.print(sum);
		br.close();
	}
}

