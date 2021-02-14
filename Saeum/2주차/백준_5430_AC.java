import java.util.*;

public class 백준_5430_AC {

	// 다시 풀기
	// R 짝수 : 앞쪽에서 삭제 , R : 뒤에서 삭제
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;

		int T = sc.nextInt(); // 테스트 케이스 수 입력
		for (int i = 0; i < T; i++) { // 테스트 케이스 수만큼 반복
			String p = sc.next(); // 함수 
			int n = sc.nextInt(); // 데이터수
			String data = sc.next();

			int front = 0; // 배열 앞 위치
			int back = n; // 배열 뒤 위치
			int count = 0; // 뒤집기 여부 카운트 홀수면 뒤집은거 짝수면 안 뒤

			for (int j = 0; j < p.length(); j++) {
				if (p.subSequence(j, j + 1).equals("R")) { // 뒤집기
					count++;
				} else if (p.subSequence(j, j + 1).equals("D")) { // 버리기
					if (count % 2 == 0) { // 짝수면 안뒤집은거니깐 앞에를 버림
						front++;
					} else { // 홀수는 뒤집은거라 뒤를 버림
						back--;
					}
				}
			}
			if (n == 0 && front == 0 && back == 0 && count != 0) { // 빈배열에 뒤집기만 한 경우
				System.out.println("[]");
			} else if (back == front) { // 빈배열을 출력
				System.out.println("[]");
			} else if (back < front) { // 배열 내용 < 버리기 
				System.out.println("error");
			} else {
				String[] a = new String[n];  
				data = data.substring(1, data.length() - 1); // 처음 입력받은 데이터에서 앞뒤 [] 부분을 자르고 저장
				st = new StringTokenizer(data, ",");
				for (int z = 0; z < n; z++) {
					a[z] = st.nextToken(); 
				}
				System.out.print("[");
				if (count % 2 == 0) { // 배열을 처음부터 출력
					for (int j = front; j <= back - 1; j++) {
						if (j == back - 1) {
							System.out.print(a[j]);
						} else {
							System.out.print(a[j] + ",");
						}
					}
				} else { // 배열을 역순으로 출력
					for (int j = back - 1; j >= front; j--) {

						if (j == front) {
							System.out.print(a[j]);
						} else {
							System.out.print(a[j] + ",");
						}
					}
				}
				System.out.println("]");
			}
		}
	}
}
