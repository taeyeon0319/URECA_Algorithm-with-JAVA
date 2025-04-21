package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_14500 {
	static int N, M;
	static int[][] graph;
	static int maxvalue=0;
	
	public static int type1() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<=M-4;j++) {
				int value=0;
				for(int k=j;k<j+4;k++) {
					value+=graph[i][k];
				}
				maxvalue=Math.max(maxvalue, value);
			}
		}
		for(int j=0;j<M;j++) {
			for(int i=0;i<=N-4;i++) {
				int value=0;
				for(int k=i;k<i+4;k++) {
					value+=graph[k][j];
				}
				maxvalue=Math.max(maxvalue, value);
			}
		}
		return maxvalue;
	}
	
	public static int type2() {
		for(int i=0;i<=N-2;i++) {
			for(int j=0;j<=M-2;j++) {
				int value = graph[i][j]+graph[i][j+1]+graph[i+1][j]+graph[i+1][j+1];
				maxvalue = Math.max(maxvalue, value);
			}
		}
		return maxvalue;
	}
	
	public static int type3() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<=M-3;j++) {
				int value=0;
				for(int k=j;k<j+3;k++) {
					value+=graph[i][k];
				}
				int tempMax = 0;
				if(i>0 && i<N-1) {
					tempMax = Math.max(
						   Math.max(graph[i-1][j], graph[i-1][j+2]),
						   Math.max(graph[i+1][j], graph[i+1][j+2]));
				}else if(i==0) {
					tempMax = Math.max(graph[i+1][j], graph[i+1][j+2]);
				}else if(i==N-1) {
					tempMax = Math.max(graph[i-1][j], graph[i-1][j+2]);
				}
				value+=tempMax;
				maxvalue=Math.max(maxvalue, value);
			}
		}
		for(int j=0;j<M;j++) {
			for(int i=0;i<=N-3;i++) {
				int value=0;
				for(int k=i;k<i+3;k++) {
					value+=graph[k][j];
				}
				int tempMax = 0;
				if(j>0 && j<M-1) {
					tempMax = Math.max(
						   Math.max(graph[i][j-1], graph[i+2][j-1]),
						   Math.max(graph[i][j+1], graph[i+2][j+1]));
				}else if(j==0) {
					tempMax = Math.max(graph[i][j+1], graph[i+2][j+1]);
				}else if(j==M-1) {
					tempMax = Math.max(graph[i][j-1], graph[i+2][j-1]);
				}
				value+=tempMax;
				maxvalue=Math.max(maxvalue, value);
			}
		}
		return maxvalue;
	}
	
	public static int type4() {
		for(int i=1;i<N-1;i++) {
			for(int j=0;j<=M-2;j++) {
				int value=0;
				for(int k=j;k<j+2;k++) {
					value+=graph[i][k];
				}
				int tempMax = 0;
				tempMax = Math.max(graph[i-1][j]+graph[i+1][j+1], graph[i-1][j+1]+graph[i+1][j]);
				value+=tempMax;
				maxvalue=Math.max(maxvalue, value);
			}
		}
		for(int j=1;j<M-1;j++) {
			for(int i=0;i<=N-2;i++) {
				int value=0;
				for(int k=i;k<i+2;k++) {
					value+=graph[k][j];
				}
				int tempMax = 0;
				tempMax = Math.max(graph[i][j+1]+graph[i+1][j-1], graph[i+1][j+1]+graph[i][j-1]);
				value+=tempMax;
				maxvalue=Math.max(maxvalue, value);
			}
		}
		return maxvalue;
	}
	public static int type5() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<=M-3;j++) {
				int value=0;
				for(int k=j;k<j+3;k++) {
					value+=graph[i][k];
				}
				int tempMax = 0;
				if(i>0 && i<N-1) {
					tempMax = Math.max(graph[i-1][j+1], graph[i+1][j+1]);
				}else if(i==0) {
					tempMax = graph[i+1][j+1];
				}else if(i==N-1) {
					tempMax = graph[i-1][j+1];
				}
				value+=tempMax;
				maxvalue=Math.max(maxvalue, value);
			}
		}
		for(int j=0;j<M;j++) {
			for(int i=0;i<=N-3;i++) {
				int value=0;
				for(int k=i;k<i+3;k++) {
					value+=graph[k][j];
				}
				int tempMax = 0;
				if(j>0 && j<M-1) {
					tempMax = Math.max(graph[i+1][j-1], graph[i+1][j+1]);
				}else if(j==0) {
					tempMax = graph[i+1][j+1];
				}else if(j==M-1) {
					tempMax = graph[i+1][j-1];
				}
				value+=tempMax;
				maxvalue=Math.max(maxvalue, value);
			}
		}
		return maxvalue;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		type1();
		type2();
		type3();
		type4();
		System.out.println(type5());
		
		br.close();
	}
}
