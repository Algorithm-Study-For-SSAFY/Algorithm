import java.util.Scanner;

public class boj11729 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int plate_num = sc.nextInt();
		// 3개의 장대 , 1번, 2번, 3번
		// 1개의 원판 이동 : 바로 옮겨
		// 2개의 원판 이동 : a를 2로 옮기고, b를 3으로 옮긴후, a를 다시 3으로 옮겨
		//장대를 현재 , 목표지점, 나머지
		//5개의 원판 : 1~4를 현재->나머지로 옮기고, 5를 목표지점으로 + 4개의원판을 나머지 -> 목표로
		move(plate_num, 1, 3, 2);
		System.out.println(cnt);
		System.out.println(sb);
	}
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();

	static void move(int plate_num, int from, int to, int etc) {
		if(plate_num == 1) {
			sb.append(from+" "+to+"\n"); //System.out.println(from +" "+ to);
			cnt++;
		}
		else {
			move(plate_num -1 , from, etc, to);
			move(1, from, to, etc);
			move(plate_num -1 , etc, to, from);
		}
		
	}
}
