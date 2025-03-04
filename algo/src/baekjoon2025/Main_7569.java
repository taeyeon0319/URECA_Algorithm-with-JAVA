package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken()); //상자의 가로 칸의 수
        int N = Integer.parseInt(st.nextToken()); //상자의 세로 칸의 수
        int H = Integer.parseInt(st.nextToken()); //상자의 높이
        
        int[][][] tomato = new int[H][N][M];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int h=0;h<H;h++) {
        	for(int n=0;n<N;n++) {
        		st = new StringTokenizer(br.readLine());
        		for (int m = 0; m < M; m++) {
                    tomato[h][n][m] = Integer.parseInt(st.nextToken());
                    if (tomato[h][n][m] == 1) {
                        q.offer(new int[]{h, n, m}); // 익은 토마토 위치 저장
                    }
                }
        	}
        }
        int[] dz = {-1, 1, 0, 0, 0, 0};
        int[] dx = {0, 0, 1, -1, 0, 0};
        int[] dy = {0, 0, 0, 0, 1, -1};
        
        
        while(!q.isEmpty()) {
        	int[] xy = q.poll();
        	int z = xy[0];
        	int x = xy[1];
        	int y = xy[2];
        	for(int i=0;i<6;i++) {
        		int nz = dz[i]+z;
        		int nx = dx[i]+x;
        		int ny = dy[i]+y;
        		if(nz>=0 && nz<H && nx>=0 && nx<N && ny>=0 && ny<M && tomato[nz][nx][ny]==0) {
        			tomato[nz][nx][ny]=tomato[z][x][y]+1;
        			q.offer(new int[] {nz, nx, ny});
        		}
        	}
        }
        int maxDays=0;
        for(int h=0;h<H;h++) {
        	for(int n=0;n<N;n++) {
        		for(int m=0;m<M;m++) {
        			if(tomato[h][n][m]==0) {
        				System.out.println(-1);
        				return;
        			}
        			maxDays = Math.max(maxDays, tomato[h][n][m]);
        		}
        	}
        }
        System.out.println(maxDays-1);
        br.close();
    }
}
