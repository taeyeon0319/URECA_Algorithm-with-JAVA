package baekjoon;
import java.io.*;
import java.util.*;
public class Main_1967 {
	static int N;
	static ArrayList<Integer[]> graph[];
	static boolean[] visited;
	static int max = 0;
	
	public static void dfs(int a, int sum) {
		visited[a] = true;
		max = Math.max(max, sum);
		
		for(Integer[] temp : graph[a]) {
			int next = temp[0];
			int cost = temp[1];
			if(!visited[next]) {
				visited[next]=true;
				dfs(next, sum+cost);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		graph = new ArrayList[N+1];
		for(int i=1;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int aNode = Integer.parseInt(st.nextToken());
			int bNode = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			graph[aNode].add(new Integer[] {bNode, value});
			graph[bNode].add(new Integer[] {aNode, value});
		}
		
		for(int i=1;i<=N;i++) {
			Arrays.fill(visited, false);
			dfs(i, 0);
		}
		System.out.println(max);
	}
}


/*메모리 초과 남 - 2차원배열 써서 그런듯...
public class Main_1967 {
	static int N;
	static int[][] graph;
	static int[] result;
	static boolean[] visited;
	static int maxint = 0;
	
	public static void dfs(int a) {
		visited[a] = true;
		for(int i=1;i<=N;i++) {
			if(graph[a][i]!=0 && !visited[i]) {
				visited[i] = true;
				result[i] = result[a] + graph[a][i];
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new int[N+1][N+1];
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int aNode = Integer.parseInt(st.nextToken());
			int bNode = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			graph[aNode][bNode] = value;
			graph[bNode][aNode] = value;
		}
		
		
		for(int i=1;i<=N;i++) {
			result = new int[N+1];
			visited = new boolean[N+1];
			dfs(i);
			Arrays.sort(result);
			maxint = Math.max(maxint, result[N]);
		}
		System.out.println(maxint);
	}
}*/
