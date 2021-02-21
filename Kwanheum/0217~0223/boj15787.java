import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15787 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M= Integer.parseInt(stk.nextToken());
		
		//1~N번째 열차, 1~20번째 자리
		//1<<20 ? 1024 * 1024 = 약 백만?
		int[] train = new int[N+1];
		//사람이 타있다면 1로 표시, 없다면 0 으로 표시
		
		for(int i=0; i<M; i++) {
			stk = new StringTokenizer(br.readLine());
			int inst = Integer.parseInt(stk.nextToken());
			int train_num = Integer.parseInt(stk.nextToken());
			int seat_num = 0;
			if(inst == 1 || inst == 2) {
				seat_num = Integer.parseInt(stk.nextToken());				
			}
			
			switch( inst) {
			case 1:
				//seat_num가 1이면 bit로는 0번자리니까 -1해줌
				train[train_num] = train[train_num]| 1<<(seat_num-1);
				break;
			case 2:
				//0010
				//1101
				//System.out.println(1<<(seat_num-1));
				//System.out.println(~(1<<(seat_num-1)));
				train[train_num] = train[train_num] & ~(1<<(seat_num-1));
				break;
			case 3:
				train[train_num] = train[train_num]<<1;
				//20번째를 넘어가면? 하차
				train[train_num]= train[train_num] & ((int)Math.pow(2, 20)-1);
				break;
			case 4:
				train[train_num] = train[train_num]>>1;
				//1번째 밑? 자동으로 버려짐
				//System.out.println(train[train_num]);
				break;
			}	
		}
		//명령 끝
		//n번째 열차가 이전열차들의 기록과 xor했을 때 0이면 통과불가 N^2
		//2^21 = 1000*1000 => boolean : 1000KB : 1MB
		//train의 max값 구해서 만들거나 or 그냥 2^20로 만들거나
		
		int answer = 0; 
		boolean[] chk = new boolean[(int)Math.pow(2, 20)];
		for(int i=1; i<=N; i++) {
			//System.out.println(train[i]);
			if(!chk[train[i]]) {
				chk[train[i]] = true;
				answer++;
			}
		}
		System.out.println(answer);
	}
}
