package baekjoon;

import java.util.Scanner;
/** 스타트 링크
 * 조합처럼 생각, 4개의 팀이있으면 2개 2개 씩 만들고 -> 겹치는걸 어떻게하면 줄일 수 있을까...
 */
public class Main_14889 {
	static int N;
	static int[][] map;
	static boolean []visit; //해당 숫자를 뽑았다,
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		visit=new boolean[N];
		map=new int[N][N];
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				map[i][j]=sc.nextInt();
		comb(0,0); //현재 0개 뽑았고, 0번째 index부터 시작한다는 함수 호출
		System.out.println(min);
	}//end of main
	static int start=0;
	static int link=0;
	static int min=Integer.MAX_VALUE;
	
	public static void comb(int cnt, int idx) {
		//종료조건
		if(cnt==N/2) {
			//계산작업 , 종료
			for(int i=0; i<N; i++) {
				if(visit[i]) {//스타트 팀이면
					for(int j=0; j<N; j++) {
						if(visit[j] && i!=j) {
							start+=map[i][j];
						}
					}
				}else {
					for(int j=0; j<N; j++) {
						if(!visit[j] && i!=j) {
							link+=map[i][j];
							}
					}
				}
			}//가능한 start, link 답구하고
			min=Math.min(min, Math.abs(start-link));
			start=0; link=0; //값 초기화 시켜주기, 
			return;
		}
		for(int i=idx; i<N; i++) {
			if(visit[i]) continue; //방문했던애면 볼 필요가 x
			//아니면
			visit[i]=true;
			comb(cnt+1, i+1);
			visit[i]=false;
		}
	}
}//end of class


// 깔끔합니다 ! 
