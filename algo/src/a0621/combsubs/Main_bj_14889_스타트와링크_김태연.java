package a0621.combsubs;

import java.io.*;
import java.util.*;

public class Main_bj_14889_스타트와링크_김태연 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	
	static int N, C=0;
	static int[][] graph; 
	static int[] a, b, minusb = new int[2];
	static boolean[] v2;
	
	static int l;
	static ArrayList<Integer> powerList = new ArrayList<>();
	static int sum = 0;
	static void power(int cnt, int start) {
		if(cnt==(N/2)) {
			System.out.println(Arrays.toString(b));
			//System.out.println(graph[b[0]-1][b[1]-1]+graph[b[1]-1][b[0]-1]);
			for(int i=0;i<(N/2);i++) {
				
			}
			//			powerList.add(graph[b[0]-1][b[1]-1]+graph[b[1]-1][b[0]-1]);
			C++;
			return;
		}
		for(int i=start;i<N;i++) {
//			if (v[i]) continue;
//			v[i]=true;
			b[cnt]=a[i];
			power(cnt+1, i+1);
//			v[i]=false;
		}
	}
	static int m = 100;
	static void powerminus(int cnt, int start) {
		if(cnt==2) {
			m = Math.min(Math.abs(minusb[0]-minusb[1]), m);
			System.out.println(minusb[0]+" "+minusb[1]);
			System.out.println(Math.abs(minusb[0]-minusb[1]));//
			return;
		}
		for(int i=start;i<l;i++) {
			if (v2[i]) continue;
			v2[i]=true;
			minusb[cnt]=powerList.get(i);
			powerminus(cnt+1, i+1);
			v2[i]=false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N]; 
		a = new int[N];
		b=new int[N/2];
//		v = new boolean[N];
		for(int i=1;i<N+1;i++) {
			a[i-1]=i;
		}

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		power(0, 0);
		l = powerList.size();
		v2 = new boolean[l];
		powerminus(0, 0);
//		for(int i=0;i<powerList.size();i++) {
//			System.out.println(powerList.get(i));
//		}
		System.out.println(m);
        br.close();  
	}
}
