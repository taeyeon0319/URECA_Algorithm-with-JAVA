package a0619.recu;

import java.io.*;
import java.util.*;

public class Main_bj_1931_회의실배정_김태연 {
	// 서로 겹치지 않는 활동에 대해 종료시간이 빠르면 더 많은 활동을 선택할 수 있는 시간이 많아진다. 

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1931.txt"));
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		//회의 수 입력
        int N = Integer.parseInt(br.readLine());
        
        // 회의 정보를 담을 배열
        int[][] meetings = new int[N][2];
        
        // 회의 정보 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }
        
        // 출력
        StringBuilder sb = new StringBuilder();
        
        int answer = 0;
        int e = 0;
        
        //sort 
        Arrays.sort(meetings, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1]==o2[1]) return o1[0]-o2[0]; //끝나는 시간이 같으면 시작 시간으로 정렬
				return o1[1]-o2[1]; // 끝나는 시간 오름차순으로 정렬
			}
        });
        
        // 회의 정보 출력
        for (int i = 0; i < N; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            if (start>=e) {
            	answer+=1;
            	e=end;
            }
           sb.append(start).append(end).append("\n");
        }
        sb.append(answer);
        // 결과 출력
        System.out.println(sb.toString());
        
        br.close();  
	}

}
