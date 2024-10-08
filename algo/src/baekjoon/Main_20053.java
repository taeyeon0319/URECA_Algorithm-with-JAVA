package baekjoon;
import java.io.*;
import java.util.*;

public class Main_20053 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int max = num;
			int min = num;
			for(int i=1;i<N;i++) {
				num = Integer.parseInt(st.nextToken());
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
			System.out.println(min+" "+max);
		}
		br.close();
	}
}

