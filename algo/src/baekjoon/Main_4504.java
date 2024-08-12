package baekjoon;
import java.io.*;
import java.util.*;

public class Main_4504 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while(true) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				break;
			}else {
				if(num%n==0) {
					System.out.println(num+" is a multiple of "+n+".");
				}else {
					System.out.println(num+" is NOT a multiple of "+n+".");
				}
			}
		}
		
	}

}

