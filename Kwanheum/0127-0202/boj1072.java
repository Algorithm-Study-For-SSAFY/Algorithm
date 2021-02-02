import java.util.Scanner;

public class boj1072 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long X, Y;
		X = sc.nextLong();
		Y = sc.nextLong();
		int first_Z =  (int) ((double) Y * 100 / X );
		
		//승률이 99퍼센트라면 절대 변하지 않아 ( 100퍼로 올라가는게 불가!)
		if( first_Z >= 99) {
			System.out.println(-1);
			return;
		}
		// Y <= X <=10억,, 더 해야하는 판수가 10억을 넘어가면? 오버플로우날수도 
				/*해당 코드로는 시간초과 발생
				 * long cnt = 0;
				int Z;
				while(true) {
					cnt++;
					Z = (int) (((double) Y + cnt) * 100 / (X+cnt) );
					if(Z != first_Z) {
						System.out.println(cnt);
						return;
					}
				}*/
				
				// 시간초과를 극복하기 위해 이분탐색 적용
		long first = 0;
		long last = Long.MAX_VALUE;
		long mid = 0;
		int Z;
		while(first <= last) {
			//long mid = (first + last) / 2; //단순 더해서 나누기하면 overflow 가능성
			mid = (last-first)/2 + first;
			Z = (int) (((double) Y + mid) * 100 / (X+mid) );
			if(Z > first_Z) {
				last = mid-1;
			}
			else {
				first = mid+1; 
			}
		}
		System.out.println(first);
		
		
	}//main
}
