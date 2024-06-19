package a0619.recu;

//기본세팅1
import java.io.*; 
import java.util.*;

public class BinarySearchTest {

	public static void main(String[] args) throws Exception /*기본세팅2*/{
		System.setIn(new FileInputStream("res/input_bj_0000.txt"));
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		//출력(멀티스레드에는 Buffer사용)
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] a=new int[N];
			//15 27 39 77 92 108 121 이런식으로 한줄에 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				a[i]=Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(a));
			//2차원 배열일때 ↓
//			for(int[] a:aa) System.out.println(Arrays.toString(a)); System.out.println();
			int key = Integer.parseInt(br.readLine());
			int ans=Arrays.binarySearch(a, key);
			sb.append("#").append(tc).append(" 인덱스 : ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
