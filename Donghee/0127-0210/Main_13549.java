package feb_01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 숨바꼭질3
 * 수빈이는 1초에 X-1 또는 X+1 , 순간이동을 하면 2*X 시간은 추가  x
 */
public class Main_13549 {

	static int N,K;
	static int answer=Integer.MAX_VALUE;
	static boolean visit[];
	
	//queue에 들어갈 숫자와 그때의 이동횟수 저장할 class 생성
	private static class pair{
		int n;
		int cnt;
		public pair(int n, int cnt) {
			this.n=n; this.cnt=cnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		
		Queue<pair> q=new LinkedList<pair>();
		//visit를 boolean으로 선언할 경우, 경로에 따라 다른값 발생가능.
		//visit에 몇초인지 넣고, 더 작은 값 나오면 갱신해주기.
		
		visit= new boolean[100001];
		q.offer(new pair(N,0));
		
		//queue가 비어있는 동안
		while(!q.isEmpty()) {
			
			//visit 표시를 아래에서 해주면 틀리고 위에서 pop해주면서 visit 하면 정답이됨. 
			
			pair p=q.poll();
			int x=p.n;
			visit[x]=true;
			int y=p.cnt;
			//같아지는순간 answer 저장
			if(x==K) {
				answer=Math.min(answer, y);
			}
			
			//이동할 수 있는 방향은 3개! x-1, x+1, 2*x
			//1.x-1로 이동, 범위에 맞고, 방문한적이 없으면 push
			if(x-1>=0 && !visit[x-1]) {
				q.offer(new pair(x-1, y+1));
			}
			//2.x+1로 이동 , 범위에 맞고 방문하지 않았던 곳이라면 push하고 방문처리
			if(x+1>=0 && x+1<=100000 && !visit[x+1]) {
				q.offer(new pair(x+1, y+1));
			}
			//3. 2*x로 이동, 범위에 맞고 방문하지 않았던곳이면 push, 이때 시간은 안늘린다.
			//범위 주위, 0이상도 있지만 상한에도 범위존재 
			if(2*x>=0 && 2*x<=100000 && !visit[2*x]) {
				q.offer(new pair(2*x, y));
			}
		}
		System.out.println(answer);
	}

}
