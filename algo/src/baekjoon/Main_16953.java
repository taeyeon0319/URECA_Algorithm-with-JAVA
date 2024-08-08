package baekjoon;
import java.io.*;
import java.util.*;

public class Main_16953 {
	static long A, B;
	
	public static void change(long num) {
		Set<Long> visited = new HashSet<>();
		ArrayDeque<Long> q = new ArrayDeque<>();
		q.offer(num);
		Map<Long, Integer> cnt = new HashMap<>();
		cnt.put(num, 1);
		visited.add(num);
		
		while(!visited.contains(B)&& !q.isEmpty()) {
			num = q.poll();

			long fnum = num*2;
			if(fnum<=B && !visited.contains(fnum)) {
				q.offer(fnum);
				visited.add(fnum);
				cnt.put(fnum, cnt.get(num)+1);
				
			}
			long snum = num*10+1;
			if(snum<=B && !visited.contains(snum)) {
				q.offer(snum);
				visited.add(snum);
				cnt.put(snum, cnt.get(num)+1);
			}
		}
		if(!cnt.containsKey(B)) {
			System.out.println(-1);
		}else {
			System.out.println(cnt.get(B));			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		change(A);
			
	}
}
