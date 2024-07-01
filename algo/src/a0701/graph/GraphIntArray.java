package a0701.graph;

import java.io.*;
import java.util.*;

public class GraphIntArray {

	public static void main(String[] args) throws Exception{
		//메모리 2048 기준
		//int[] a = new int[1_065_877_500]; //ok
		//int[] a = new int[1_065_877_501]; //OutOfMemoryError
		int[][] a = new int[32_542][32_542]; //ok
		//int[][] a = new int[32_543][32_543];//OutOfMemoryError
		System.out.println(a);
		System.out.println();
		
		int[] ia =new int[3];
		ia[0] = 'A';
		System.out.println(Arrays.toString(ia));
		System.out.println();
		
		List<Integer>[] la = new List[3]; //new List<>[3]; 이렇게 하면 안됨.
		System.out.println(Arrays.toString(la));
		
		for(int i=0;i<la.length;i++) la[i] = new ArrayList<>(); //이렇게 해야 NullPointerException이 안생김
		la[0].add(123); //NullPointerException
		System.out.println(Arrays.toString(la));

	}

}
