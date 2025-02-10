package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_2805 {
	static int N, M;
	static int[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //나무의 수
		M = Integer.parseInt(st.nextToken()); //집으로 가져가려고 하는 나무 길이
		tree = new int[N]; // 나무 높이
		st = new StringTokenizer(br.readLine());
		int end = 0;
		for(int i=0;i<N;i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, tree[i]);
		}

		int start = 0;
		int result = 0;
		while(start<=end) {
			long check = 0;
			int mid = (start+end)/2;;
			for(int t : tree) {
				if(t>mid) {
					check += t-mid;
				}
			}
			if(check>=M) {
				result = mid;
				start =mid+1;
			}else {
			    end = mid-1;
			}
		}
		System.out.println(result);
		
	}

}


/*시간초과
public class Main_2805 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //나무의 수
		int M = Integer.parseInt(st.nextToken()); //집으로 가져가려고 하는 나무 길이
		int[] tree = new int[N]; // 나무 높이
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		int max = 0;
		for(int i=0;i<N;i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}
		for(int i=max;i>0;i--) {
			int answer = 0;
			for(int j=0;j<N;j++) {
				answer += (tree[j]>i) ? tree[j]-i : 0;
			}
			if(answer>=M) {
				System.out.println(i);
				break;
			}
		}
		
	}

}
*/
