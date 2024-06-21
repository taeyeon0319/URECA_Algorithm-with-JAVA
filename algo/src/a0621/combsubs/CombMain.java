package a0621.combsubs;
//조합
//여기서부터 암기!
import java.io.*;
import java.util.*;

public class CombMain {

	static int N=4, R=3, C=0; // 3C2 = 3P2/2! = 6/2 =3 => n!/(n-r)!/r!
	static int[] a= {1, 2, 3, 4}, b=new int[R]; //a에서 뽑아서 b배열에 넣을 거임
	//static boolean[] v=new boolean[N]; //combination은 방문처리하는 visited배열이 필요가 읎다!
	
	static void comb(int cnt, int start) { //cnt는 b의 인덱스
		if(cnt==R) {
			System.out.println(Arrays.toString(b)); C++;
			return;
		}
		for(int i =start;i<N;i++) {
			//if(v[i]) continue;
			//v[i]=true;
			b[cnt]=a[i];
			comb(cnt+1, i+1); //시작 위치보다 더 높은 숫자를 뽑는다. comb(cnt+1, i)는 중복조합임.
			//v[i]=false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		C = 0;
		comb(0, 0);
		System.out.println(C);
	}	
}
