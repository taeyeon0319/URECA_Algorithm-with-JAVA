package baekjoon2025;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main_18870 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] Xlist = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			Xlist[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> Xset = Arrays.stream(Xlist)
				.distinct() //중복 제거
				.sorted() //정렬
				.boxed()
				.collect(Collectors.toList());
		
		Map<Integer, Integer> indexMap = new HashMap<>(); //리스트값 : 순서(몇번째로 큰 지)
		for(int i=0;i<Xset.size();i++) {
			indexMap.put(Xset.get(i), i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int num:Xlist) {
			sb.append(indexMap.get(num)).append(" ");
		}
		System.out.println(sb.toString());
		br.close();
	}
}

/*
시간초과 -> for문 2개 O(N^2) 

public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int N = Integer.parseInt(br.readLine());
	
	int[] Xlist = new int[N];
	StringTokenizer st = new StringTokenizer(br.readLine());
	for(int i=0;i<N;i++) {
		Xlist[i] = Integer.parseInt(st.nextToken());
	}
	
	List<Integer> Xset = Arrays.stream(Xlist)
			.distinct() //중복 제거
			.sorted() //정렬
			.boxed()
			.collect(Collectors.toList());
	for(int i=0;i<N;i++) {
		int num = Xlist[i];
		int count = 0;
		for(int j=0;j<Xset.size();j++) {
			if(num>Xset.get(j)) {
				count+=1;
			}
		}
		System.out.print(count+" ");
	}

	br.close();
}*/