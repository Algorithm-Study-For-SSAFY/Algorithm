import java.io.*;
import java.util.*;

public class 백준_1874_스택수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int index = 0;
		int[] answer = new int[N];
		
		for (int i = 0; i < N; i++) {
			answer[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i <= N; i++) {
			stack.add(i);
			sb.append("+\n");
			while (stack.peek() == answer[index]) {
				stack.pop();
				sb.append("-\n");
				index++;
				if (stack.isEmpty())
					break;
			}
		}
		if (stack.isEmpty())
			System.out.println(sb);
		else
			System.out.println("NO");
	}
}
