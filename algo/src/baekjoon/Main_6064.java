package baekjoon;
import java.io.*;
import java.util.*;

public class Main_6064 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			boolean check = false;
			
			for(int j=x;j<(N*M);j+=M) {
				if((j%N)==y) {
					System.out.println(j+1);
					check=true;
					break;
				}
			}
			if(!check) System.out.println(-1);
			
			
		}
	}

}
/*https://1-7171771.tistory.com/38*/

