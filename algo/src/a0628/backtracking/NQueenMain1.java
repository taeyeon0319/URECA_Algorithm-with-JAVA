package a0628.backtracking;

import java.io.*;
import java.util.*;

public class NQueenMain1 {
	static int N, ans, col[]; //N개의 퀸, 경우의 수 ans
	
	static boolean isAvailable(int rowNo) {
		for(int j=0;j<rowNo;j++) {
			if(col[rowNo]==col[j] || Math.abs(col[rowNo]-col[j])==rowNo-j) { //같은 세로라인에 있어도 안되고 || 대각선으로 만나도 안됨
				return false;
			}
		}
		return true;
	}
	
	static void nqueen(int rowNo) {
		if(rowNo==N) {
			ans++;
			return;
		}
		for(int i=0;i<N;i++) {
			col[rowNo] = i;
			if(isAvailable(rowNo)) nqueen(rowNo+1);			
		}
	}	
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N =4; //sc.nextInt();
		col = new int[N];
		ans = 0;
		
		nqueen(0);
		System.out.println(ans);
		
		sc.close();

	}


}
