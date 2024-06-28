package a0628.backtracking;

import java.io.*;
import java.util.*;

public class Main_bj_9663_NQueen_김태연 {
	static int N, ans, col[];
	
	static boolean isAvailable(int rowNo) {
		for(int j=0;j<rowNo;j++) {
			if(col[rowNo]==col[j] || Math.abs(col[rowNo]-col[j])==rowNo-j) { //같은 세로라인에 있어도 안되고 || 대각선으로 만나도 안됨
				return false;
			}
		}
		return true;
	}
	static void nqueen(int rowNo) {
		if(!isAvailable(rowNo-1)) return; 	
		if(rowNo==N) {
			ans++;
			return;
		}
		for(int i=0;i<N;i++) {
			col[rowNo] = i;
			nqueen(rowNo+1);		
		}
	}	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N];
		ans = 0;
		
		nqueen(0);
		System.out.println(ans);
		br.close();
	}

}
