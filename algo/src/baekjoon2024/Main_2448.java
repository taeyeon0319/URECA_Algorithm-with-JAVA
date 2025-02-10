package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_2448 {
	static char[][] stars;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		stars = new char[N][N*2-1];
		for(char[] s : stars) {
			Arrays.fill(s, ' ');
		}
		
		StringBuilder sb = new StringBuilder();
		star(0, N-1, N);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N*2-1;j++) {
				sb.append(stars[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static void star(int x, int y, int n) {
		if(n==3) {
			stars[x][y]='*';
			stars[x+1][y-1]=stars[x+1][y+1]='*';
			stars[x+2][y-2]=stars[x+2][y-1]=stars[x+2][y]=stars[x+2][y+1]=stars[x+2][y+2]='*';
			
		}else {
			star(x, y, n/2);
			star(x+n/2, y-n/2, n/2);
			star(x+n/2, y+n/2, n/2);
			
		}
	}
}

