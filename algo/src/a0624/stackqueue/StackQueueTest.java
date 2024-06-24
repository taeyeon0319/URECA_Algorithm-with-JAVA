package a0624.stackqueue;

import java.util.*;

public class StackQueueTest {

	public static void main(String[] args) {
//		Queue<String> queue = new LinkedList<>();
		ArrayDeque<String> queue = new ArrayDeque<>();
		queue.offer("카리나"); // 큐에 값을 넣을 때
		queue.offer("지젤"); 
		queue.offer("윈터"); 
		queue.offer("닝닝");
		System.out.println(queue);
		System.out.println(queue.peek()+" "+queue.size()); //가장 꼭대기값 출력 -- FIFO
		System.out.println(queue.poll()+" "+queue.size()); //큐에 값 삭제 -- FIFO
		System.out.println(queue.poll()+" "+queue.size()); 
		System.out.println(queue.isEmpty()); //큐에 값이 있니 없니?
		
		System.out.println();
		
		//Stack<String> stack = new Stack<>();
		ArrayDeque<String> stack = new ArrayDeque<>(); //스택보다 이거 쓰기!
		stack.push("카리나"); //스택에 값을 넣을 때
		stack.push("지젤");
		stack.push("윈터");
		stack.push("닝닝");
		System.out.println(stack);
		System.out.println(stack.peek()+" "+stack.size()); //가장 꼭대기값 출력 -- LIFO
		System.out.println(stack.pop()+" "+stack.size()); //스택에 값 삭제 - LIFO
		System.out.println(stack.pop()+" "+stack.size()); 
		System.out.println(stack.isEmpty()); //스택에 값이 있니 없니?
		
	
		

	}

}
