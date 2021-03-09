package algo_study_6w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class boj1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> s = new Stack<>();
		List<Character> l = new LinkedList<>();
		int index = 1;
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			int input = Integer.parseInt(br.readLine());
			if(index < input) {
				while(index <input) {
					s.push(index++);
					sb.append("+\n");
					//l.add('+');
				}
				//while문 끝나면 index == input일 것
				//l.add('+');
				//l.add('-');
				sb.append("+\n");
				sb.append("-\n");
				index++;
			}
			else if(index == input) {
				//l.add('+');
				//l.add('-');
				sb.append("+\n");
				sb.append("-\n");
				index++;
			}else {//index > input
				if(s.peek() == input) {
					//l.add('-');
					sb.append("-\n");
					s.pop();
				}
				else {
					flag = true;
					break;
				}
			}
		}//for
		if(flag) System.out.println("NO");
		else {
			/*for(int i=0; i<l.size();i++) {
				sb.append(l.get(i)).append("\n");
			}*/
			System.out.println(sb);
		}
		
		/*
		처음에 list에 문자열을 저장하고 이를 다시 반복해서 돌면서 sb에 추가하는 불필요한 과정으로 짰는데,
		main for문만 보고 O(n)인데 왜 시간초과가 나지 라고 고민했던 문제.. 결론적으로 불필요한 O(2n)의 시간이 더  발생해서 시간초과 발생!!*/
		
		
		
	}//main
}
