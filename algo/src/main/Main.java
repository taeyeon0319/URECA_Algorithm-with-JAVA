package main;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		  String[] products = {
				  "sofa red long",
		          "blanket blue long",
		          "towel red",
		          "mattress long",
		          "curtain blue long cheap"
		  };
		  String[] purchased = {
		          "towel",
		          "mattress",
		          "curtain"
		  };

		  System.out.println(selectProduct(products, purchased));
	}
	public static String selectProduct(String[] products, String[] purchased) {
		
		Map<String, Integer> productCount = new HashMap<>();
		Set<String> purchasedSet = new HashSet<>(Arrays.asList(purchased)); ///!!!
		for(String p : products) {
			String[] pp = p.split(" ");
			for(int i=1;i<pp.length;i++) {
				if(purchasedSet.contains(pp[0])) { ///!!!
					productCount.put(pp[i], productCount.getOrDefault(pp[i], 0)+1);
				}	
			}
		}
		
//		System.out.println(productCount);
		
		int maxScore = -1;
		String result = "";
		for(String p : products) {
			String[] pp = p.split(" ");
			if(purchasedSet.contains(pp[0])) continue;
			
			int score = 0;
			for(int i=1;i<pp.length;i++) {
				score+=productCount.getOrDefault(pp[i], 0);
			}
//			System.out.println(pp[0]+" "+score);
			
			if(score > maxScore || (score==maxScore && pp[0].compareTo(result)<0)) { //!!!!!
				maxScore = score;
				result = pp[0];
			}
		}
		
		
		return result;
	}
}
