package a0624.stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BfsDfsReturn {
	static final int[] di= {-1, 0, 1, 0};//상우하좌
	static final int[] dj = {0, 1, 0, -1};
	
	static int N=5,C=0;
	static int[][] a;
	static boolean[][] v;
	
	//dfs - 재귀사용
	static int dfs(int i, int j) {
		v[i][j] = true;
		a[i][j]=C++;
		int cnt =1;
		for(int k=0;k<4;k++) {
			int ni = di[k]+i;
			int nj = dj[k]+j;
			if (0<=ni && ni<N && 0<=nj&&nj<N && !v[ni][nj]) {
				cnt = cnt+dfs(ni, nj);
			}
		}
		return cnt;
	}
	
	//bfs - 큐 사용
	static int bfs(int i, int j) {
		v[i][j]=true;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		int cnt=1;
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i=ij[0];
			j=ij[1];
			a[i][j]=C++;
			cnt++;
			for(int k=0;k<4;k++) {
				int ni = di[k]+i;
				int nj = dj[k]+j;
				if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj]) {
					v[ni][nj]=true;
					q.offer(new int[]{ni, nj});
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws Exception{
		a = new int[N][N];
		v = new boolean[N][N];
		C=1;
		System.out.println(dfs(N/2, N/2)); 
		
//		System.out.println(bfs(N/2, N/2));
//		for(int b[]:a) System.out.println(Arrays.toString(b)); System.out.println();

	}



}
