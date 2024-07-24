package baekjoon;
import java.io.*;
import java.util.*;

public class Main_18301 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int n3 = Integer.parseInt(st.nextToken());
		int result = (n1+1)*(n2+1)/(n3+1) -1;
		System.out.println(result);
	}
}

