package baekjoon;
import java.io.*;
import java.util.*;

public class Main_3034 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int max = (int)Math.pow(W, 2)+(int)Math.pow(H,  2);

		for(int i=0;i<N;i++) {
			int l = Integer.parseInt(br.readLine());
			if(max>=(int)Math.pow(l, 2)) {
				System.out.println("DA");
			}else {
				System.out.println("NE");
			}
		}
	}

}