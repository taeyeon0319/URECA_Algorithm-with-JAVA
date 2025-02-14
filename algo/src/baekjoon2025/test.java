package baekjoon2025;

import java.io.*;
import java.util.*;

public class test {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cur = 0;
		
		//삽입
		cur = cur | (1<<3);
		cur = cur | (1<<5);
		System.out.println(Integer.toBinaryString(cur)); //101000
		
		//삭제
		cur = cur & ~(1<<3);
		System.out.println(Integer.toBinaryString(cur)); //100000
		
		//토글
		cur = cur ^ (1<<3);
		System.out.println(Integer.toBinaryString(cur)); //101000
		
		cur = (1<<21) - 1;
		System.out.println(Integer.toBinaryString(cur)); //111111111111111111111
		
		br.close();
	}
}
