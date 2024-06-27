package a0627.greedy;

import java.io.*;
import java.util.*;

public class Main_bj_1074_Z_김태연{
	static int cnt = 0;
	static int r, c;
	
	static void visit(int n, int x, int y) {
		if (n==1) return;
		if(x<n/2&&y<n/2) {
			visit(n/2, x, y);
		}else if(x<n/2&&n/2<=y) {
			cnt += (n*n)/4;
			visit(n/2, x, y-n/2);
		}else if(n/2<=x&&y<n/2) {
			cnt += (n*n)/4*2;
			visit(n/2, x-n/2, y);
		}else {
			cnt += (n*n)/4*3;
			visit(n/2, x-n/2, y-n/2);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int size = (int) Math.pow(2, N);
		
		visit(size, r, c);
		
		System.out.println(cnt);
	}
}


/* 메모리초과...
public class Main_bj_1074_Z_김태연 {
	static int cnt = 0;
	static int[][] graph;
	static int r, c;
	
	static void visit(int n, int x, int y) {
		if(n==2) {
			graph[x][y] = cnt++;
			graph[x][y+1] = cnt++;
			graph[x+1][y] = cnt++;
			graph[x+1][y+1] = cnt++;
			return;
		}
		visit(n/2, x, y);
		visit(n/2, x, y+n/2);
		visit(n/2, x+n/2, y);
		visit(n/2, x+n/2, y+n/2);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int size = (int) Math.pow(2, N);
		
		graph = new int[size][size];
		visit(size, 0, 0);
		
		System.out.println(graph[r][c]);
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

	}

}*/
