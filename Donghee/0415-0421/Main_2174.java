package April_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2174 {
	private static int R, C;
	private static int map[][];
	private static Robot robot[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		C=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		map=new int[R][C];
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		robot=new Robot[N+1];
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int d=changeDir(st.nextToken().charAt(0));
			map[R-y][x-1]=i;
			robot[i]=new Robot(R-y,x-1,d);
		}//n개의 로봇 입력받기
		
		//m개의 명령
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int index=Integer.parseInt(st.nextToken());
			char c=st.nextToken().charAt(0);
			int cnt=Integer.parseInt(st.nextToken()); //반복횟수
			for(int j=0; j<cnt; j++) {
				int dir=robot[index].d;
				switch(c) {
				case 'L':
					robot[index].d=(dir+1)%4;
//					if(!moveRobot(index,(dir+1)%4))
//						System.exit(0);
					break;
				case 'R':
					robot[index].d=(dir+3)%4;
					break;
				case 'F':
					if(!moveRobot(index, dir))
						System.exit(0);
					break;
				}
			}
		}
		System.out.println("OK");
	}
	private static int []dr= {-1,0,1,0};
	private static int []dc={0,-1,0,1};
	
	private static boolean isOutside(int r, int c) {
		if(r<0 || c<0 || r>=R || c>=C) return false;
		return true;
	}
	private static boolean isSamePosition(int r, int c) {
		if(map[r][c]!=0) return false;
		return true;
	}
	
	
	private static boolean moveRobot(int index, int d) {
		int r=robot[index].r; int c=robot[index].c;
		map[r][c]=0; 
		robot[index].d=d;
		int nr=r+dr[d]; int nc=c+dc[d];
		robot[index].r=nr; robot[index].c=nc;
		
		if(!isOutside(nr,nc)) {
			System.out.println("Robot "+index+" crashes into the wall");
			return false;
		}
		if(!isSamePosition(nr,nc)) {
			System.out.println("Robot "+index+" crashes into robot "+map[nr][nc]);
			return false;
		}
//		System.out.println(robot[index].r+" "+robot[index].c);
		map[nr][nc]=index;
		return true;
	}


	private static int changeDir(char c) {
		switch(c) {
		case 'N':
			return 0;
		case 'W':
			return 1;
		case 'S':
			return 2;
		case 'E':
			return 3;
		}
		return 0;
	}

	private static class Robot{
		int r, c, d;
		public Robot(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
	}
}
