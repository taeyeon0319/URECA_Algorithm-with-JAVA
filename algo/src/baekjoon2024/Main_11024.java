package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_11024 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			String[] numbers = br.readLine().split(" ");
			int sum = 0;
			for(String n : numbers) {
				sum += Integer.parseInt(n);
			}
			System.out.println(sum);
		}
		
		br.close();
	}
}

