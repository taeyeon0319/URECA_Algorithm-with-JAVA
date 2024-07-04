package a0703.prim;
/*프림 알고리즘*/
import java.io.*;
import java.util.*;

public class Main_bj_1922_네트워크_김태연 {

	public static void main(String[] args) throws Exception {
		/*입력*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //컴퓨터의 수
		int M = Integer.parseInt(br.readLine()); //연결할 수 있는 선의 수
		
		List<int[]>[] g = new List[N+1]; //번호가 1부터 시작하기 때문에 N+1크기로 초기화
		for(int i=0;i<N+1;i++) g[i]=new ArrayList<int[]>();
		
		for(int i=0;i<M;i++) {
			st= new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()); //a컴퓨터
			int b = Integer.parseInt(st.nextToken()); //b컴퓨터
			int c = Integer.parseInt(st.nextToken()); //비용
			/*양방향으로 연결*/
			g[a].add(new int[] {b, c}); //인접정점번호, 비용
			g[b].add(new int[] {a, c});
		}
		
//		for(int i=0;i<g.length;i++) {
//			System.out.print(i+":");
//			for(int[] arr:g[i]) {
//				System.out.print(Arrays.toString(arr));
//			}
//			System.out.println();
//		}

		boolean[] v = new boolean[N+1]; //방문여부배열
		int[] minEdge = new int[N+1];  //각 정점까지의 최소간선비용 배열
		for(int i=0;i<N+1;i++) minEdge[i] = Integer.MAX_VALUE;
		
		int sum=0, cnt=0;
		minEdge[1]=0; //시작 정점을 1로

		for(int i=0;i<N;i++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			//방문하지 않은 정점 중 minEdge값이 최소인 정점
			for(int j=1;j<=N;j++) {
				if(!v[j] && min>minEdge[j]) {
					min=minEdge[j];
					minVertex=j;
				}
			}
			
			v[minVertex]=true; //방문처리
			sum+=min; //최소 간선 비용을 누적하여 합산
//			System.out.print(minVertex+" "+Arrays.toString(v)); //방문처리확인;
//			System.out.println("합 : " + sum+" ");
			
			if(cnt++==N-1) break;
			for(int[] j:g[minVertex]) { 
			//선택된 정점과 연결된 선 중 최소 가중치 간선을 선택하여 minEdge배열 업데이트
				if(!v[j[0]] && minEdge[j[0]]>j[1]) {
					minEdge[j[0]]=j[1]; 
				}
			}
//			System.out.println(Arrays.toString(minEdge));
			
		}
		System.out.println(sum); //가중치 합 출력->모든 컴퓨터를 연결하는데 필요한 최소비용
		br.close();

	}

}
/*
0:
1:[2, 5][3, 4]
2:[1, 5][3, 2][4, 7]
3:[1, 4][2, 2][4, 6][5, 11]
4:[2, 7][3, 6][5, 3][6, 8]
5:[3, 11][4, 3][6, 8]
6:[4, 8][5, 8]


1 [false, true, false, false, false, false, false]합 : 0 
3 [false, true, false, true, false, false, false]합 : 4 
2 [false, true, true, true, false, false, false]합 : 6 
4 [false, true, true, true, true, false, false]합 : 12 
5 [false, true, true, true, true, true, false]합 : 15 
6 [false, true, true, true, true, true, true]합 : 23 


[2147483647, 0, 5, 4, 2147483647, 2147483647, 2147483647]
[2147483647, 0, 2, 4, 6, 11, 2147483647]
[2147483647, 0, 2, 4, 6, 11, 2147483647]
[2147483647, 0, 2, 4, 6, 3, 8]
[2147483647, 0, 2, 4, 6, 3, 8]
 */
