package a0620.perm;

import java.io.*;
import java.util.*;

public class Main_bj_14888_연산자끼워넣기_김태연 {
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[] a; // 숫자들 저장
	static int[] cal; //연산자 개수 저장
	static String[] calReal;//실제 연산자들 일일히 저장
	static String[] calPerm;//순열로 사용할 연산자 배열
	static boolean[] v; //방문여부 확인
	static ArrayList<Integer> answer = new ArrayList<>(); // 정답 리스트
	
	static void perm(int cnt) {
		if(cnt==N-1) {
			int t = 1;
			int ans = a[0];
			for(String c : calPerm) {
				//System.out.print(c+" ");
				if (c=="+") ans += a[t];
				else if(c=="-") ans -= a[t];
				else if(c=="*") ans *= a[t];
				else ans /=a[t];
				t+=1;
			}
			answer.add(ans); //정답값을 정답 리스트에 저장
			return;
		}
		for(int i=0;i<N-1;i++) {
			if (v[i]) continue;
			v[i]=true;
			calPerm[cnt] = calReal[i];
			perm(cnt+1);
			v[i]=false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		a = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		
		//+, -, x, /
		cal = new int[4];
		calReal = new String[N-1];
		calPerm = new String[calReal.length];
		v = new boolean[N-1];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			cal[i]=Integer.parseInt(st.nextToken());
		}
		int k = 0;
		String[] calculation = {"+", "-", "*", "/"};
		for(int i=0;i<4;i++) {
			while (cal[i]>0) {
				calReal[k]=calculation[i];
				k++;
				cal[i]--;
			}
		}
		
		
		
        perm(0);
        long max = -10000000000L;
        long min = 10000000000L;
        
        for(int i=0;i<answer.size();i++) {
        	if (max<answer.get(i)) max=answer.get(i);
        	if (min>answer.get(i)) min=answer.get(i);
        }
        System.out.println(max);
        System.out.println(min);
        br.close();  
	}
}
