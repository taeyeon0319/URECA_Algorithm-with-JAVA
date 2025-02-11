package baekjon2025;

import java.io.*;
import java.util.*;

public class Main_1764 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> listen = new HashSet<>();
		for(int i=0;i<N;i++) {
			listen.add(br.readLine());
		}
		
		TreeSet<String> answer = new TreeSet<>();
		for(int j=0;j<M;j++) {
			String see = br.readLine();
			if(listen.contains(see)) {
				answer.add(see);
			}
		}
		System.out.println(answer.size());
		for(String a : answer) {
			System.out.println(a);
		}
		
		br.close();
	}
}
