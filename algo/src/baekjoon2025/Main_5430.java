package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_5430 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			
			Deque<Integer> deque = new LinkedList<>();
			
			//배열이 비어있지 않으면 추가
			if(!arr.equals("[]")) {
				for(String a : arr.substring(1, arr.length()-1).split(",")) {
					deque.add(Integer.parseInt(a));
				}
			}
			
			boolean reverse = false;
			boolean error = false;
			for(int j=0;j<p.length();j++) {
				if(p.charAt(j)=='R') {
					reverse = !reverse;
				}else {
					if(deque.isEmpty()) {
						System.out.println("error");
						error = true;
						break;
					}
					if(reverse) {
						deque.pollLast();
					}else {
						deque.pollFirst();
					}
				}
			}
			
			if(!error) {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				if(!reverse) {
					while(!deque.isEmpty()) {
						sb.append(deque.pollFirst());
						if(!deque.isEmpty()) sb.append(",");
					}
				}else {
					while(!deque.isEmpty()) {
						sb.append(deque.pollLast());
						if(!deque.isEmpty()) sb.append(",");
					}
				}
				sb.append("]");
				System.out.println(sb);
			}
		}
		br.close();
	}
}
/* 시간초과...
public class Main_5430 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			StringBuilder sb = new StringBuilder();
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			ArrayList<Integer> arrnum = new ArrayList<>();
			if(!arr.equals("[]")) {
				for(String a : arr.substring(1, arr.length()-1).split(",")) {
					arrnum.add(Integer.parseInt(a));
				}
			}
			
			for(int j=0;j<p.length();j++) {
				if(p.charAt(j)=='R') {
					Collections.reverse(arrnum);
				}else {
					if(arrnum.size()!=0) {
						arrnum.remove(0);
					}else {
						System.out.println("error");
						break;
					}
				}
			}
			if(arrnum.size()!=0) {
				sb.append("[");
				for(int j=0;j<arrnum.size()-1;j++) {
					sb.append(arrnum.get(j)+",");
				}
				sb.append(arrnum.get(arrnum.size()-1)+"]");
				System.out.println(sb);
			}
			
		}
		
		
		br.close();
	}
}*/