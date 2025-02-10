package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_17070 {
	static int N;
	static int[][] graph;
	static int result;
	public static void move(int x1, int y1, int x2, int y2) {
		if(x2==N-1 && y2==N-1) {
			result++;
			return;
		}
		
		//가로
		if(x1==x2 && y2 == y1+1) {
			if(y2+1<N && graph[x2][y2+1]==0) {
				move(x2, y2, x2, y2+1);// 오른쪽으로 이동
			}
		}
		//세로
		if(x2 == x1+1 && y2 == y1) {
			if(x2+1<N && graph[x2+1][y2]==0) {
				move(x2, y2, x2+1, y2); // 아래로 이동
			}
			
		}
		
		//대각선
		if(x2 == x1+1 && y2 == y1+1) {
			if(y2+1<N && graph[x2][y2+1]==0) {
				move(x2, y2, x2, y2+1); //오른쪽으로 이동
			}
			if(x2+1<N && graph[x2+1][y2]==0) {
				move(x2, y2, x2+1, y2); //아래로 이동
			}
		}
		
		if(x2+1<N && y2+1<N && graph[x2+1][y2+1]==0 && graph[x2+1][y2]==0 && graph[x2][y2+1]==0) {
			move(x2, y2, x2+1, y2+1); //대각선으로 이동
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st =new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 0;
		move(0, 0, 0, 1);
		System.out.println(result);	
		
	}
}



