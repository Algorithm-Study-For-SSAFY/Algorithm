import java.util.Scanner;

public class boj11729 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int plate_num = sc.nextInt();
		// 3���� ��� , 1��, 2��, 3��
		// 1���� ���� �̵� : �ٷ� �Ű�
		// 2���� ���� �̵� : a�� 2�� �ű��, b�� 3���� �ű���, a�� �ٽ� 3���� �Ű�
		//��븦 ���� , ��ǥ����, ������
		//5���� ���� : 1~4�� ����->�������� �ű��, 5�� ��ǥ�������� + 4���ǿ����� ������ -> ��ǥ��
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
