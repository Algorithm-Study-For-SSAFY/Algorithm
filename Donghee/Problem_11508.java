package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/* 2+1 문제, ArraySort할 때 내림차순 하는 방법?? */
public class Problem_11508 {
	private static int N;
	private static int []map;
	private static int free, sum;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		map=new int[N];

		for(int i=0; i<N; i++) {
			map[i]=sc.nextInt();
			sum+=map[i];
		}
		
		Arrays.sort(map); //map정렬, 오름차순
		
		//오름차순으로 정렬되어 있기 때문에, 끝에서부터 검사시작.
		for(int i=N-3; i>=0; i-=3) {
			free+=map[i];
		}
		System.out.println(sum-free);
	}
}
