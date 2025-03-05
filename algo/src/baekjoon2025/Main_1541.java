package baekjoon2025;

import java.io.*;
import java.util.*;

public class Main_1541 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] snum = s.split("-");
		
		
		int result = 0;
		boolean first = true;
		
		for(String n : snum) {
			int sum = 0;
			String[] nums = n.split("\\+");
			for(String num : nums) {
				sum+= Integer.parseInt(num);
			}
			if(first) {
				result = sum;
				first = false;
			}else {
				result -= sum;
			}
		}
		System.out.println(result);
		
		
		br.close();
	}
}
