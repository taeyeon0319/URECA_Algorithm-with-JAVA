package a0620.perm;
//순열
//여기서부터 암기!
import java.io.*;
import java.util.*;

public class PermMain {

	static int N=4, R=3, C=0; // 4P3 = 4x3x2 = 4!/(4-3)!
	static int[] a= {1, 2, 3, 4}, b=new int[R]; //a에서 뽑아서 b배열에 넣을 거임
	static boolean[] v=new boolean[N]; //방문처리하는 visited배열
	
	static void perm(int cnt) { //cnt는 b의 인덱스
		if(cnt==R) {
			System.out.println(Arrays.toString(b)); C++;
			return;
		}
		for(int i =0;i<N;i++) {
			if(v[i]) continue;
			v[i]=true;
			b[cnt]=a[i];
			perm(cnt+1);
			v[i]=false;
			
			/*중복순열(방문유무를 체크할 필요 X)
			//if(v[i]) continue;
			//v[i]=true;
			b[cnt]=a[i];
			perm(cnt+1);
			//v[i]=false;*/
		}
	}
	
	public static void main(String[] args) throws Exception{
		C = 0;
		perm(0);
		System.out.println(C);
	}	
}
