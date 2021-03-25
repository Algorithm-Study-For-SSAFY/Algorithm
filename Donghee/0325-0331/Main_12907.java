
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12907_동물원 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int []cnt=new int[N]; //N명이 있을 때, N이상의 숫자가 나올수는 없다.0부터 N-1까지만 가능!
		StringTokenizer st=new StringTokenizer(br.readLine());
		boolean flag=true;
		for(int i=0; i<N; i++) {
			int x=Integer.parseInt(st.nextToken());
			if(x>=N) {
				flag=false; //불가능한 경우
				continue;
			}
			cnt[x]++;
			//2이상이어도 안되고, 전 꺼보다 커서도 안된다.
			if(cnt[x]>2) flag=false;
		}
		for(int i=1; i<N; i++) {
			if(cnt[i-1]<cnt[i]) flag=false;
		}
		//적절하게 숫자가 있는경우,
		int idx=0;
		int answer=1;
		if(flag) {
			if(cnt[0]==1) { //이 경우에는 한가지밖에 없다
				answer=2;
			}else if(cnt[0]==2) {
				int i=1;
				idx=1;
				//2일 때 까지는 계속 idx 올리고, 1이 나오면? 한번만 idx올리고 빠져나오기, 0이나오면 그냥 빠져나가기
				while(cnt[i]!=0) {
					idx++;
					if(cnt[i]==1) break;
					i++;
				}
				for(int j=0; j<idx; j++)
					answer*=2;
			}
		}
		if(!flag) System.out.println(0);
		else System.out.println(answer);
	}
}
