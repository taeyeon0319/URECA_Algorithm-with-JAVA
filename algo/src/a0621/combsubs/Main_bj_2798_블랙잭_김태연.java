package a0621.combsubs;

import java.io.*;
import java.util.*;

public class Main_bj_2798_블랙잭_김태연 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int M;
	
	static int[] cards; 
	static int[] b; 
	
	static ArrayList<Integer> sumArray = new ArrayList<>();
	static int sum;
	
	static void comb(int cnt, int start) {
		sum=0;
		if(cnt==3) {
			for(int i=0;i<3;i++) {
				sum += b[i];
			}
			sumArray.add(sum);
			return;
		}
		for(int i=start;i<N;i++) {
			b[cnt]=cards[i];
			comb(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //카드개수
		M = Integer.parseInt(st.nextToken()); //제한 합
		
		cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			cards[i]=Integer.parseInt(st.nextToken());
		}
		b = new int[3];

        comb(0, 0);
        
        sumArray.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return -(o1-o2);
			}
        });
        
        //sumArray에서 M보다 큰 값을 제거하는 방법
        for (Iterator<Integer> iterator = sumArray.iterator(); iterator.hasNext();) {
            int value = iterator.next();
            if (value > M) {
                iterator.remove();
            }
        }
        sb.append(sumArray.get(0));
        System.out.println(sb.toString());
        br.close();  
	}

}
