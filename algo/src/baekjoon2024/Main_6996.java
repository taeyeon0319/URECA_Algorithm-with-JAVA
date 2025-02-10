package baekjoon2024;
import java.io.*;
import java.util.*;

public class Main_6996 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			boolean check = true;
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			char[] achar = new char[a.length()];
			for(int j=0;j<a.length();j++) {
				achar[j] = a.charAt(j);
			}
			String b = st.nextToken();
			char[] bchar = new char[b.length()];
			for(int j=0;j<b.length();j++) {
				bchar[j] = b.charAt(j);
			}
			
			if(a.length()!=b.length()) {
				check=false;
			}else {
				Arrays.sort(achar);
				Arrays.sort(bchar);
				
				for(int j=0;j<a.length();j++) {
					if(achar[j]!=bchar[j]) {
						check=false;
					}
				}				
			}
			if(!check) {
				System.out.println(a+" & "+b+" are NOT anagrams.");
			}else {
				System.out.println(a+" & "+b+" are anagrams.");
			}
		
		}
		br.close();
	}
}

