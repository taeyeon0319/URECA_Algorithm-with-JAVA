package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_30804 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] tanghuru = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			tanghuru[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> countMap = new HashMap<>(); //과일이 2종류 이하인지 확인
		int left=0; //첫번째 과일
		int answer = 0; //과일 개수(최대)
		
		for(int right=0;right<N;right++) {
			countMap.put(tanghuru[right], countMap.getOrDefault(tanghuru[right], 0)+1);
			
			while(countMap.size()>2) {
				countMap.put(tanghuru[left], countMap.get(tanghuru[left])-1);
				if(countMap.get(tanghuru[left])==0) {
					countMap.remove(tanghuru[left]);
				}
				left++;
			}
			answer = Math.max(answer, right-left+1);
			
		}
		System.out.println(answer);
		
		

		br.close();
	}
}

/*
Map<Integer, Integer> map = new HashMap<>(); // 두 종류의 과일을 세기 위한 HashMap
int left = 0; //가장 왼쪽 
int answer = 0; //과일의 개수(최대)

// 과일을 하나씩 모두 순회
for (int right = 0; right < N; right++) {
    // map에 과일 종류 카운트
    // 과일 종류가 있으면 +1, 없으면 추가
    map.put(tanghuru[right], map.getOrDefault(tanghuru[right], 0) + 1);

    // 현재 map 상태 출력
    System.out.println("right=" + right + ", map=" + map);

    // 과일 종류가 2개 초과일 경우, 왼쪽 포인터 이동
    while (map.size() > 2) {
        map.put(tanghuru[left], map.get(tanghuru[left]) - 1);

        // 과일이 0이면 없으니까 지워줌
        if (map.get(tanghuru[left]) == 0) {
            map.remove(tanghuru[left]);
        }

        left++;
        
        // left 이동 후 map 상태 출력
        System.out.println("left 이동 후, left=" + left + ", map=" + map);
    }

    answer = Math.max(answer, right - left + 1);
}

System.out.println(answer);
*/