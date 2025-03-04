package baekjoon2025;

import java.io.*;

public class Main_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {  // N이 1일 때 예외 처리
            System.out.println(score[1]);
            return;
        }

        int[] dp = new int[N + 1];
        dp[1] = score[1];
        dp[2] = score[1] + score[2];

        if (N == 2) {  // N이 2일 때 예외 처리
            System.out.println(dp[2]);
            return;
        }

        dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);

        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
        }

        System.out.println(dp[N]);
        br.close();
    }
}
