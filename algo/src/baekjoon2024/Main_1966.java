package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_1966 {
	static int N, M;
	static LinkedList<int[]> importance;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			importance = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				importance.add(new int[] {j, Integer.parseInt(st.nextToken())}); //index, 값
			}
			int count = 0;
			
			while(!importance.isEmpty()) {
				int[] first = importance.poll();
				boolean check = true;
				for(int j=0;j<importance.size();j++) {
					if(first[1]<importance.get(j)[1]) {
						check=false;
						importance.offer(first);
						for(int k=0;k<j;k++) {
							importance.offer(importance.poll());
						}
						break;
					}
				}
				
				if(!check) {
					continue;
				}
				count++;
				if(first[0]==M) {
					break;
				}
			}
			System.out.println(count);
		}
	}
}

