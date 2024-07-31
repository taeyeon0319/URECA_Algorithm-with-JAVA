package baekjoon;
import java.io.*;
import java.util.*;

public class Main_7662 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for(int j=0;j<k;j++) {
				st = new StringTokenizer(br.readLine());
				String word = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if(word.equals("I")) {
					map.put(num, map.getOrDefault(num, 0)+1);
				}else {
					if(map.size()==0) {
						continue;
					}
					int outnum = num==1?map.lastKey() : map.firstKey();
					
					if(map.put(outnum, map.get(outnum)-1)==1) {
						map.remove(outnum);
					}
				}
			}
			System.out.println(map.size()==0?"EMPTY":map.lastKey()+" "+map.firstKey());
			
		}
		
	}

}

