package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1931 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] meeting = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
		});
		
		int answer = 0;
		int e=0;
		for(int i=0;i<N;i++) {
			int start = meeting[i][0];
			int end = meeting[i][1];
			if(start>=e) {
				answer+=1;
				e=end;
			}
		}
		System.out.println(answer);
		br.close();
	}
}
