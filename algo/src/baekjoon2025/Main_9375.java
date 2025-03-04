package baekjoon2025;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main_9375 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> clothes = new HashMap<String, Integer>();
			for(int j=0;j<n;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				Integer c = clothes.get(b);
				clothes.put(b, c==null? 1:c+1);
			}

			Set<Entry<String, Integer>> set = clothes.entrySet();
			int result = 1;
			for(Entry<String, Integer> s : set) {
				result *= (s.getValue()+1);
			}
			System.out.println(result-1);
			
		}
		br.close();
	}
}
