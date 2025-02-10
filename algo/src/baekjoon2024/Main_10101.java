package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_10101 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		if(A+B+C == 180) {
			if(A==B && B==C) {
				System.out.println("Equilateral");
			}else if(A==B || B==C || C==A) {
				System.out.println("Isosceles");
			}else {
				System.out.println("Scalene");
			}
		}else {
			System.out.println("Error");
		}
		
	}

}
