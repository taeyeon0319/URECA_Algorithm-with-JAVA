package baekjoon;
import java.io.*;
import java.util.*;

public class Main_20540 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Character[] a = {'E', 'S', 'T', 'J'};
		Character[] b = {'I', 'N', 'F', 'P'};
		
		String yg = br.readLine();
		for(int i=0;i<4;i++) {
			char y = yg.charAt(i);
			if(a[i].equals(y)) {
				System.out.print(b[i]);
			}else {
				System.out.print(a[i]);
			}
		}
	}

}

