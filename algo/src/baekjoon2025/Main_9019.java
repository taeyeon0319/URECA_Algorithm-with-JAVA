package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_9019 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			String[] register = new String[10001];
			
			ArrayDeque<Integer> q = new ArrayDeque<>();
			q.offer(A);
			register[A] = "";
			while(!q.isEmpty() && register[B]==null) {
				int num = q.poll();
				int[] numlist = new int[4];
				int d1 = num/1000;
				int d2 = (num%1000)/100;
				int d3 = (num%100)/10;
				int d4=num%10;
				numlist[0] = (num*2>9999)?(num*2)%10000:num*2;
				numlist[1] = (num==0) ? 9999 : num-1;
				numlist[2] = d2*1000+d3*100+d4*10+d1;
				numlist[3] = d4*1000 + d1*100+d2*10+d3;
				for(int i=0;i<4;i++) {
					int nnum = numlist[i];
					if(nnum<=10000 && register[nnum]==null) {
						register[nnum] = (register[num]==null? "":register[num]) + Integer.toString(i);
						q.offer(nnum);
					}
				}
				
			}
			StringBuilder sb = new StringBuilder();
			for(char b : register[B].toCharArray()) {
				if(b=='0') {
					sb.append("D");
				}else if(b=='1') {
					sb.append("S");
				}else if(b=='2') {
					sb.append("L");
				}else {
					sb.append("R");
				}
			}
			System.out.println(sb);
		
			
		}

		br.close();
	}
}
