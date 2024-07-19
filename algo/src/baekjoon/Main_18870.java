package baekjoon;
import java.io.*;
import java.util.*;

public class Main_18870 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); //시간초과해결
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] xgraph = new int[N]; 
		int[] sortgraph = new int[N];
		
		HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();
		
		for(int i=0;i<N;i++) {
			sortgraph[i] = xgraph[i] = Integer.parseInt(st.nextToken());
			
		}
		Arrays.sort(sortgraph);
		
		int rank = 0;
		for(int v : sortgraph) {
			if(!rankingMap.containsKey(v)) {
				rankingMap.put(v, rank);
				rank++;
			}
		}
		
		for(int x : xgraph) {
			sb.append(rankingMap.get(x)).append(" ");//시간초과해결
		}
		System.out.println(sb);//시간초과해결
		br.close();
	}

}

