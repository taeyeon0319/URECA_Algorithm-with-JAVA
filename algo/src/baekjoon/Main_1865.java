package baekjoon;
import java.io.*;
import java.util.*;

public class Main_1865 {
	static int N, M, W;
	static int[] dist;
	static ArrayList<ArrayList<Road>> a;
	static final int INF = 987654321;
	
	public class Road{
		int end;
		int weight;
		
		Road(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
	}
	//벨만포드 알고리즘
	public static boolean bellmanFord(int start) {
		Arrays.fill(dist,  INF);
		dist[start] = 0;
		boolean update = false;
		
		for(int i=1;i<N;i++) {
			update=false;
			
			for(int j=1;j<=N;j++) {
				for(Road road:a.get(j)) {
					if(dist[j]!=INF && dist[road.end]>dist[j])
				}
//				https://steady-coding.tistory.com/91
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=0;tc<TC;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //지점의 수
			int M = Integer.parseInt(st.nextToken()); //도로의 수
			int W = Integer.parseInt(st.nextToken()); //웜홀의 수
			
			dist = new int[N+1];
			a = new ArrayList<>();
			for(int i=0;i<=N;i++) {
				a.add(new ArrayList<>());
			}
			
			//도로의 정보 + 웜홀의 정보
			for(int i=0;i<M+W;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end =Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				if(i<M) {
					a.get(start).add(new Road(end, weight));
					a.get(end).add(new Road(start, weight));
				}else {
					a.get(start).add(new Road(end, -weight));
				}

			}
			
			boolean isMinusCycle = false;
			for(int i=1;i<=N;i++) {
				if(bellmanFord(i)) { //만약 
					isMinusCycle = true;
					System.out.println("YES\n");
					break;
				}
			}
			
			if(!isMinusCycle) {
				System.out.println("NO\n");
			}
			
		}
		br.close();
	}

}

