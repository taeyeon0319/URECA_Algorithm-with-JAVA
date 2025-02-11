package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1074 {
	static int cnt = 0;
	public static void zprogram(int n, int x, int y) {
		if(n==1) return;
		if(x<n/2 && y<n/2) { //2사분면
			zprogram(n/2, x, y);
		}else if(x<n/2 && y>=n/2) { //1사분면
			cnt += (n*n)/4;
			zprogram(n/2, x, y-n/2);
		}else if(x>=n/2 && y<n/2) { //3사분면
			cnt += (n*n)/4*2;
			zprogram(n/2, x-n/2, y);
		}else { //4사분면
			cnt += (n*n)/4*3;
			zprogram(n/2, x-n/2, y-n/2);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		zprogram((int)Math.pow(2, N), r, c);
		System.out.println(cnt);
		
		br.close();
	}
}
