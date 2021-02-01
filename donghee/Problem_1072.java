import java.util.Scanner;

public class Problem_1072 {
	//**변수 범위 주의
	static long X, Y;
	static long Z;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		X=sc.nextInt();
		Y=sc.nextInt();
		//Z= 승률
		Z=(Y*100)/X;
		
		//절대 변하지 않는 경우, 확률 99이상
		if(Z>=99) {
			System.out.println("-1");
			return;
		}
		//변하는 경우
		long first=0; long last= 1000000000;
		//이분탐색으로 해결하기
		while(first<=last) {
			long mid=(first+last)/2;
			//Z보다 값이크면, 범위 좁혀서
			if(Z<(Y+mid)*100/(X+mid)) {
				last=mid-1;
			}
			//Z가 더 크면, 
			else {
				first=mid+1;
			}
			
		}
		System.out.println(first);
	}
}
