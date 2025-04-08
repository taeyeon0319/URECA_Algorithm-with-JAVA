package baekjoon2025;

import java.io.*;
import java.util.*;

/* 첫번째 방법 - TreeMap사용*/
public class Main_7662 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> numMap = new TreeMap<>();
			
			for(int i=0;i<k;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String di = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				if(di.equals("I")) {
					numMap.put(n, numMap.getOrDefault(n, 0)+1);
				}else {
					if(numMap.size() == 0) continue;
					int outnum = n==1? numMap.lastKey():numMap.firstKey();
					if(numMap.put(outnum, numMap.get(outnum)-1)==1) { //!!!!!
						numMap.remove(outnum);
					}
				}
			}
			System.out.println(numMap.size()==0? "EMPTY" : numMap.lastKey()+" "+numMap.firstKey());
		}

		br.close();
	}
}



//
//public class Main_7662 {
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		for(int t=0;t<T;t++) {
//			int k = Integer.parseInt(br.readLine());
//			Map<Integer, Integer> map = new HashMap<>();
//			PriorityQueue<Integer> minQue = new PriorityQueue<>(); //오름차순
//			PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder()); //내림차순
//			for(int i=0;i<k;i++) {
//				StringTokenizer st = new StringTokenizer(br.readLine());
//				String s = st.nextToken();
//				int n = Integer.parseInt(st.nextToken());
//				
//				if(s.equals("I")) {
//					map.put(n, map.getOrDefault(n, 0)+1);
//					minQue.offer(n); //최소값을 빠르게 얻기 위한 우선순위 큐
//					maxQue.offer(n); // 최대값을 빠르게 얻기 위한 우선순위 큐
//				}else {
//					if(map.isEmpty()) continue; //만약 map에 아무것도 없으면 삭제 할 게 없음
//					PriorityQueue<Integer> targetQue = (n==1) ? maxQue:minQue; // 1이면 최대값 삭제(max), -1이면 최소값 삭제(min)
//					removeValid(targetQue, map);
//				}
//			}
//			System.out.println(map.size()==0? "EMPTY" : removeValid(maxQue, map)+" "+
//			(map.size()>0 ? removeValid(minQue, map) : removeValid(maxQue, map)));
//		}
//
//		br.close();
//	}
//
//
//	private static int removeValid(PriorityQueue<Integer> que, Map<Integer, Integer> map) {
//		int num;
//		while(true) {
//			num = que.poll(); //큐에서 하나 꺼냄
//			int cnt = map.getOrDefault(num, 0);
//			if(cnt==0) continue;
//			if(cnt==1) {
//				map.remove(num); //마지막 1개면 아예 제거
//			}else {
//				map.put(num, cnt-1); //그렇지 않으면 개수 감소
//			}
//			break;
//		}
//		return num; //꺼낸 값 반환
//		
//	}
//}

