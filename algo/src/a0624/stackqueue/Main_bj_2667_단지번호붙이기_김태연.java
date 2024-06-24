package a0624.stackqueue;

import java.io.*;
import java.util.*;

public class Main_bj_2667_단지번호붙이기_김태연 {
	static int[][] map;
	static int N;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int count;
	//bfs
	static void bfs(int i, int j) {
		count = 0;
		visited[i][j] = true;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			count+=1;
			int[] ij = q.poll();
			i =ij[0];
			j = ij[1];
			for(int k=0;k<4;k++) {
				int ni=dx[k]+i;
				int nj=dy[k]+j;
				if (0<=ni && ni<N && 0<=nj && nj<N && map[ni][nj]==1 && !visited[ni][nj]) {
					visited[ni][nj]=true;
					q.offer(new int[] {ni, nj});
				}
			}
		}
	}
	
	//dfs
	static void dfs(int i, int j) {
		count+=1;
		visited[i][j] = true;
		for(int k=0;k<4;k++) {
			int ni = dx[k]+i;
			int nj = dy[k]+j;
			if (0<=ni && ni<N && 0<=nj&&nj<N && map[ni][nj]==1 && !visited[ni][nj]) {
				dfs(ni, nj);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		ArrayList<Integer> resultList = new ArrayList<>();
		
		//이부분 암기 필요!
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=line.charAt(j)-'0';
			}
		}

//		for(int b[]:map) System.out.println(Arrays.toString(b));
		
		int result= 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					count=0;
					bfs(i, j);
					result+=1;
					resultList.add(count);
				}
			}
		}
		System.out.println(result);
		Collections.sort(resultList);
		//참고 : https://hianna.tistory.com/569
//		Collections.sort(resultList, (o1, o2)-> o1.compareTo(o2)); //정렬!!
		for(int a:resultList) System.out.println(a); 
		br.close();
	}

}
