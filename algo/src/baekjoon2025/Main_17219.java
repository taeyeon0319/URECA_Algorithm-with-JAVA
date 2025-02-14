package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_17219 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> pass = new HashMap<String, String>(); 
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String password = st.nextToken();
			pass.put(site, password);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			String find = br.readLine();
			sb.append(pass.get(find)+"\n");
		}
	
		System.out.println(sb);
		br.close();
	}
}
