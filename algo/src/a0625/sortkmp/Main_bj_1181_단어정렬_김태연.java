package a0625.sortkmp;

import java.io.*;
import java.util.*;

public class Main_bj_1181_단어정렬_김태연 {
	static int N;
	static String[] words;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		words = new String[N];
		
		for(int i=0;i<N;i++) {
			words[i]=br.readLine();
		}
		
		//중복제거
//		HashSet<String> hashSet = new HashSet<>(Arrays.asList(words)); //배열 -> 리스트 -> set
//		String[] result = hashSet.toArray(new String[0]); //set -> 배열
		

		//정렬
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length()==o2.length()) return o1.compareTo(o2);
				return o1.length()-o2.length();
			}
		});
		System.out.println(words[0]);
		for(int i=1;i<words.length;i++) {
			if (!words[i].equals(words[i-1])) System.out.println(words[i]);
		}
//		for(String a:result) System.out.println(a);
		br.close();
	}

}
