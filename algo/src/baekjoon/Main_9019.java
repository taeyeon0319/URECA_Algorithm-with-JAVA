package baekjoon;
import java.io.*;
import java.util.*;

public class Main_9019 {
	static int A, B;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			st =new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			String[] answer = new String[10000];
			boolean[] visited = new boolean[10000];
			
			ArrayDeque<Integer> q = new ArrayDeque<>();
			q.offer(A);
			visited[A]= true;
			answer[A]="";
			while(!q.isEmpty() && !visited[B]) {
				int now = q.poll();
				int D = (now*2)%10000;
				int S = now==0?9999:(now-1);
				int L = (now%1000)*10+(now/1000);
				int R = (now%10)*1000+(now/10);
				
				if (!visited[D]) {
					q.offer(D);
					visited[D]=true;
					answer[D] = answer[now]+"D";
				}
				if(!visited[S]) {
					q.offer(S);
					visited[S]=true;
					answer[S] = answer[now]+"S";
				}
				if(!visited[L]) {
					q.offer(L);
					visited[L]=true;
					answer[L] = answer[now]+"L";
				}
				if(!visited[R]) {
					q.offer(R);
					visited[R]=true;
					answer[R] = answer[now]+"R";
				}
			}
			System.out.println(answer[B]);
		}
		
	}
}