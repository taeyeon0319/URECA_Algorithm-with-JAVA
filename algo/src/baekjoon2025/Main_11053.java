package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_11053 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] result = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(result, 1);
		int max = 1;
		for(int i=1;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(num[j]<num[i]) {
					result[i] = Math.max(result[i], result[j]+1);
					max = Math.max(max, result[i]);
				}
			}
		}
		System.out.println(max);
		br.close();

	}
}
