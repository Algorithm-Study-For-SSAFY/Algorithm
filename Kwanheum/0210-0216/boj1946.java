import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1946 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//적어도 하나가 떨어지지 않는 자만 선발
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			//Solution2. 배열인덱스 활용
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1]; // 0 is dummy
			for(int n=0; n<N; n++) {
				stk = new StringTokenizer(br.readLine());
				int test = Integer.parseInt(stk.nextToken());
				int interview = Integer.parseInt(stk.nextToken());
				arr[test] = interview; //test성적 자체를 index로해서 저장
			}
			int bound = arr[1];//test성적이 1등인 지원자의 면접점수 : bound
			int answer =1;
			for(int i=2; i<=N; i++) {
				if(arr[i] < bound) {
					answer++;
					bound=arr[i];
				} 
			}
			sb.append(answer).append("\n");
			
			//Solution1. 내부class이용해서 정렬
			/*int N = Integer.parseInt(br.readLine());
			Employee[] arr = new Employee[N];
			int tmp = 0;
			for(int n=0; n<N; n++) {
				stk = new StringTokenizer(br.readLine());
				int test = Integer.parseInt(stk.nextToken());
				int interview = Integer.parseInt(stk.nextToken());
				if(test == 1 ) tmp = interview; // test 1등의 interview등수 기록
				arr[n] = new Employee(test, interview);
			}
			Arrays.sort(arr);
			int answer = 1;
			int cut = N;
			for(int i=0; i<tmp-1; i++) { //tmp-1은 test 1등 자신
				if(arr[i].test <= cut) {
					answer++;
					cut = arr[i].test;
				}
			}
			sb.append(answer).append("\n");*/
		}
		System.out.println(sb);
	}
	static class Employee implements Comparable<Employee>{
		int test;
		int interview;
		public Employee(int test, int interview) {
			super();
			this.test = test;
			this.interview = interview;
		}
		@Override
		public int compareTo(Employee o) {
			// TODO Auto-generated method stub
			return this.interview - o.interview; //인터뷰성적으로 오름차순
		}
	}
}

//저는 solution 1처럼 class의 comparable interface 사용해서 정렬해준뒤에 구해줬는데
//순위가 유일하니까 배열에 넣어주는 방법 좋은것 같아요 ~! 
