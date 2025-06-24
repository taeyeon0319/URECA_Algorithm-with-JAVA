package baekjoon2025;

import java.io.*;
import java.util.*;

//2차원 배열을 1차원 배열로 받는다.
public class Main_9663 {
	static int N;
	static int[] location;
	static int result = 0;
	
	public static void nQueen(int index) {
		if(index==N) {
			result+=1;
			return;
		}
		for(int i=0;i<N;i++) {
			location[index] = i;
			if(possible(index)) {
				nQueen(index+1);
			}
		}
	}
	public static boolean possible(int num) {
		for(int i=0;i<num;i++) {
			if(location[num]==location[i]) {
				return false;
			}else if(Math.abs(i-num)==Math.abs(location[num]-location[i])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		location = new int[N];
		nQueen(0);
		System.out.println(result);
		br.close();
	}
}
