package baekjoon;

import java.io.*;
import java.util.*;

public class Main_30017 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int result = 0;
		if(A<=B) {
			result = A+(A-1);
		}else {
			result = B+(B+1);
		}
		System.out.println(result);
	}

}
