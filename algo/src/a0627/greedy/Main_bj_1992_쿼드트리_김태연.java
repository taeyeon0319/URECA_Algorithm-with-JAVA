package a0627.greedy;

import java.io.*;
import java.util.*;

public class Main_bj_1992_쿼드트리_김태연 {
	static int N;
	static int[][] graph;

	static void dots(int n, int row, int col) {
		int num = graph[row][col];
		boolean check = true;
		
		for(int i=row;i<row+n;i++) {
			for(int j=col;j<col+n;j++) {
				if(graph[i][j]!=num) {
					check=false;
					break;
				}
			}
			if(!check) break;
		}
		
		if(check) {
			if (num==0) {
				System.out.print(0);
			}else {
				System.out.print(1);
			}
		}else {
			System.out.print("(");
			dots(n/2, row, col); //2사분면
			dots(n/2, row, col+n/2); //1사분면
			dots(n/2, row+n/2,col); //3사분면
			dots(n/2, row+n/2, col+n/2); //4사분면
			System.out.print(")");
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine().trim(); //trim : 앞뒤 공백 제거하기
			for(int j=0;j<N;j++) {
				graph[i][j] = line.charAt(j) - '0';
			}
		}

		dots(N, 0, 0);
	}

}
