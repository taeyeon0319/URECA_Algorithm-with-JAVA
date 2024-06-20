package a0619.recu;

import java.io.*;
import java.util.*;

public class Hanoi {
	private static void hanoi(int n, int from, int mid, int to) {
		if(n==0) return;
		hanoi(n-1, from, to, mid);
		System.out.println(n+"번째 원반이 "+from+"번 기둥에서 "+to+"번 기둥으로 이동합니다.");
		hanoi(n-1, mid, from, to);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 3;//sc.nextInt(); //원반개수
		hanoi(N, 1, 2, 3);
		sc.close();
	}
}
