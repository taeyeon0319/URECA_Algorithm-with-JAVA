package baekjoon;
import java.io.*;
import java.util.*;

public class Main_6064 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int[] data = new int[4];
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				data[j] = Integer.parseInt(st.nextToken());
			}
			
			int m = 0, n = 0;
			int count = 0;
			while(true) {
				count+=1;
				m = count%data[0] ==0 ? data[0] : count%data[0];
				n = count%data[1] ==0 ? data[1] : count%data[1];
				if(m==data[2] && n==data[3]) {
					break;
				}
				if(count!=1 && m==1 && n==1) {
					count=-1;
					break;
				}
				
			}
			System.out.println(count);
		}
	}

}

