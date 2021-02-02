import java.util.Scanner;

public class boj1072 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long X, Y;
		X = sc.nextLong();
		Y = sc.nextLong();
		int first_Z =  (int) ((double) Y * 100 / X );
		
		//�·��� 99�ۼ�Ʈ��� ���� ������ �ʾ� ( 100�۷� �ö󰡴°� �Ұ�!)
		if( first_Z >= 99) {
			System.out.println(-1);
			return;
		}
		// Y <= X <=10��,, �� �ؾ��ϴ� �Ǽ��� 10���� �Ѿ��? �����÷ο쳯���� 
		/*�ش� �ڵ�δ� �ð��ʰ� �߻�
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
		
		// �ð��ʰ��� �غ��ϱ� ���� �̺�Ž�� ����
		long first = 0;
		long last = Long.MAX_VALUE;
		long mid = 0;
		int Z;
		while(first <= last) {
			//long mid = (first + last) / 2; //�ܼ� ���ؼ� �������ϸ� overflow ���ɼ�
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
