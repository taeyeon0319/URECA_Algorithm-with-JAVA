package baekjoon2024;
import java.io.*;
import java.util.*;


public class Main_1043 {
	static int[] parents;
	static List<Integer> knowPeopleList;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //사람의 수
		int M = Integer.parseInt(st.nextToken()); //파티의 수
		
		parents = new int[N+1]; //최상위 부모 
		for(int i=1;i<=N;i++) parents[i] = i;
		
		st = new StringTokenizer(br.readLine());
		int knowNum = Integer.parseInt(st.nextToken()); //비밀을 아는 사람들의 수
		knowPeopleList = new ArrayList<>(); //비밀을 아는 사람들의 리스트
		if(knowNum==0) { //만약 비밀을 아는 사람이 한명도 없으면 모든 파티가 열릴 수 있음.
			System.out.println(M);
			return;
		}else {
			for(int i=0;i<knowNum;i++) {
				knowPeopleList.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		List<Integer>[] partyPeople = new List[M]; //0번째 파티, 1번째 파티 ... M번째 파티
		for(int i=0;i<M;i++) partyPeople[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int partyNum = Integer.parseInt(st.nextToken());
			
			int x = Integer.parseInt(st.nextToken());
			partyPeople[i].add(x); //i번 파티에 참여하는 x
			for(int j=1;j<partyNum;j++) {
				int y = Integer.parseInt(st.nextToken());
				union(x, y); //x와 y가 같은 그룹인 걸 엮기
				partyPeople[i].add(y); //i번 파티에 참여하는 y
			}
			
		}
		
		int result = 0; //비밀이 떠돌지 않는 파티의 개수
		for(int i=0;i<M;i++) {
			boolean partyOK = true; //파티 가능
			for(int p : partyPeople[i]) {
				if(knowPeopleList.contains(find(parents[p]))) {
					partyOK = false; //파티 불가능
					break;
				}
			}
			if(partyOK) {
				result++;
			}
		}
		System.out.println(result);
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

	//부모 노드를 찾는 find
	static int find(int x) {
		if(parents[x]==x)  return x; 
		return find(parents[x]);
	}
}



