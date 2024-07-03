package a0703.prim;

import java.io.*;
import java.util.*;

public class PrimPqMain1 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/a0703/prim/input_prim.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		List<int[]>[] g = new List[N]; for(int i=0;i<N;i++) g[i] = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int c = sc.nextInt();
				if(c!=0) g[i].add(new int[]{j, c}); //인접정점번호, 비용
			}
		}
		
		boolean[] v = new boolean[N];
		int[] minEdge = new int[N]; //Arrays.fill(minEdge, Integer.MAX_VALUE);
		for(int i=0;i<N;i++) minEdge[i] = Integer.MAX_VALUE;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1], o2[1])); //비용에 대한 오름차순
		int sum=0, cnt=0;
		minEdge[0]=0;
		pq.offer(new int[] {0, 0}); //정점, 비용
		System.out.println(Arrays.toString(minEdge)); System.out.println();
		while(!pq.isEmpty()) {
			int[] vw = pq.poll();
			int minVertex = vw[0];//최소비용의 정점번호
			int min = vw[1]; //최소비용
			if(v[minVertex]) continue; //싸이클을 없앰
			
			v[minVertex]=true; //방문처리를 안해도 되긴 하지만 끝까지 도는 것이기 때문에 방문처리를 통해 시간과 메모리를 아끼자.
			sum+=min;
			System.out.println(Arrays.toString(v)); //방문처리확인
			System.out.println("minVertex="+minVertex+" min="+min+" sum="+sum);
			if(cnt++==N-1) break; //완성되었는지 확인
			
			for(int[] j:g[minVertex]) {
				if(!v[j[0]] && minEdge[j[0]]>j[1]) {
					minEdge[j[0]]=j[1]; //minEdge갱신
					pq.offer(j);
				}
			}
			
		}
		System.out.println(sum);
		sc.close();
	}

}
