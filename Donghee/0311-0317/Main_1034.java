package March_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1034 {
	private static int N, M, K;
	private static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for(int i=0; i<N; i++) {
			String str=br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
			
		}
		K=Integer.parseInt(br.readLine()); //총 뒤집을 횟수

		boolean check[]=new boolean[N];
		int answer=0;
		for(int i=0; i<N; i++) {
			//i행에서 총 0이 몇개 있는지 확인하기
			int cnt=0;
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) cnt++;
			}
			//모든 행이 끝나면 cnt의 갯수와 k의 갯수 비교하기, 홀짝은 같아야함
			if((cnt<=K) && (K%2==cnt%2)) {
				check[i]=true;
			}
		}
		for(int i=0; i<N; i++) {
			int cnt=0;
			boolean flag=true;
			if(check[i]) { //가능한 경우,
				//i행과 배열이 같은지 확인하기
				for(int j=0; j<N; j++) {
					flag=true;
ex:					for(int k=0; k<M; k++) {
						if(map[i][k]!=map[j][k]) {
							flag=false;
							break ex;
						}
					}
					if(flag) cnt++;
				}
				
			}
			answer=Math.max(answer, cnt);
		}

		System.out.println(answer);

	}
	

}
