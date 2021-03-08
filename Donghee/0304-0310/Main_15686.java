package March_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686 {
	private static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x=x; this.y=y;
		}
	}
	private static int N, M, chickCnt;
	private static int ans=Integer.MAX_VALUE;
	private static int map[][];
	private static boolean chicken[];
	private static ArrayList<Pair> pair;
	private static ArrayList<Pair> chick;
	private static ArrayList<Pair> house;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		chick=new ArrayList<>();
		house=new ArrayList<>();
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				//0 빈칸, 1 집, 2 치킨집
				map[i][j]=Integer.parseInt(st.nextToken());
				//치킨 위치
				if(map[i][j]==2) {
					chickCnt++;
					chick.add(new Pair(i,j));
				}else if(map[i][j]==1) {
					house.add(new Pair(i,j));
				}
			}
		}//end of input
		chicken=new boolean[chickCnt];
		comb(0,0);
		System.out.println(ans);
	}//end of main
	
	//최대 M개 
	private static void comb(int cnt, int idx) {
		if(cnt==M) {
			return; //더이상 x
		}
		
		for(int i=idx; i<chickCnt; i++) {

			chicken[i]=true;
			calc();
			comb(cnt+1, i+1);
			chicken[i]=false;
		}
	}
	
	private static void calc() {
		pair=new ArrayList<>();
		for(int i=0; i<chickCnt; i++) {
			if(chicken[i]) {
				pair.add(new Pair(chick.get(i).x, chick.get(i).y));
			} //치킨 집 모두 queue에 push
		}
		//고른 치킨집 중심으로 집들을 모두 탐색, 
		int tmpresult=0;
		for(int i=0; i<house.size(); i++) {
			int nx=house.get(i).x;
			int ny=house.get(i).y;
			int dist=Integer.MAX_VALUE;
			for(int k=0; k<pair.size(); k++) {
				int a=pair.get(k).x;
				int b=pair.get(k).y;
				dist=Math.min(Math.abs(a-nx)+Math.abs(b-ny), dist);
			}
			tmpresult+=dist;
		}
		ans=Math.min(ans, tmpresult);	
	}
}//end of class
