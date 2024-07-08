package a0708.algorithm;

import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Main_bj_17471_게리맨더링_김태연2 {
	static int N;
	static int[] people;
	static ArrayList<Integer>[] g;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;
	
	static void subset(int cnt) {
		if(cnt==N) {
			ArrayList<Integer> a = new ArrayList<>(); //A조
			ArrayList<Integer> b = new ArrayList<>(); //B조
			for(int i=1;i<=N;i++) {
				if(visited[i]) a.add(i);
				else b.add(i);
			}
			if(a.size()+b.size()!=N) return; //남은 숫자가 있으면 안된다.
			if(a.size()==0 || b.size()==0) return; // 그룹에는 적어도 하나 이상의 숫자가 있어야한다.
			
			if(isPossible(a, 'a') && isPossible(b, 'b')) {
				int suma=0;
				for(int i=0;i<a.size();i++) {
					suma+=people[a.get(i)];
				}
				int sumb = 0;
				for(int i=0;i<b.size();i++) {
					sumb+=people[b.get(i)];
				}
				answer = Math.min(answer, Math.abs(suma-sumb));
			}
			return;
		}
		visited[cnt] = true; //a집합
		subset(cnt+1); 
		visited[cnt] = false; //b집합
		subset(cnt+1);
	}
	
	static boolean isPossible(ArrayList<Integer> a, char team) {
		boolean[] connect = new boolean[N+1];
		int cur = a.get(0);
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(cur);
		connect[cur]=true;
		while(!q.isEmpty()) {
			int i = q.poll();
			for(int j=0;j<g[i].size();j++) {
				int next = g[i].get(j);
				if(connect[next]) continue;
				if((team=='a' && visited[next]) || (team=='b' && !visited[next])) {
					q.add(next);
					connect[next]=true;
				}
			}
		}
		for(int i=0;i<a.size();i++) {
			if(!connect[a.get(i)]) return false;
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());		
		people = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		g = new ArrayList[N+1];
		for(int i=1;i<=N;i++) g[i] = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			for(int j=0;j<n;j++) {
				int num = Integer.parseInt(st.nextToken());
				g[i].add(num);
				g[num].add(i);
			}
		}
		visited = new boolean[N+1];
		
		subset(1);
		System.out.println(answer == Integer.MAX_VALUE?-1:answer);
		

	}

}
/*https://haerang94.tistory.com/391*/