package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_17144 {
	static int N;
	static String[][] graph1, graph2;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static boolean[][] v;
	
	public static void bfs(int x, int y, String[][] graph) {
		v[x][y] = true;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			x = xy[0];
			y = xy[1];
			for(int k=0;k<4;k++) {
				int nx = dx[k]+x;
				int ny = dy[k]+y;
				if(0<=nx && nx<N && 0<=ny && ny<N && !v[nx][ny]) {
					if(graph[x][y].equals("R") && graph[nx][ny].equals("R")) {
						q.offer(new int[] {nx, ny});
						v[nx][ny] = true;
					}else if((graph[x][y].equals("B")) && (graph[nx][ny].equals("B"))){
						q.offer(new int[] {nx, ny});
						v[nx][ny] = true;
					}else if((graph[x][y].equals("G")) && (graph[nx][ny].equals("G"))) {
						q.offer(new int[] {nx, ny});
						v[nx][ny] = true;
					}
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph1 = new String[N][N];
		graph2 = new String[N][N]; // 적록 색약
		v = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String a = br.readLine();
			for(int j=0;j<N;j++) {
				String c = Character.toString(a.charAt(j));
				graph1[i][j] = c;
				graph2[i][j] = c.equals("G")? "R":c;
				
			}
		}
		
		int answer1= 0;
		int answer2 = 0;
		
		v = new boolean[N][N];

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!v[i][j]) {
					bfs(i, j, graph1);	
					answer1+=1;
				}
			}
		}
		
		v = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!v[i][j]) {
					bfs(i, j, graph2);	
					answer2+=1;
				}
			}
		}
		
		System.out.println(answer1+" "+answer2);
		
	}

}

