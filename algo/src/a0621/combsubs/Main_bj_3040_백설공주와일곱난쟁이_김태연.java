package a0621.combsubs;

import java.io.*;
import java.util.*;

public class Main_bj_3040_백설공주와일곱난쟁이_김태연 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static int N;
	static int M;
	
	static int[] hat; 
	static int[] b; 
	
	static int sum;
	//static boolean found;
	static void comb(int cnt, int start) {
		sum=0;
		if(cnt==M) {
			sb = new StringBuilder();//새로운 출력
			for(int i=0;i<M;i++) {
				sum += b[i];
				sb.append(b[i]).append("\n");
			}
			if (sum==100) {
				System.out.println(sb.toString());
				System.exit(0);
				//found = true;
			}
			return;
		}
		for(int i=start;i<N;i++) {
			b[cnt]=hat[i];
			comb(cnt+1, i+1);
			//if(found) return;
		}
	}
	
	public static void main(String[] args) throws Exception {
		N = 9; //모자 개수
		M = 7; //일곱난쟁이
		
		hat = new int[N];
		for(int i=0;i<N;i++) {
			hat[i]=Integer.parseInt(br.readLine());
		}
		

		b = new int[M];

        comb(0, 0);
        br.close();  
	}

}
