package a0625.sortkmp;

import java.io.*;
import java.util.*;

public class Main_bj_11650_좌표정렬하기_김태연 {
	static int N;
	static int[][] dots;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		dots = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			dots[i][0] = Integer.parseInt(st.nextToken());
			dots[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(dots, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]); // y 좌표로 비교
                }
                return Integer.compare(o1[0], o2[0]); // x 좌표로 비교
            }
        });
		
		//람다식
//		Arrays.sort(dots, (o1, o2) -> {
//			if(o1[0]==o2[0]) {
//				return o1[1]-o2[1];
//			}else {
//				return o1[0]-o2[0];
//			}
//		});
		
		for(int[] a:dots) System.out.println(a[0]+" "+a[1]);
	}

}
