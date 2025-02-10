package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_1167 {
	static int V;
	static List<int[]>[] graph;
	static int max = 0;
	static int farthest=0;
	static boolean[] visited;
	
	public static void dfs(int v, int sum) {
		visited[v] = true;
		for(int[] a : graph[v]) {
			int nextv = a[0];
			int value = a[1];
			if(!visited[nextv]) {
				dfs(nextv, sum+value);
			}
		}
		if(sum>max) {
			max = sum;
			farthest = v;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		
		graph = new List[V+1];
		for(int i=0;i<=V;i++) graph[i] = new ArrayList<int[]>();
		
		for(int i=0;i<V;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2=0;
			int distance=0;
			while(true) {
				v2 = Integer.parseInt(st.nextToken());
				if(v2==-1) {
					break;
				}
				distance = Integer.parseInt(st.nextToken());
				graph[v1].add(new int[] {v2, distance});	
			}
		}
		visited = new boolean[V+1];
		dfs(1, 0);
		
		visited = new boolean[V+1];
		max = 0;
		dfs(farthest, 0);
		
		System.out.println(max);
		
	}
}


/* 시간 초과
 public class Main{
	static int V;
	static List<int[]>[] graph;
	static int max = 0;
	static boolean[] visited;
	
	public static void dfs(int v, int sum) {
		visited[v] = true;
		for(int[] a : graph[v]) {
			int nextv = a[0];
			int value = a[1];
			if(!visited[nextv]) {
				visited[nextv]=true;
				dfs(nextv, sum+value);
			}
		}
		max = Math.max(max, sum);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		
		graph = new List[V+1];
		for(int i=0;i<=V;i++) graph[i] = new ArrayList<int[]>();
		
		for(int i=0;i<V;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2=0;
			int distance=0;
			while(true) {
				v2 = Integer.parseInt(st.nextToken());
				if(v2==-1) {
					break;
				}else {
					distance = Integer.parseInt(st.nextToken());
					graph[v1].add(new int[] {v2, distance});	
				}
			}
		}
		int result = 0;
		visited = new boolean[V+1];
		for(int i=1;i<=V;i++) {
			Arrays.fill(visited, false);
			dfs(i, 0);
			result = Math.max(result, max);
		}
		System.out.println(result);
//		for(List<int[]> a:graph) {
//			for(int[] b:a) {
//				System.out.print(Arrays.toString(b) +" ");
//			}
//			System.out.println();
//		}
	}
}
 */
