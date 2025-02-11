package baekjoon2025;
import java.io.*;
import java.util.*;
 
public class Main_11723{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		int set = 0;
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int input = -1;
			
			switch(command) {
			case "add":
				input = Integer.parseInt(st.nextToken());
				set = set | (1 << input); //원소추가
				break;
			case "remove":
				input = Integer.parseInt(st.nextToken());
				set = set & ~(1<<input);
				break;
			case "check":
				input = Integer.parseInt(st.nextToken());
				sb.append(((set & (1<<input))>0) ? "1\n" : "0\n");
				break;
			case "toggle":
				input = Integer.parseInt(st.nextToken());
				set = set ^ (1<<input);
				break;
			case "all":
				set = (1<<21)-1;
				break;
			case "empty":
				set = 0;
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
// HashSet 방식
/*
public class Main_11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int input = -1;
			
			switch(command) {
			case "add":
				set.add(Integer.parseInt(st.nextToken()));
				break;
			case "remove":
				set.remove(Integer.parseInt(st.nextToken()));
				break;
			case "check":
				input = Integer.parseInt(st.nextToken());
				if (set.contains(input)) {
					sb.append(1);
				} else {
					sb.append(0);
				}
				sb.append("\n");
				break;
			case "toggle":
				input = Integer.parseInt(st.nextToken());
				if (set.contains(input)) {
					set.remove(input);
				} else {
					set.add(input);
				}
				break;
			case "all":
				set = new HashSet<>();
				for (int j = 1; j <= 20; j++) {
					set.add(j);
				}
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		System.out.print(sb.toString());
	}
}
*/
