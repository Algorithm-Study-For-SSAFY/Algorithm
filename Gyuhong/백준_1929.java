//import java.util.*;
//
//public class Main {
//
//
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		StringBuilder sb = new StringBuilder();
//		LinkedList<Integer> numList = new LinkedList<Integer>();
//		
//		int M = sc.nextInt();
//		int N = sc.nextInt();
//		
//		for (int i = 2; i <= N; i++) {
//			numList.add(i);
//		}
//				
//		while(numList.size() > 0) {
//			
//			int prime = numList.poll();
//			numList.removeIf(num -> num % prime == 0);
//			
//			if(prime >= M) {
//				sb.append(prime + "\\n");			
//			}	
//		}
//		System.out.println(sb.toString());
//		sc.close();
//	}
//
//
//
//}
//
//====================위 코드는 시간초과=============================

import java.util.*;

public class Main {


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean isPrime[] = new boolean[N+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
			
		for(int prime=2; prime*prime<=N; prime++) {
			if(!isPrime[prime]) continue; 
			
			for(int i=prime; prime*i<=N; i++) {
				isPrime[i*prime] = false;		
			}
			
		}
		
		for(int i=M; i<=N; i++) {
			if(isPrime[i]) {
				sb.append(i + "\\n");
			}
		}
		
		System.out.println(sb.toString());
		sc.close();
	}



}