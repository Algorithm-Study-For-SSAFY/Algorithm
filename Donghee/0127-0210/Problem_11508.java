package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 2+1 문제, ArraySort할 때 내림차순 하는 방법??  */
public class Problem_11508 {
	private static int N;
	private static int []map;
	private static int free, sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N];
		for(int i=0; i<N; i++) {
			map[i]=Integer.parseInt(br.readLine());
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
