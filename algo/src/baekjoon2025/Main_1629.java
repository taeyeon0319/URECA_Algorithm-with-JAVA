package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1629 {
	static long A, B, C;

	public static long pow(long A, long B) {
		if(B==1) {
			return A%C;
		}
		long temp = pow(A, B/2);
		if(B%2==1) {
			return (temp*temp)%C * A%C;
		}else {
			return (temp*temp)%C;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(pow(A, B));
		
		
		br.close();
	}
}
