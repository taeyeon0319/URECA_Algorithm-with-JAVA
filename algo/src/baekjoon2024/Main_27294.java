package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_27294 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		if(S==1 || T<=11 || T>16) {
			System.out.println(280);
		}else {
			System.out.println(320);
		}
		
	}

}
