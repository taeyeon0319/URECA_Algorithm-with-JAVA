package baekjoon;

import java.io.*;
import java.util.*;

public class Main_10708 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //친구들의 수
		int M = Integer.parseInt(br.readLine()); //게임의 횟수
		int[] A = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) { A[i] = Integer.parseInt(st.nextToken()); }
		
		ArrayList<int[]> game = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			int[] g = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				g[j] = Integer.parseInt(st.nextToken());
			}
			game.add(g);
		}
		
		int[] result = new int[N];
		for(int gamecnt =0;gamecnt<M;gamecnt++) {
			int n = A[gamecnt];
			int[] ga = game.get(gamecnt);
			int notcollect = 0;
			for(int i=0;i<N;i++) {
				if(ga[i]==n) {
					result[i]+=1;
				}else {
					notcollect+=1;
				}
			}
			result[n-1]+=notcollect;
		}
		
		for(int i=0;i<N;i++) {
			System.out.println(result[i]);
		}
		
		br.close();
	}

}
