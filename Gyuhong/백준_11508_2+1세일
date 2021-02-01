import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Integer[] milk = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			milk[i] = Integer.parseInt(br.readLine());
		}
		
		// 내림차 순으로 정렬
		Arrays.sort(milk, (o1,o2) -> o2-o1);
		
		int answer=0;
		
		for (int i = 0; i < milk.length; i++) {
			
			// 3의 배수 번째 유제품은 공짜
			if((i+1)%3 == 0) continue;
			
			answer += milk[i];
		}
		
		System.out.println(answer);
	}
	
	
}
