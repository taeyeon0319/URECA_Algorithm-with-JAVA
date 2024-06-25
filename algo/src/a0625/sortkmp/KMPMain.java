package a0625.sortkmp;

import java.util.*;

public class KMPMain {

	public static void main(String[] args) {
		         //012345678901234567890
		String T="ABCDABCDABDE";
		String P=    "ABCDABD";
		         //0123456
		int[] F=new int[P.length()]; //LPS(Longest Prefix which is also Suffix)
		
		//T = "ABABACA"; //"ABCDABD";
		//P =   "ABABACA"; //"ABCDABD";
		//0 A        0
		//1 AB       0
		//2 ABA      1
		//3 ABAB     2
		//4 ABABA    3
		//5 ABABAC   0
		//6 ABABACA  1
		for(int t=1, p=0;t<P.length();t++) {
			while(p>0 && P.charAt(t)!=P.charAt(p)) p=F[p-1];
			if(P.charAt(t)==P.charAt(p)) F[t]=++p;
		}
		
		System.out.println(Arrays.toString(F));
		
		List<Integer> ans = new ArrayList<>();
		for(int t=0, p=0;t<T.length();t++) {
			while(p>0 && T.charAt(t)!=P.charAt(p)) p=F[p-1];
			if(T.charAt(t)==P.charAt(p)) {
				if(p==P.length()-1) {
					ans.add(t-p);
					p=F[p];
				}else {
					++p;
				}
				
			}
		}
		System.out.println(ans.size());
		System.out.println(ans+"번째 부터 똑같음");
	}

}
