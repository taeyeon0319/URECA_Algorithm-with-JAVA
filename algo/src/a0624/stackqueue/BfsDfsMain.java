package a0624.stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BfsDfsMain {
	static final int[] di= {-1, 0, 1, 0};//상우하좌
	static final int[] dj = {0, 1, 0, -1};
	
	static int N=5,C=0;
	static int[][] a;
	static boolean[][] v;
	
	//dfs - 재귀사용
	//최댓값 구하는 문제
	static void dfs(int i, int j) {
		v[i][j] = true;
		a[i][j]=C++;
		for(int k=0;k<4;k++) {
			int ni = di[k]+i;
			int nj = dj[k]+j;
			if (0<=ni && ni<N && 0<=nj&&nj<N) {
				if (v[ni][nj]==false) {
					dfs(ni, nj);
				}
			}
		}
	}
	
	//bfs - 큐 사용
	//최단경로 문제는 bfs로 풀어야 시간초과가 안남.
	static void bfs(int i, int j) {
		v[i][j]=true;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i=ij[0];
			j=ij[1];
			a[i][j]=C++;
			for(int k=0;k<4;k++) {
				int ni = di[k]+i;
				int nj = dj[k]+j;
				if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj]) {
					v[ni][nj]=true;
					q.offer(new int[]{ni, nj});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		a = new int[N][N];
		v = new boolean[N][N];
		C=1;
		//dfs(N/2, N/2); //그래프의 한 가운데서 시작
		
		bfs(N/2, N/2);
		for(int b[]:a) System.out.println(Arrays.toString(b)); System.out.println();

	}



}
