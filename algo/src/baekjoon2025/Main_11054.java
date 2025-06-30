package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_11054 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Integer[] num = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Integer[] GoingUp = new Integer[N];
		Integer[] GoingDown = new Integer[N];
		
		GoingUp[0] = 1;
		for(int i=1;i<N;i++) {
			int max = 0;
			for(int j=0;j<i;j++) {
				if(num[i]>num[j]) {
					max = Math.max(max, GoingUp[j]);
				}
			}
			GoingUp[i] = max+1;
		}
		
		GoingDown[N-1] = 1;
		for(int i=N-2;i>=0;i--) {
			int max = 0;
			for(int j=i+1;j<N;j++) {
				if(num[i]>num[j]) {
					max = Math.max(max, GoingDown[j]);
				}
			}
			GoingDown[i] = max+1;
		}
		
		int result = 0;
		for(int i=0;i<N;i++) {
			result = Math.max(result, GoingUp[i]+GoingDown[i]);
		}

		System.out.println(result-1);
		br.close();
	}
}
