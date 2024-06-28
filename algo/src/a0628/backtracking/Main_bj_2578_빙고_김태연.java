package a0628.backtracking;

import java.io.*;
import java.util.*;

public class Main_bj_2578_빙고_김태연 {
	static int[][] bingo_my = new int[5][5]; //내 빙고판
	static int[][] bingo_mc = new int[5][5]; //사회자가 부르는 수
	static int bingocnt = 0;
	static int result = 0;

	
	static void checkbingo(int x, int y) {
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		int c4 = 0;
		
		for(int i=0;i<5;i++) {
			if (bingo_my[i][y]==0) c1+=1;
		}
		
		for(int i=0;i<5;i++) {
			if (bingo_my[x][i]==0) c2+=1;
		}
		if(x==y) {
		    for (int i = 0; i < 5; i++) {
		        if (bingo_my[i][i] == 0) c3++;
		    }
		}

		if(x+y==4) {
		    for (int i = 0; i < 5; i++) {
		        if (bingo_my[i][4 - i] == 0) c4++;
		    }
		}
	    // Count bingos
	    if (c1 == 5) bingocnt++; 
	    if (c2 == 5) bingocnt++;
	    if (c3 == 5) bingocnt++;
	    if (c4 == 5) bingocnt++;
		
		if (bingocnt>=3) System.out.println(result); return;
	}
	
	static void bingo(int row, int col) {
		if(bingocnt>=3) System.exit(0);;
		
		if(col==5) {
			bingo(row+1, 0);
		}
		if(row==5) {
			return;
		}
		
		int value =  bingo_mc[row][col];
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if (bingo_my[i][j]==value) {
					bingo_my[i][j]=0;
					result+=1;
					checkbingo(i, j);
					break;
				}
			}
		}
		bingo(row, col+1);
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				bingo_my[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				bingo_mc[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bingo(0, 0);

	}

}
