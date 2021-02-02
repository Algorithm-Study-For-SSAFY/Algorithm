import java.util.Scanner;

public class boj1024 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L =  sc.nextInt();
		// 합이 N이면서, 길이가 최소 L이상인 연속된 정수 리스트
		boolean flag = false;
		for(int i=L; i<=100; i++) {
			// 최소값 x라고 생각하면 , x , x+1, x+2 ,,, x + i-1 이 수열임
			// N = i * x + (i-1)(i)/2  일듯
			// N/i - (i-1)/2 = x;
			// {2N - (i-1)i} / 2i = x;
			// x는 음이되면 안되므로 , 양수조건 필요!!!
			if( (2*N >= (i-1)*i) && (2*N - (i-1)*i) % (2*i) == 0) {
				int x = (2*N - (i-1)*i) /  (2*i);
				for(int j=0; j<i; j++) {
					System.out.print(x+j + " ");
				}
				flag = true;
				break;
			}//if
		}//for
		//길이가 100보다 크거나, 수열이 없는 경우
		if(!flag) System.out.println(-1);
	}
}
