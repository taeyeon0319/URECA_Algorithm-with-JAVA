package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_30805 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int idxA = 0, idxB=0;
		
		Queue<Integer> result = new ArrayDeque<>();
		
		while(idxA<N && idxB<M) {
			int max = 0;
			int nextA = -1, nextB = -1;
			
			for(int i=idxA;i<N;i++) {
				for(int j=idxB;j<M;j++) {
					if(A[i] == B[j] && A[i]>max) {
						max = A[i];
						nextA = i;
						nextB = j;
//						System.out.println(max+" "+i+" "+j);
					}
				}
			}
			
			if (max==0) break;
//			System.out.println(max+"aa");
			result.offer(max);
			idxA = nextA+1;
			idxB = nextB+1;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append((result.size())).append("\n");
		for(int num:result) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
		
		br.close();
	}
}

//시간초과
//public class Main_30805 {
//	static int N, M;
//	static int[] A;
//	static int[] B;
//	static ArrayList<ArrayList<Integer>> result;
//	static ArrayList<ArrayList<Integer>> realresult;
//	static ArrayList<Integer> AList;
//	static ArrayList<Integer> BList;
//	static boolean[] Avisited;
//	static boolean[] Bvisited;
//	
//	public static void perm(int limit, int cnt, int a) {
//		if(cnt==limit) {
//			result.add(new ArrayList<>(AList));
//			return;
//		}
//		for(int i=a;i<A.length;i++) {
//			if(Avisited[i]) continue;
//			Avisited[i] = true;
//			AList.add(A[i]);
//			perm(limit, cnt+1, i);
//			AList.remove(AList.size()-1);
//			Avisited[i] = false;
//		}
//	}
//	
//	public static void perm2(int limit, int cnt, int b) {
//		if(cnt==limit) {
//			if(result.contains(new ArrayList<>(BList))) {
//				realresult.add(new ArrayList<>(BList));
//			}
//			return;
//		}
//		for(int i=b;i<B.length;i++) {
//			if(Bvisited[i]) continue;
//			Bvisited[i] = true;
//			BList.add(B[i]);
//			perm2(limit, cnt+1, i);
//			BList.remove(BList.size()-1);
//			Bvisited[i] = false;
//		}
//	}
//	
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		N = Integer.parseInt(br.readLine());
//		A = new int[N];
//		
//		result = new ArrayList<>();
//		realresult = new ArrayList<>();
//		
//		st = new StringTokenizer(br.readLine());
//		for(int i=0;i<N;i++) {
//			A[i] = Integer.parseInt(st.nextToken());
// 		}
//		
//		M = Integer.parseInt(br.readLine());
//		B = new int[M];
//		st = new StringTokenizer(br.readLine());
//		for(int i=0;i<M;i++) {
//			B[i] = Integer.parseInt(st.nextToken());
// 		}
//		
//		int l = Math.min(N, M);
//		for(int i=0;i<l;i++) {
//			AList = new ArrayList<>();
//			Avisited= new boolean[N];
//			BList = new ArrayList<>();
//			Bvisited = new boolean[M];
//			perm(i, 0, 0);
//			perm2(i, 0, 0);
//		}
//		
//		realresult.sort((a, b) -> {
//			int len = Math.min(a.size(), b.size());
//			for(int i=0;i<len;i++) {
//				int cmp = Integer.compare(a.get(i), b.get(i));
//				if(cmp!=0) return cmp;
//			}
//			return Integer.compare(a.size(), b.size());
//		});
//		
//		ArrayList<Integer> r = realresult.get(realresult.size()-1);
//		System.out.println(r.size());
//		for(Integer rr : r) {
//			System.out.print(rr+" ");
//		}
//		br.close();
//	}
//}

