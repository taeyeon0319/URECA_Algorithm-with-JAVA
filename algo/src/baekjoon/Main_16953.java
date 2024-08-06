package baekjoon;
import java.io.*;
import java.util.*;

public class Main_16953 {
	static int A, B;
	static boolean[] v;
	
	public static void change(int num) {
		v[num] = true;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(num);
		int[] cnt = new int[B+1];
		cnt[num] = 1;
		while(!v[B] && !q.isEmpty()) {
			num = q.poll();
			int fnum = num*2;
			if(fnum<=B) {
				if(!v[fnum]) {
					q.offer(fnum);
					v[fnum]=true;
					cnt[fnum] = cnt[num]+1;
				}
			}
			int snum = num*10+1;
			if(snum<=B) {
				if(!v[snum]) {
					q.offer(snum);
					v[snum]=true;
					cnt[snum] = cnt[num]+1;
				}
			}
		}
		if(cnt[B]==0) {
			System.out.println(-1);
		}else {
			System.out.println(cnt[B]);			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		v = new boolean[B+1];
		
		change(A);
			
	}
}
