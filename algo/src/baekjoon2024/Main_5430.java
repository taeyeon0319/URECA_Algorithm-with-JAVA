package baekjoon2024;

import java.io.*;
import java.util.*;

public class Main_5430 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String p = br.readLine(); //1<= p.length <= 100,000
			int n = Integer.parseInt(br.readLine()); //0<= n <= 100,000
			Deque<Integer> numlist = new ArrayDeque<>();
			String l = br.readLine();
			
			if(n>0) {
				l = l.substring(1, l.length()-1);
				if(!l.isEmpty()) {
					String[] tokens = l.split(",");
					for(String t : tokens) {
						numlist.offer(Integer.parseInt(t));
					}
				}
			}
			
			boolean status = true;
			boolean right = true;
			
			/*for(int j=0;j<p.length();j++) {
				char c = p.charAt(j);*/
			for(char c : p.toCharArray()) {
				if(c=='R') {
					right = !right;
					
				}else if(c=='D') {
					if(numlist.isEmpty()) {status=false; break;}
					
					else {
						if(right) numlist.pollFirst();
						else numlist.pollLast();
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			if (!status) {
                sb.append("error\n");
            } else {
                sb.append("[");
                if (right) {
                    while (numlist.size() > 1) {
                        sb.append(numlist.pollFirst()).append(",");
                    }
                    if (!numlist.isEmpty()) {
                        sb.append(numlist.pollFirst());
                    }
                } else {
                    while (numlist.size() > 1) {
                        sb.append(numlist.pollLast()).append(",");
                    }
                    if (!numlist.isEmpty()) {
                        sb.append(numlist.pollLast());
                    }
                }
                sb.append("]\n");
            }
			System.out.print(sb);
			
		}
		br.close();
		
	}

}
