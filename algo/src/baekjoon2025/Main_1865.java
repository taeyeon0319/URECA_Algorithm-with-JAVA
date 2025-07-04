package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1865 {
	static int N, M, W;
	static int[] dist;
	static List<int[]>[] doro;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int t=0;t<TC;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //지점의 수
			M = Integer.parseInt(st.nextToken()); //도로의 수
			W = Integer.parseInt(st.nextToken()); //웜홀의 수
			
			doro = new List[N+1];
			for(int i=0;i<=N;i++) {
				doro[i] = new ArrayList<>();
			}
			
			//도로 정보(양방향)
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken()); //지점
				int E = Integer.parseInt(st.nextToken()); //지점
				int T = Integer.parseInt(st.nextToken()); //시간
				doro[S].add(new int[] {E, T});
				doro[E].add(new int[] {S, T});
			}
			
			//웜홀 정보(단방향)
			for(int i=0;i<W;i++) {
				st = new StringTokenizer(br.readLine());
				int SS = Integer.parseInt(st.nextToken()); //시작지점
				int EE = Integer.parseInt(st.nextToken()); //도착지점
				int TT = Integer.parseInt(st.nextToken()); //줄어드는 시간
				doro[SS].add(new int[] {EE, TT*(-1)});
			}
			
			dist = new int[N+1];
			
			boolean isMinusCycle = false; //음수사이클인지 확인!
			
			
			for(int i=1;i<=N;i++) {
				if(bellmanFord(i)) {
					isMinusCycle = true;
					System.out.println("YES");
					break;
				}
			}
			
			if(!isMinusCycle) {
				System.out.println("NO");
			}
			
		}
		

		br.close();
	}

	private static boolean bellmanFord(int start) {
		Arrays.fill(dist, INF);
		dist[start] = 0;
		boolean update = false;
		
		for(int i=1;i<=N;i++) {
			update=false;
			for(int j=1;j<=N;j++) {
				for(int[] g : doro[j]) {
					if(dist[j]!=INF && dist[g[0]]>g[1] + dist[j]) {
						dist[g[0]] = g[1]+dist[j];
						update = true;
					}
				}
			}
			if(!update) {
				break;
			}
		}
		
		if(update) {
			for(int j=1;j<=N;j++) {
				for(int[] g : doro[j]) {
					if(dist[j]!=INF && dist[g[0]]>g[1] + dist[j]) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
