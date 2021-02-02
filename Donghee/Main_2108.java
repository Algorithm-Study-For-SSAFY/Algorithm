package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2108 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int arr[]=new int[8001]; //최빈값을 다루기 위한 배열
		long avg1=0; int avg2=0;  int avg4=0; int avg3=0;
		int sum=0; //산술평균을 위해
		int [] map=new int[N];
		for(int i=0; i<N; i++) {
			map[i]=sc.nextInt();
			sum+=map[i];
			arr[map[i]+4000]++; //-4000~4000 => 0~8000
		}
		avg1=Math.round((double)sum/N);
		//중앙값은 map을 오름차순 정렬하고 N이 짝, 홀수일 때 나눔
		Arrays.sort(map);
		if(N%2==0)
			avg2=(map[N/2]+map[N/2-1])/2;
		else avg2=map[N/2];
		//최빈값
		//최대 빈도 먼저 구하기
		int max=0;
		for(int i=0; i<8001; i++) {
			if(arr[i]==0) continue; 
			max=Math.max(max, arr[i]);
		}
		//최대 빈도가 여러개일 경우를 가정하고, 2번째로 작은 값 구하기 위해 배열 생성
		boolean flag=false;
		for(int i=0; i<8001; i++) {
			//이 때가 2번째로 작은 최빈값
			if(arr[i]==max && flag) {
				avg3=i-4000; break;
			}
			//최빈값이면서, 가장 작은 수 일때 flag 값 변경
			if(arr[i]==max && !flag) {
				flag=true;
				avg3=i-4000;
			}			
		}

		avg4=map[N-1]-map[0];
		System.out.println(avg1+"\n"+avg2+"\n"+avg3+"\n"+avg4);
	}
}
