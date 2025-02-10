package baekjoon2024;
import java.io.*;

public class Main_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        
        int result = 0;
        int count = 0; //IOI 개수세기
        
        for(int i=1;i<M-1;i++) {
        	if(s[i-1]=='I' && s[i]=='O' && s[i+1]=='I') {
        		count+=1;
        		if(count==N) {
        			result+=1;
        			count--;
        		}
        		i++;
        	}else {
        		count=0;
        	}
        }
        System.out.println(result);
    }
}


/*
 public class Main_5525 {
	static int N, M;
	static String[] S;
	static String s;
	static int result;
	
	public static void check(int index, int count, String IO) {
		if(!S[index].equals(IO)) {
			return;
		}
		
		if(count == N*2+1) {
			result+=1;
			return;
		}
		if(IO.equals("I")) {
			check(index+1, count+1, "O");
		}else {
			check(index+1, count+1, "I");
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = new String[M];
		s = br.readLine();
		for(int i=0;i<M;i++) {
			S[i] = Character.toString(s.charAt(i));
		}
		
		for(int i=0;i<S.length-N*2-1;i++) {
			check(i, 1, "I");
		}
		System.out.println(result);
	}

}
 */ 
