package a0619.recu;

import java.io.*;
import java.util.*;

public class Main_bj_16935_배열돌리기3_김태연 {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_bj_16935.txt"));
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int[] K = new int[R];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			K[i] = Integer.parseInt(st.nextToken());
		}
				
		
		int[][] answer = null;
		
		StringBuilder sb = new StringBuilder();
		
		for (int a = 0;a<R;a++) {
			int k = K[a];
			//수행
			if (k==1) {
				answer = new int[N][M];
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						answer[i][j] = graph[N-i-1][j];
					}
				}

			}else if(k==2) {
				answer = new int[N][M];
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						answer[i][j] = graph[i][M-j-1];
					}
				}

			}else if(k==3) {
				answer = new int[M][N];
				for(int j=0;j<M;j++) {
					for(int i=0;i<N;i++) {
						answer[j][i] = graph[N-i-1][j];
					}
				}
			}else if(k==4){
				answer = new int[M][N];
				for(int j=0;j<M;j++) {
					for(int i=0;i<N;i++) {
						answer[j][i] = graph[i][M-j-1];
					}
				}
		        
			}else if(k==5) {
				answer = new int[N][M];
				int n = N/2;
				int m = M/2;
				
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						if (i<n && j<m) {
							answer[i][j]=graph[i+n][j];
						}else if(i<n && m<=j && j<M) {
							answer[i][j]=graph[i][j-m];
						}else if(n<=i && i<N && j<m) {
							answer[i][j]=graph[i][j+m];
						}else {
							answer[i][j]=graph[i-n][j];
						}
					}
					
				}

			}else {
				answer = new int[N][M];
				int n = N/2;
				int m = M/2;
				
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						if (i<n && j<m) {
							answer[i][j]=graph[i][j+m];
						}else if(i<n && m<=j && j<M) {
							answer[i][j]=graph[i+n][j];
						}else if(n<=i && i<N && j<m) {
							answer[i][j]=graph[i-n][j];
						}else {
							answer[i][j]=graph[i][j-m];
						}
					}
					
				}
			}
			
			graph = answer;
			N = answer.length;
			M = answer[0].length;
		}
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n"); // 각 행의 끝에 개행 추가
        }
		
		System.out.println(sb.toString());
	
		
        br.close();  
	}

}
