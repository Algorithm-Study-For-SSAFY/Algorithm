import java.util.Scanner;

public class boj1541 {
	public static void main(String[] args) {
		//값을 최소로. 음수도가능
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String tmp = "";
		int total = 0;
		int tmp_int = 0;
		boolean flag = false; //true면 괄호가 열린걸 의미.
		
		// 생각단순화 => -가 한번이라도 나오기 전 +들은 전부 다 덧셈. -가 한번이라도 나오면 그 이후 +들은 전부 다 뺄셈이다.
		// -는 그냥 전부다 뺄셈이라고 생각.
		// Q. -를 상쇄하는 -가 나온다면? 괄호가 한번 열었다가 닫힌셈이고, 새로 괄호가 열린셈이라서 마찬가지로 그 이후 +들도 전부 다 뺄셈.
		for(int i=0; i<input.length(); i++) {
			char x = input.charAt(i);
			if( x != '+' && x !='-') {
				//숫자를 의미
				tmp += x;
			}
			if( x=='+' || x=='-' || i==input.length()-1){ //연산기호 만나거나 마지막
				tmp_int = Integer.parseInt(tmp);
				tmp = "";
				if(flag) total -= tmp_int;
				else total += tmp_int;
				if (x =='-') {//연산기호 -를 만났을 때
					flag = true;
				}
			}
		}//for
		
		System.out.println(total);
	}//main
}
