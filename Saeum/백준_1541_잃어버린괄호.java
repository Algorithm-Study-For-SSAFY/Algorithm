
import java.util.*;

public class 백준_1541_잃어버린괄호 {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String form = sc.next();
		// sc.close();

		String[] str = form.split("-"); // '-' 기호 기준으로 배열에 담기
		// 처음 '-'전까지 모두 더하기
		String[] tmp = str[0].split("\\+");

		int first = 0;
		for (String t : tmp)
			first += Integer.parseInt(t); // 처음 '-' 이후 숫자 더하기

		int sum = 0;
		for (int i = 1; i < str.length; i++) {
			String[] temp = str[i].split("\\+");

			for (String t : temp)
				sum += Integer.parseInt(t);
		}
		System.out.println(first - sum); //-가 오기 전까지 원소 모두 더한 후 첫 번째 원소의 합에서 빼면 최솟값 
	}

}