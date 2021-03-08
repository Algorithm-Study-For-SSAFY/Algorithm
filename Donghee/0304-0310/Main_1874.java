
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//스택 수열
public class Main_1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		Stack<Integer> stack=new Stack<>();
		int now=1;

		while(N-->0) {
			int a=Integer.parseInt(br.readLine());

			if(now<=a) {
				//now가 a가 될 때까지 push하기
				for(int i=now; i<=a; i++) {
					stack.push(i); sb.append("+").append("\n");
				}
				now=a+1;
			}else if(!stack.isEmpty() && stack.peek()!=a) {
				System.out.println("NO"); return;
			}
			
			//위의 2가지 경우가 모두 아니라면, pop하기
			stack.pop();
			sb.append("-").append("\n");
		}
		System.out.println(sb.toString());
	}
}
