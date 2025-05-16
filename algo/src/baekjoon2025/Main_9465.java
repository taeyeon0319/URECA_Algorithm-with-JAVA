package baekjoon2025;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main_9465 {
    static int N;
    static int[][] sticker;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            sticker = new int[2][N];
            int[][] result = new int[2][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                sticker[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                sticker[1][i] = Integer.parseInt(st.nextToken());
            }
            
            if(N>=1) {
            	result[0][0] = sticker[0][0];
            	result[1][0] = sticker[1][0];
            }
            if(N>=2) {
            	result[0][1] = sticker[0][1] + result[1][0];
            	result[1][1] = sticker[1][1] + result[0][0];
            }
            if(N>=3) {
            	for(int i=2;i<N;i++) {
            		result[0][i] = sticker[0][i] + Math.max(result[1][i-1], result[1][i-2]);
            		result[1][i] = sticker[1][i] + Math.max(result[0][i-1], result[0][i-2]);
            	}
            	
            }
            System.out.println(Math.max(result[0][N-1], result[1][N-1]));
        }
    }
}
