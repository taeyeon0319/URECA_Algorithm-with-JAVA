package a0621.combsubs;
//부분집합
import java.io.*;
import java.util.*;

public class SubsMain {

	static int N=4, /*R=3,*/ C=0; //부분집합에는 R이 필요 없음. -- 2^N
	static int[] a= {1, 2, 3, 4}/*, b=new int[R] */;
	//static boolean[] v=new boolean[N];
	
	//파라미터 1개 버전
	/*static void subs(int cnt) { 
		if(cnt==N) {
			//System.out.println(Arrays.toString(v)); 
			C++;
			for(int i=0;i<N;i++) {
				System.out.print(v[i]? a[i]+" ":"x"+" ");
			}
			System.out.println();
			return;
		}

		v[cnt]=true;//선택
		subs(cnt+1);
			
		v[cnt]=false;//비선택
		subs(cnt+1);
	}*/
	
	//파라미터2개 버전 : 이걸 추천함
	static void subs(int cnt, String str) { 
		if(cnt==N) {
			C++;
			System.out.println(str);
			return;
		}
		subs(cnt+1, str+a[cnt]);//선택
		subs(cnt+1, str+'x');//비선택
	}
	
	
	public static void main(String[] args) throws Exception{
		C = 0;
		//subs(0);
		subs(0, "");
		System.out.println(C);
	}	
}
