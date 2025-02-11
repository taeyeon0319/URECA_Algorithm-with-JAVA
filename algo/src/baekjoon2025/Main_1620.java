package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1620 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> nameToNumber = new HashMap<>();
		HashMap<Integer, String> numberToName = new HashMap<>();

		for(int tc=1;tc<=N;tc++) {
			String name = br.readLine();
			nameToNumber.put(name, tc);
			numberToName.put(tc, name);
		}
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0;tc<M;tc++) {
			String q = br.readLine();
			if(Character.isDigit(q.charAt(0))) {
				sb.append(numberToName.get(Integer.parseInt(q))).append("\n");
			}else {
				sb.append(nameToNumber.get(q)).append("\n");
			}
		}
		System.out.println(sb);
		
		br.close();
	}
}
