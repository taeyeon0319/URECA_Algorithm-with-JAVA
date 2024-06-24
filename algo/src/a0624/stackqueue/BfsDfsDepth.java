package a0624.stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BfsDfsDepth {
	static final int[] di= {-1, 0, 1, 0};//상우하좌
	static final int[] dj = {0, 1, 0, -1};
	
	static int N=5,C=0;
	static int[][] a;
	static boolean[][] v;
	
	//dfs - 재귀사용
	static void dfs(int i, int j, int depth) {
		v[i][j] = true;
		a[i][j]=depth;
		System.out.println(depth);
		for(int k=0;k<4;k++) {
			int ni = di[k]+i;
			int nj = dj[k]+j;
			if (0<=ni && ni<N && 0<=nj&&nj<N) {
				if (v[ni][nj]==false) {
					dfs(ni, nj, depth+1);
				}
			}
		}
	}
	
	
	//bfs - 큐 사용
	/*static void bfs(int i, int j, int depth) {
		v[i][j]=true;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j, depth});
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i=ij[0];
			j=ij[1];
			depth = ij[2];
			a[i][j]=C++;
			System.out.println(depth);
			for(int k=0;k<4;k++) {
				int ni = di[k]+i;
				int nj = dj[k]+j;
				if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj]) {
					v[ni][nj]=true;
					q.offer(new int[]{ni, nj, depth+1});
				}
			}
		}
	}*/
	
	static void bfs(int i, int j, int depth) {
		v[i][j]=true;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		//int depth=0;
		while (!q.isEmpty()) {
			int S=q.size();
			for(int s=0;s<S;s++) {
				int[] ij = q.poll();
				i=ij[0];
				j=ij[1];
				a[i][j]=C++;
				System.out.println(depth);
				for(int k=0;k<4;k++) {
					int ni = di[k]+i;
					int nj = dj[k]+j;
					if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj]) {
						v[ni][nj]=true;
						q.offer(new int[]{ni, nj});
					}
				}
			}
			depth++;
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		a = new int[N][N];
		v = new boolean[N][N];
		C=1;
		//dfs(N/2, N/2, 0); //그래프의 한 가운데서 시작
		
		bfs(N/2, N/2, 0);
		for(int b[]:a) System.out.println(Arrays.toString(b)); System.out.println();

	}



}
