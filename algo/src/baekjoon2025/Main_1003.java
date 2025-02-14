package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1003 {
	static int cntone;
	static int cntzero;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			int[] fibo_one = new int[N+1];
			int[] fibo_zero = new int[N+1];
			if(N>=0) {
				fibo_zero[0] = 1;
				fibo_one[0] = 0;
			}
			if(N>=1) {
				fibo_zero[1] = 0;
				fibo_one[1] = 1;
			}
			for(int j=2;j<=N;j++) {
				fibo_zero[j] = fibo_zero[j-1]+fibo_zero[j-2];
				fibo_one[j] = fibo_one[j-1]+fibo_one[j-2];
			}
		
			System.out.println(fibo_zero[N]+" "+fibo_one[N]);
		}
		br.close();
	}
}
/* 재귀함수 - 시간초과
public class Main_1003 {
	static int cntone;
	static int cntzero;
	public static int fibonacci(int num) {
		if(num==1) {
			cntone+=1;
			return 1;
		}else if(num==0) {
			cntzero+=1;
			return 0;
		}
		return fibonacci(num-1)+fibonacci(num-2);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			cntone = 0;
			cntzero = 0;
			fibonacci(N);
			System.out.println(cntzero+" "+cntone);
		}
		br.close();
	}
}
*/