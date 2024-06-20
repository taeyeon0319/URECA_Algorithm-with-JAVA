package a0619.recu;

import java.io.*;
import java.util.*;

public class Main_bj_11729_하노이탑이동순서_김태연 {
	private static StringBuilder sb = new StringBuilder();
	private static void hanoi(int n, int from, int mid, int to) {
		if(n==0) return;
		hanoi(n-1, from, to, mid);
		sb.append(from).append(" ").append(to).append("\n");
		hanoi(n-1, mid, from, to);
	}
	
	public static void main(String[] args) throws Exception {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//원판의 개수
        int N = Integer.parseInt(br.readLine());
        br.close();
        
        hanoi(N, 1, 2, 3);
        System.out.println((int)(Math.pow(2,  N)-1)); //pow : 거듭제곱
        // 출력 
        System.out.println(sb.toString());
        br.close();  
	}
}
