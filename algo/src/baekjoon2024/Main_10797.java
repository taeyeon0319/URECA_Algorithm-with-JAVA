package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_10797 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dayNum = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int result = 0;
		for(int i=0;i<5;i++) {
			int car = Integer.parseInt(st.nextToken());
			if(car==dayNum) {
				result+=1;
			}
		}
		System.out.println(result);
		
	}

}

