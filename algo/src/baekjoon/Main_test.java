package baekjoon;
import java.io.*;
import java.util.*;


public class Main_test {
	public static void main(String[] args) throws Exception {
		int[] num = {1, 5, 3, 4, 2};
		Integer[] num2 = Arrays.stream(num).boxed().toArray(Integer[]::new);
		Arrays.sort(num2, Collections.reverseOrder());
		System.out.println(Arrays.toString(num2));
		
//		List<Integer> num2 = new ArrayList<>();
//		num2.add(1);
//		num2.add(5);
//		num2.add(3);
//		num2.add(4);
//		num2.add(2);
//		num2.sort(Comparator.naturalOrder());
//		System.out.println(num2);
	}
	

}



