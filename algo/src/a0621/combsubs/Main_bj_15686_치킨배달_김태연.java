package a0621.combsubs;

import java.io.*;
import java.util.*;

public class Main_bj_15686_치킨배달_김태연 {
	static int N, M;
	static int[][] city;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
}
