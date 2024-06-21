package a0621.combsubs;

import java.io.*;
import java.util.*;

public class Main_bj_2961_도영이가만든맛있는음식_김태연 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	
	static int N; //재료의 개수
	static int[][] taste; //2차원 배열 - 재료의 신맛-쓴맛 저장
	static ArrayList<Integer> resultList = new ArrayList<>(); //모든 경우의 신맛과 쓴맛의 차이 저장리스트
	
	
	static void subs(int cnt, int S, int B) {
		if(cnt==N) {
			resultList.add(Math.abs(S-B));
			return;
		}
		subs(cnt+1, S*taste[cnt][0], B+taste[cnt][1]);//선택
		subs(cnt+1, S, B);//비선택
	}
	
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); //재료의 개수 입력
		taste = new int[N][2]; //맛 배열
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken()); //S : 신맛
			taste[i][1] = Integer.parseInt(st.nextToken()); //B : 쓴맛
		}

		subs(0, 1, 0); //taste의 인덱스, S값(곱해야하므로 초기값 1), B값(더하므로 초기값 0)
		
		
		resultList.remove(resultList.size()-1); //재료를 아예 넣지 않는 경우의 결과값을 빼줌(최소 한개 이상의 재료를 선택해야함)
		resultList.sort(new Comparator<Integer>() { //오름차순 정렬
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
        });
		System.out.println(resultList.get(0)); //차이가 가장 작은 요리의 차이 출력
        br.close();  
	}
}
