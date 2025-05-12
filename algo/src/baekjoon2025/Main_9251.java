package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_9251 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int[][] dp = new int[b.length()+1][a.length()+1];
		
		char[] achar = a.toCharArray();
		char[] bchar = b.toCharArray();
		
		for(int i=0;i<b.length();i++) {
			for(int j=0;j<a.length();j++) {
				if(bchar[i]==achar[j]) {
					dp[i+1][j+1] = dp[i][j]+1;
				}else {
					dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		System.out.println(dp[b.length()][a.length()]);	
		
		br.close();
	}
}
