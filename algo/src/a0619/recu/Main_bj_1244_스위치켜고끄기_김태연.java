package a0619.recu;
//실패!

import java.io.*;
import java.util.*;

public class Main_bj_1244_스위치켜고끄기_김태연 {


	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_bj_1244.txt"));
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int[] S = new int[N];
		for(int i=0;i<N;i++) {
			S[i]=Integer.parseInt(st.nextToken());
		}
		
		int T = Integer.parseInt(br.readLine());
		
		int[][] Student = new int[T][2];
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			Student[i][0]=Integer.parseInt(st.nextToken());
			Student[i][1]=Integer.parseInt(st.nextToken());
		}
		
		//처리
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			int sex = Student[i][0];
			int c = Student[i][1];
			
			boolean status = true;
			if (sex==1) { //남자일때
				for(int j=c;j<N;j++) {
					if(j%c==0) {
						S[j-1]=(S[j-1]+1)%2;
					}
				}
			}else { //여자일때
				S[c] = S[c]==0? 1:0;
				if(c!=)
				
				int count = 1;
				for(int j=1;j<=N/2;j++) {
					if(c-j-1<0 ||c+j-1>=N) break;
					if(S[c-j-1]==S[c+j-1]) {
						S[c-j-1] = S[c-j-1]==0? 1 : 0;
						S[c+j-1] = S[c+j-1]==0? 1 : 0;
					}else
						break;
				}
			}//sb.append(sex).append(c).append("\n");
		}
		
		//출력
		for (int i = 0; i < N; i++) {
            sb.append(S[i]);
            if (i < S.length - 1) {
                sb.append(" "); // 마지막 요소 뒤에는 공백 추가하지 않음
            }
        }
		System.out.println(sb.toString());
	
		
        br.close();  
	}

}
