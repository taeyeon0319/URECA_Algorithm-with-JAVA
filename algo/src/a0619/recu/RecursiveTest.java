package a0619.recu;

public class RecursiveTest {
	//팩토리얼
	static int fac(int n) {
		if(n==1 || n==0) {
			return 1;
		}else {
			return n*fac(n-1);
		}
	}
	
	//피보나치
	static int fibo(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		
		return fibo(n-1)+fibo(n-2);
	}
	
	//recursive
	static void recur(int n) {
		if(n<=0) return;
		recur(n-1);
		System.out.println(n+" ");
		recur(n-2);
	}
	
	public static void main(String[] args) {
		System.out.println(fac(5));
		System.out.println(fibo(7));//0 1 1 2 3 5 8 13
		
		recur(4);
	}

	
}
