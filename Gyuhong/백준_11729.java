import java.util.*;

public class Main {

	
	static StringBuilder sb;
	static int answer;
	
	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int N = sc.nextInt();
		answer = 0;
		
		go(1,3,2,N);
		
		System.out.println(answer);
		System.out.println(sb.toString());
		
		sc.close();
	}
	
	// N 원판이 1->3 으로 이동하고 싶으면 1부터 N-1원판이 2에 있어야 한다.
	// K 원판을 1에서 3으로 이동 시키고 싶으면 K-1 원판은 2로 이동해야한다.
	// K-1 원판을 1에서 2로 이동 시키고 싶으면 K-2 원판은 3으로 이동해야한다.
	// K 원판이 1에서 3으로 이동 되었다면 K-1 원판은 2에서 3으로 이동되어야 한다.
	// K-1 원판이 2에서 3으로 이동 되었다면 K-2 원판은 1에서 3으로 이동되어야 한다.
	
	static void go(int from, int to, int not, int num) {
		
		if(num == 1) {
			sb.append(from + " " + to + "\\n");
			answer++;
			return;
		}
		
		go(from, not, to, num-1);
	
		sb.append(from + " " + to + "\\n");
		answer++;
		
		go(not, to, from, num-1);
		
	}



}