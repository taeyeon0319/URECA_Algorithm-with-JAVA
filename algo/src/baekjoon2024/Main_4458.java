package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_4458 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			System.out.println((s.charAt(0)+"").toUpperCase()+s.substring(1, s.length()));
				
		}
	}

}

