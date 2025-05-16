package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1043 {
	static int[] parents;
	static List<Integer> knowPeopleList;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //사람의 수
		int M = Integer.parseInt(st.nextToken()); //파티의 수
		
		//최상위 부모
		parents = new int[N+1];
		for(int i=1;i<=N;i++) { parents[i] = i;};
		
		
		st = new StringTokenizer(br.readLine());
		int know = Integer.parseInt(st.nextToken()); //비밀을 아는 사람의 수
		
		knowPeopleList = new ArrayList<>();
		if(know==0) {
			System.out.println(M);
			return;
		}else {
			for(int i=0;i<know;i++) {
				knowPeopleList.add(Integer.parseInt(st.nextToken()));
			}
		}
		
	
		List<Integer>[] partyPeople = new List[M];
		for(int i=0;i<M;i++) {
			partyPeople[i] = new ArrayList<>();
		}
		
		//파티
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int partyNum = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			partyPeople[i].add(x);
			
			for(int j=1;j<partyNum;j++) {
				int y = Integer.parseInt(st.nextToken());
				union(x, y); //x와 y가 같은 그룹인 걸 엮기 -- 최상위 부모가 같다.
				partyPeople[i].add(y);
			}
			
		}
		
		int result = 0;
		for(int i=0;i<M;i++) {
			boolean partyOK = true; //파티 가능
			for(int p :partyPeople[i]) {
				if(knowPeopleList.contains(find(p))) {
					partyOK = false;
					break;
				}
			}
			if(partyOK) {
				result++;
			}
		}
		System.out.println(result);
		
		br.close();

	}
	
	//합치는 union
	static void union(int x, int y) {
		int px = find(x); //x의 최상위 부모
		int py = find(y); //y의 최상위 부모
		if(knowPeopleList.contains(py)) {
			int tmp = px;
			px = py;
			py = tmp;
		}
		
		parents[py] = px;
	}
	
	//최상위 부모를 찾는 find
	static int find(int x) {
		if(parents[x]==x) return x;
		return find(parents[x]);
	}
}