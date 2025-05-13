package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_15686 {
	static int N, M;
	static int[][] graph;
	static ArrayList<int[]> chicken;
	static ArrayList<int[]> house;
	static boolean[] visited;
	static int result = Integer.MAX_VALUE;
	
	public static void backtracking(int start, int count) {
		if(count==M) { //치킨집을 선택하면!
			int sum = 0;
			for(int[] h : house) {
				int mindist = Integer.MAX_VALUE;
				for(int i=0;i<chicken.size();i++) {
					if(visited[i]) { //선택한 집이라면
						int dist = Math.abs(h[0] - chicken.get(i)[0])+Math.abs(h[1]-chicken.get(i)[1]);
						mindist = Math.min(mindist, dist);
					}
				}
				sum+=mindist;
			}
			result = Math.min(result, sum);
		}
		for(int i=start;i<chicken.size();i++) {
			visited[i] = true; //이 치킨집을 선택할 경우
			backtracking(i+1, count+1);
			visited[i] = false; //이 치킨집을 선택안하는 경우
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][N];
		chicken = new ArrayList<>();
		house = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j]==1) {
					house.add(new int[] {i, j});
				}else if(graph[i][j]==2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		
		visited = new boolean[chicken.size()];
		backtracking(0, 0);
		System.out.println(result);
		
		br.close();

	}
}

//public class Main_15686 {
//	static int N, M;
//	static int[][] graph;
//	static ArrayList<int[]> chicken; 
//	static ArrayList<int[]> house;
//	static boolean[] visited;
//	static int result = Integer.MAX_VALUE;
//	
//	public static void backtracking(int start, int count) {
//		if(count==M) {
//			int chickendist = 0;
//			for(int[] h :house) {
//				int min = Integer.MAX_VALUE;
//				for(int i = 0; i < chicken.size(); i++) {
//					if(visited[i]) {
//						int[] c = chicken.get(i);
//						int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
//						min = Math.min(min, dist);
//					}
//				}
//				chickendist += min;
//			}
//			result = Math.min(result, chickendist);
//			
//		}
//		for(int i=start;i<chicken.size();i++) {
//			if(!visited[i]) {
//				visited[i] = true;
//				backtracking(i+1, count+1);
//				visited[i] = false;
//			}
//		}
//	}
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		
//		graph = new int[N][N];
//		chicken = new ArrayList<>();
//		house = new ArrayList<>();
//		
//		for(int i=0;i<N;i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j=0;j<N;j++) {
//				graph[i][j] = Integer.parseInt(st.nextToken());
//				if(graph[i][j]==2) {
//					chicken.add(new int[] {i, j});
//				}else if(graph[i][j]==1) {
//					house.add(new int[] {i, j});
//				}
//			}
//		}
//		visited = new boolean[chicken.size()];
//		backtracking(0, 0);
//		System.out.println(result);
//		
//		br.close();
//
//	}
//}
