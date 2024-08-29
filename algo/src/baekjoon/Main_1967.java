package baekjoon;
import java.io.*;
import java.util.*;

public class Main_1967 {
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		List<Integer>[] graph = new List[N+1];
		for(int i=0;i<=N;i++) graph[i] = new ArrayList<>();
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int aNode = Integer.parseInt(st.nextToken());
			int bNode = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			graph[aNode].add(bNode);
			graph[bNode].add(aNode);
		}
		
	}

}

