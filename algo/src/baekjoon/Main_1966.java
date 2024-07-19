package baekjoon;
import java.io.*;
import java.util.*;

public class Main_1966 {
	static int N, M;
	static LinkedList<int[]> importance;
	static int count;
	
	private static void countnum(int findnum) {
		int[] num = importance.poll();
		int index = num[0];
		int n = num[1];
		boolean status = true;

		for(int i=0;i<importance.size();i++) {
			if(n<importance.get(i)[1]) {
				status = false;
				break;
			}
		}
		if(!status) {
			importance.offer(new int[] {index, n});
		}else {
			count+=1;
		}

		if(index == findnum) {
			System.out.println(count);
			return;
		}

		countnum(findnum);
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			importance = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				importance.add(new int[] {j, Integer.parseInt(st.nextToken())}); //index, 값
			}
			count = 1;
			countnum(M);
			
//			for(int a[] : importance) {
//				System.out.println(Arrays.toString(a));
//			}
		}
		
	}

}

