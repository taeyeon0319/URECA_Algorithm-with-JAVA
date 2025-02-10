package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_3047 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] ABC = new int[3];
		for(int i=0;i<3;i++) {
			ABC[i] =Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ABC);
		String s = br.readLine();
		for(char ss : s.toCharArray()) {
			System.out.print(ABC[ss-'A']+" ");
		}
	}

}
