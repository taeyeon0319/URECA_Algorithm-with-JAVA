package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_11403 {
	static int N;
	static List<Integer>[] g;
	static boolean[] visited;
	static int[][] answer;
	
	static void bfs(int v) {
		int f = v;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(v);
		while(!q.isEmpty()) {
			v = q.poll();
//			System.out.print(v+" ");
			for(int a:g[v]) {
				if(!visited[a]) {
					q.offer(a);
					visited[a] = true;
					answer[f][a] = 1;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		g = new List[N];
		for(int i=0;i<g.length;i++) g[i]=new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int l = Integer.parseInt(st.nextToken());
				if(l==1) {
					g[i].add(j);
				}
			}
		}
		answer = new int[N][N];
		for(int i=0;i<N;i++) {
			visited = new boolean[N];
			bfs(i);
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
	
		
	}

}

