package April_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//캐슬디펜스
public class Main_17135 {
	private static int N, M, D, map[][];
	private static boolean visit[]; //궁수의 위치를 담을 배열
	private static int totalCnt; //적의 총 명수
	private static int answer; //제거할 수 있는 최대 수 , 
	private static ArrayList<Pair> list;
	private static int nowCnt;
	private static int tmpCnt;
	private static int[][] C_map;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		visit=new boolean[M];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					totalCnt++;
				}
			}
		}
		C_map = new int[N][M];
		copy(C_map,map);
		comb(0,0);
		System.out.println(answer);
	}//end of input
	
	private static void copy(int C_map[][], int map[][]) {
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				C_map[i][j]=map[i][j];
	}
	
	//조합
	private static void comb(int cnt, int idx) {
		if(cnt==3) {
			//세명 다 뽑았으면, 궁수 공격+적이동
			tmpCnt=0; //answer 대신할거
			nowCnt=totalCnt;
			copy(map,C_map);
			while(nowCnt>0) {
				list=new ArrayList<>();
				for(int i=0; i<M; i++)
					if(visit[i]) fight(i);
				remove();
				move();
			}
			answer=Math.max(answer, tmpCnt);
			return; 
		}
		for(int i=idx; i<M; i++) {//어차피 행은 N+1이고, 열의 위치만 어딘지 찾아주면된다.
			visit[i]=true;
			comb(cnt+1, i+1);
			visit[i]=false;
		}
	}
	private static void move() {
		//적 들 이동
		//N-1행은 따로 처리해주자! 얘네는 사라지니까
		for(int i=0; i<M; i++) {
			if(map[N-1][i]==1) {
				nowCnt--; //갯수들 없애주기
			}
		}
		//다 밑으로 땡겨주기
		for(int i=N-1; i>=1; i--) {
			for(int j=0; j<M; j++) {
				map[i][j]=map[i-1][j];
			}
		}
		for(int i=0; i<M; i++)
			map[0][i]=0;
	}
	private static void remove() {
		//list에 들어가있는 애들 제거하기 
		for(int i=0; i<list.size(); i++) {
			int r=list.get(i).r;
			int c=list.get(i).c;
			if(map[r][c]==1) {
				map[r][c]=0; //적 제거
				nowCnt--;
				tmpCnt++;
			}
		}
	}
	private static void fight(int c) {
		//c열에 존재
		ArrayList<Pair> tmp=new ArrayList<>();
		for(int i=N-1; i>=0; i--) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) {
					//적이 있을 경우에만 거리쳌
					int dist=Math.abs(N-i)+Math.abs(c-j);
					if(dist<=D) { //거리가 D 이하인 경우만
						tmp.add(new Pair(i,j,dist));
					}
				}
			}
		}
		if(tmp.size()>0) {
			Collections.sort(tmp); //list 의 첫번째 있는애 로 결정!
			list.add(new Pair(tmp.get(0).r, tmp.get(0).c, tmp.get(0).dist));
		}
	}
	
	private static class Pair implements Comparable<Pair>{
		int r, c; //위치
		int dist; //거리
		
		public Pair(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Pair o) {
			if(this.dist==o.dist) return this.c-o.c;
			return this.dist-o.dist;
		}
	}
}


