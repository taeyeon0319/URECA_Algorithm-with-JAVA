package baekjoon;
import java.io.*;
import java.util.*;

public class Main_11279 {
	
	static int N, M, B;
	static int[][] graph;
	static int max, min;
	
	static int result = 0;
	static int[] resultset;
	
	//땅이 균일한지 안한지 확인
	public static boolean checksame() {
		int a = graph[0][0];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(a!=graph[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void updown(int x, int y, int[][] graph) {
		if(checksame()) { return; }
		//블록 위에 쌓기
		graph[x][y] +=1;
		result += 1;
		B-=1;
		updown(x, y+1, graph);
		updown(x+1, y, graph);
		updown(x+1, y+1, graph);
		
		//블록 제거
		B+=1;
		result +=1;
		graph[x][y]-=2;
		updown(x, y+1, graph);
		updown(x+1, y, graph);
		updown(x+1, y+1, graph);
		
		//그냥 지나감
		result -=2;
		graph[x][y]+=1;
		updown(x, y+1, graph);
		updown(x+1, y, graph);
		updown(x+1, y+1, graph);
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, graph[i][j]);
				min = Math.min(min,  graph[i][j]);
			}
		}
		
		for(int[] a: graph) {
			System.out.println(Arrays.toString(a));
		}
		
		//블록 위에 쌓기
		while(!checksame()) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(graph[i][j]!=max) {
						graph[i][j]+=1;
						B-=1;
						result+=1;
					}
				}
			}
		}

		
		
		
//		//블록 제거하기
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				if(graph[i][j]!=min) {
//					graph[i][j]-=1;
//					B+=1;
//					result += 2;
//				}
//			}
//		}
		System.out.println(result+ " " + B);
		
	}

}

