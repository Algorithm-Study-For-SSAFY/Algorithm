package baekjoon;

import java.util.Scanner;

public class Problem_1929 {
	//에라토스테네스의 체 이용
	//k=2부터 루트n까지 반복하여 자연수들 중, k를 제외한 k의 배수들을 모두 제외시킨다.
	//기본값이 false이므로, 소수 아닌 index에 true로 바꿔주기
	private static boolean visit[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		visit=new boolean[n+1]; //이 때 초기화 기본 값은 false.
		visit[1]=true;
		for(int i=2; i<=Math.sqrt(n); i++) {
			//i의 배수들 제거하기,
			for(int j=2; i*j<=n; j++)
				visit[j*i]=true;
		}
		for(int i=m; i<=n; i++)
			if(!visit[i])
				System.out.println(i);
	}

}
