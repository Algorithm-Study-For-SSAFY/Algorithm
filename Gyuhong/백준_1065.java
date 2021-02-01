import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int answer = 0;
		
		for(int i=1; i<=n; i++) {
			if(isHan(i)) answer++; 
		}
		
		System.out.println(answer);
		
		sc.close();
	}
	
	static boolean isHan(int n) {
		
		if(n<100) return true;
		//100 미만에서는 항상 등차수열을 이룬다.
	
		int i = n%10;
		n /= 10;
		int j = n% 10;
		n/= 10;
		int distance = j-i; 
		//뒤의 두 자리를 각각 i와 j에 저장
		
		while(n>0) {
			i = j;
			j = n% 10;
			n /= 10;
			if(j-i != distance) return false;
		}
		
		
		return true;
	}



}

