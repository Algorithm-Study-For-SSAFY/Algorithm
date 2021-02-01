import java.util.*;

public class Main {


	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
	
		int X = sc.nextInt();
		int Y = sc.nextInt();
	
		int l = 1;
		int r = X;
	
		if (!isChanged(X, Y, X)) {
			System.out.println(-1);
			sc.close();
			return;
		}
	
		while (l < r) {
			int mid = (l + r) / 2;
	
			if (isChanged(X, Y, mid)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
	
		System.out.println(r);
	
		sc.close();
	}

	static boolean isChanged(int X, int Y, int n) {
		
		return (long) Y * 100 / X == (long) (Y + n) * 100 / (X + n) ? false : true;
		//long으로 type casting 하지 않으면 100을 곱하는 과정에서 overflow 가능성

	}

}