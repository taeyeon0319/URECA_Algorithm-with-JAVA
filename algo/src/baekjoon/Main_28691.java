package baekjoon;
import java.io.*;
import java.util.*;

public class Main_28691 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] clubs = {"MatKor", "WiCys", "CyKor", "AlKor", "$clear"};
		for(String c : clubs) {
			if(c.startsWith(s)) {
				System.out.println(c);
			}
		}

		
		br.close();
	}
}

