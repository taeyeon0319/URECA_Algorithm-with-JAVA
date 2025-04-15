package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_6064 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<T;tc++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			boolean check = false;
			for(int i=x;i<(N*M);i+=M) {
				if(i%N==y) {
					System.out.println(i+1);
					check=true;
					break;
				}
			}
			if(!check) {
				System.out.println(-1);
			}
		}

		br.close();
	}
}
