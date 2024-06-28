package a0628.backtracking;

import java.io.*;
import java.util.*;

public class Main_bj_2580_스도쿠_김태연 {
	static int[][] sudoku = new int[9][9];
	
	//숫자넣어도 되는지 확인
	static boolean isAvailable(int row, int col, int value) {
		for(int i=0;i<9;i++) {
			if(i!=row && sudoku[i][col]==value) return false;
		}
		for(int j=0;j<9;j++) {
			if(j!=col && sudoku[row][j]==value) return false;
		}
		
		int c = (col/3)*3;
		int r = (row/3)*3;
		
		for(int i=r;i<(r+3);i++) {
			for(int j=(c);j<(c+3);j++) {
				if(i!=row && j!=col && sudoku[i][j]==value) return false;
			}
		}
		return true;
	}
	
	//숫자 넣기
	static void fill(int row, int col) {
		if(col==9) {
			fill(row+1, 0);
			return;
		}
		if(row==9) {
			for(int[] a:sudoku) {
				for(int b:a) {
					System.out.print(b + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		if(sudoku[row][col]==0) {
			for(int i=1;i<=9;i++) {
				sudoku[row][col]=i;
//				System.out.println(isAvailable(row, col, i) +" " + row+ " " + col + ""+i);
				if(isAvailable(row, col, i)) fill(row, col+1);
				sudoku[row][col] = 0;
			}
		}else {
			fill(row, col+1);
		}
		

	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<9;j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		fill(0, 0);
		

	}

}
