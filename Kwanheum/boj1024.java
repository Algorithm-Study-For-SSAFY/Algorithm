import java.util.Scanner;

public class boj1024 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L =  sc.nextInt();
		// ���� N�̸鼭, ���̰� �ּ� L�̻��� ���ӵ� ���� ����Ʈ
		boolean flag = false;
		for(int i=L; i<=100; i++) {
			// �ּҰ� x��� �����ϸ� , x , x+1, x+2 ,,, x + i-1 �� ������
			// N = i * x + (i-1)(i)/2  �ϵ�
			// N/i - (i-1)/2 = x;
			// {2N - (i-1)i} / 2i = x;
			// x�� ���̵Ǹ� �ȵǹǷ� , ������� �ʿ�!!!
			if( (2*N >= (i-1)*i) && (2*N - (i-1)*i) % (2*i) == 0) {
				int x = (2*N - (i-1)*i) /  (2*i);
				for(int j=0; j<i; j++) {
					System.out.print(x+j + " ");
				}
				flag = true;
				break;
			}//if
		}//for
		//���̰� 100���� ũ�ų�, ������ ���� ���
		if(!flag) System.out.println(-1);
	}
}
