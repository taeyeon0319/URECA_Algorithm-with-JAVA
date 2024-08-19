package baekjoon;
import java.io.*;
import java.util.*;

public class Main_1865 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=0;tc<TC;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //지점의 수
			int M = Integer.parseInt(st.nextToken()); //도로의 수
			int W = Integer.parseInt(st.nextToken()); //웜홀의 수
			
			//도로의 정보
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int MS = Integer.parseInt(st.nextToken()); //지점 번호1
				int ME = Integer.parseInt(st.nextToken()); //지점 번호 2
				int MT = Integer.parseInt(st.nextToken()); //이동 시간
			}
			
			//웜홀의 정보
			for(int i=0;i<W;i++) {
				st = new StringTokenizer(br.readLine());
				int WS = Integer.parseInt(st.nextToken()); //시작 지점
				int WE = Integer.parseInt(st.nextToken()); //도착 지점
				int WT = Integer.parseInt(st.nextToken()); //줄어드는 시간
			}
		}
	}

}

