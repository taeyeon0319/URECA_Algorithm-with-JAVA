package baekjoon;
import java.io.*;
import java.util.*;

public class Main_25494 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int cnt=0;
			for(int x=1;x<=a;x++) {
				for(int y=1;y<=b;y++) {
					for(int z=1;z<=c;z++) {
						if((x%y) == (y%z) && (y%z)==(z%x)) {
							cnt+=1;
						}
					}
				}
			}
			System.out.println(cnt);
		}
		
	}

}

