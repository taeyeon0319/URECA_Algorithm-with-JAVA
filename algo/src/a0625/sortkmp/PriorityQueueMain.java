package a0625.sortkmp;

import java.util.Comparator;
import java.util.PriorityQueue;

//최소힙
public class PriorityQueueMain {

	static class Car implements Comparable<Car>{
		String name;
		int year;
		Car(String name, int year){
			this.name = name;
			this.year = year;
		}
		@Override
		public String toString() {
			return name+year;
		}
		@Override
		public int compareTo(Car o) {
			return name.compareTo(o.name);
			//return Integer.compare(year, o.year);
		}
	}
	
	
	public static void main(String[] args) {
//		PriorityQueue<Car> pq = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Car> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.year, o2.year));
//		PriorityQueue<Car> pq = new PriorityQueue<>(new Comparator<Car>) {
//			@Override
//			public int compare(Car o1, Car o2) {
//				return -Integer.compare(o1.year, o2.year);
//			}
//		}
		pq.offer(new Car("아반떼", 2015));
		pq.offer(new Car("그랜저", 2007));
		pq.offer(new Car("소나타", 2023));
		pq.offer(new Car("아반떼", 2015));
		pq.offer(new Car("그랜저", 2008));
		pq.offer(new Car("소나타", 2024));
		System.out.println(pq);
		while(!pq.isEmpty()) System.out.println(pq.poll()+"");
		/*
		PriorityQueue<Integer> pq = new PriorityQueue<>(); 
//		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); //역순
//		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2)); //람다
		pq.offer(22);
		pq.offer(11);
		pq.offer(33);
		pq.offer(22);
		pq.offer(11);
		pq.offer(33);
		System.out.println(pq);
		
		while(!pq.isEmpty()) System.out.println(pq.poll() + "");
		System.out.println();
		*/
	}

}
