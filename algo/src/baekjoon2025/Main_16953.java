package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_16953 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		int ans = 1;
		while(B!=A) {
			if(B<A) {
				ans=-1;
				break;
			}
			
			//맨 끝자리가 1이 아니면서 B가 2로 나누어 떨어지지 않는다면, A로 만들 수 없다.
			if(B%10 != 1 && B%2 != 0) {
				ans = -1;
				break;
			}
			
			//만약 2로 나누어 떨어지면
			if(B%2==0) {
				B = B/2;
			}else { //맨 끝자리가 1이면
				B = B/10;
			}
			ans++;
		}
		System.out.println(ans);
		br.close();
	}
}
