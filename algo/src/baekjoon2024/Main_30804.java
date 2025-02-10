package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_30804{
	static int N;
	static int[] S;
	static int[] kindarr = new int[10];

	public static int tanghuru(int start, int end, int cnt, int kind, int max) { //시작, 끝, 과일 개수, 과일 종류 개수, 최댓값
		//end가 배열의 크기보다 크거나 같으면 최대 길이 반환
		if(end>=N) {
			return max;
		}
		
		//현재 과일이 첨 보는 과일이면 
		if(kindarr[S[end]] == 0) {
			kind+=1;
		}
		
		cnt+=1;
		kindarr[S[end]]+=1;
		
		if(kind>2) {
			if(--kindarr[S[start]]==0) {
				kind-=1;
			}
			cnt-=1;
			start+=1;
		}
		
		max = Math.max(max, cnt);
		return tanghuru(start, end+1, cnt, kind, max);
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		S = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(tanghuru(0, 0, 0, 0, 0));
	}

}

