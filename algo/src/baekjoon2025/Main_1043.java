package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1043 {
	static int N, M;
	static int[] parentList;
	static List<Integer> knowpeoplelist;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //사람의 수
		M = Integer.parseInt(st.nextToken()); //파티의 수
		
		parentList = new int[N+1]; //최상위 부모 리스트
		for(int i=1;i<=N;i++) {
			parentList[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int knowpeoplecnt = Integer.parseInt(st.nextToken()); //진실을 아는 사람의 수
		knowpeoplelist = new ArrayList<>(); //진실을 아는 사람들의 번호
		
		if (knowpeoplecnt==0){
			System.out.println(M);
			return;
		}else {
			for(int i=0;i<knowpeoplecnt;i++) {
				knowpeoplelist.add(Integer.parseInt(st.nextToken()));
			}
		}
		List<Integer>[] partypeople = new List[M];
		for(int i=0;i<M;i++) {
			partypeople[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int partypeoplecnt = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			partypeople[i].add(x);
			for(int j=0;j<partypeoplecnt-1;j++) {
				int y = Integer.parseInt(st.nextToken());
				union(x, y);
				partypeople[i].add(y);
			}
		}
		
		int result = 0;
		for(int i=0;i<M;i++) {
			boolean nobody = true;
			for(int p : partypeople[i]) {
				if(knowpeoplelist.contains(findParent(p))) {
					nobody = false;
					break;
				}
			}
			if(nobody) {
				result+=1;
			}
		}
		System.out.println(result);

		br.close();

	}

	//하나의 그룹으로 만들어 최상위 부모를 일치시켜라
	private static void union(int x, int y) {
		int parent_x = findParent(x);
		int parent_y = findParent(y);
		if(knowpeoplelist.contains(parent_y)){
			int tmp = parent_x;
			parent_x = parent_y;
			parent_y = tmp;
		}
		parentList[parent_y] = parent_x;
		
	}

	//최상위 부모를 찾아라
	private static int findParent(int x) {
		if(x==parentList[x]) {
			return x;
		}else {
			return findParent(parentList[x]);
		}
	}
	
	
}

