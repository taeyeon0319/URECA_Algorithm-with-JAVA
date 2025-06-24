package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_2448 {
	static char[][] stars;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		stars = new char[N][N*2-1]; //꼭대기 별 [0][N-1]
		for(int i=0;i<N;i++) {
			Arrays.fill(stars[i], ' '); //공백으로 채우기
		}
		
		drawstars(0, N-1, N); //꼭대기 별
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<2*N-1;j++) {
				sb.append(stars[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	public static void drawstars(int x, int y, int n) {
		if(n==3) {
			stars[x][y] = '*';
			stars[x+1][y-1] = stars[x+1][y+1] = '*';
			stars[x+2][y-2] = stars[x+2][y-1] = stars[x+2][y] = stars[x+2][y+1] = stars[x+2][y+2] = '*';
		}else {
			drawstars(x, y, n/2); // 가운데 위 삼각형
			drawstars(x+n/2, y-n/2, n/2); //왼쪽 아래 삼각형
			drawstars(x+n/2, y+n/2, n/2); //오른쪽 아래 삼각형
		}
	}
}
