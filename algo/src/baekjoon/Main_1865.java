package baekjoon;
import java.io.*;
import java.util.*;

public class Main_1865 {
	static int N, M, W;
	static int[] dist;
	static List<int[]>[] graph;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int tc=0;tc<TC;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //지점의 수
			M = Integer.parseInt(st.nextToken()); //도로의 수
			W = Integer.parseInt(st.nextToken()); //웜홀의 수
			
			dist = new int[N+1];
			graph = new List[N+1] ;
			for(int i=0;i<=N;i++) {
				graph[i] = new ArrayList<>();
			}
			
			//도로 설정
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				graph[s].add(new int[] {e, t});
				graph[e].add(new int[] {s, t});
			}
			
			//웜홀 설정
			for(int i=0;i<W;i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				graph[S].add(new int[] {E, -T});
			}
			
			boolean isMinusCycle = false;
			
			//만약 시간이 줄어들면서 출발 위치로 돌아온다면 YES!
			for(int i=1;i<=N;i++) {
				if(bellmanFord(i)) {
					isMinusCycle = true;
					System.out.println("YES");
					break;
				}
			}
			
			//아니면 NO!
			if(!isMinusCycle) {
				System.out.println("NO");
			}
		}
	}

	private static boolean bellmanFord(int start) {
		Arrays.fill(dist, INF);
		dist[start] = 0;
		boolean update = false; //한번 돌았나?
		
		for(int i=1;i<N;i++) {
			update = false;
			for(int j=1;j<=N;j++) {
				for(int[] g : graph[j]) {
					if(dist[j] != INF && dist[g[0]] > dist[j] + g[1]) {
						dist[g[0]] = dist[j]+g[1];
						update=true;
					}
				}
			}
			if(!update) {
				break;
			}
		}
		
		if(update) {
			for(int i=1;i<=N;i++) {
				for(int[] g: graph[i]) {
					if(dist[i] != INF && dist[g[0]]>dist[i]+g[1]) {
						return true; //한번 돌고 두번 돌았더니 결과가 바뀌었다?! 이건 음수가 있는거임
					}
				}
			}
		}
		return false;
	}

}

