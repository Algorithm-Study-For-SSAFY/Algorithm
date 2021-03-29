package March_04;

import java.util.Scanner;

//로마 숫자 만들기
public class Main_16922 {
	private static boolean[] flag;
	private static int answer;
	private static int n;
	private static int arr[]= {1,5,10,50};
	private static boolean[][] visit;
	//사용할 수 있는 수:1,5,10,50
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt(); //n개를 사용해서 만들수 있는것
		//만들수 있는 최대 50*20=1000
		flag=new boolean[1001];
		visit=new boolean[20][1001];
		
		dfs(0,0);
		System.out.println(answer);
	}
	
	private static void dfs(int cnt, int num) {
		if(cnt==n) {
			if(!flag[num]) {
				flag[num]=true; answer++;
			}
			return;
		}

		for(int i=0; i<4; i++) {
			if(!visit[cnt][num+arr[i]]) {
				visit[cnt][num+arr[i]]=true;
				dfs(cnt+1, num+arr[i]);
			}
		}
	}
}
