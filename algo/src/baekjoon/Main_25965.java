package baekjoon;
import java.io.*;
import java.util.*;

public class Main_25965 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int M = Integer.parseInt(br.readLine());
			long[][] mission = new long[M][3];
			for(int j=0;j<M;j++) {
				st = new StringTokenizer(br.readLine());
				mission[j][0] = Long.parseLong(st.nextToken());
				mission[j][1] = Long.parseLong(st.nextToken());
				mission[j][2] = Long.parseLong(st.nextToken());
				
			}
			st = new StringTokenizer(br.readLine());
			long k = Long.parseLong(st.nextToken());
			long d = Long.parseLong(st.nextToken());
			long a = Long.parseLong(st.nextToken());
			
			
			long result = 0;
			for(int j=0;j<M;j++) {
				long num = mission[j][0]*k - mission[j][1]*d + mission[j][2]*a;
				if(num>0) {
					result+=num;
				}
			}
			System.out.println(result);
		}
		br.close();
	}
}

