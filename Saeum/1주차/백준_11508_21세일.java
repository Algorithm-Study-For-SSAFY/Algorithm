import java.util.Arrays;
import java.util.Scanner;

public class 백준_11508_21세일 {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt(); //유제품의 수 
			
			int[] res = new int[N];
			int count = 0;
			int sum = 0;
			
			for(int i=0; i<res.length; i++) { //유제품의 가격 
				res[i] = sc.nextInt();
			}
			
			Arrays.sort(res); // 오름차순정렬
			
			for(int i = res.length-1; i>=0; i--) { // 뒤에서부터
				count++;
				if(count%3!=0) { //3묶음에서 최솟값이 아닌 경우
					sum += res[i];
				}
			}	
			System.out.println(sum);
	}
}
 
