import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1083 {
	private static int N, arr[];
	private static int S;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		arr=new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		S=Integer.parseInt(br.readLine());
		for(int i=0; i<N && S>0; i++) {
			int max_val=arr[i]; //max 최댓값 찾기 , 남아있는 수 중에서
			int max_num=i; //인덱스
      //교환횟수는 S를 넘을수 없음,
			for(int j=i+1; j<N && j<=i+S; j++) {
				//max갱신
				if(max_val<arr[j]) {
					max_num=j; max_val=arr[j];
				}
			}
			//여기 도달했을 때 max_num 값 이랑 i랑 차이만큼 교환횟수 빼주기
			S-=(max_num-i);
			//i부터 max_num-1까지 한칸씩 뒤로 쭉 밀기,
			for(int j=max_num; j>=i+1; j--) {
				arr[j]=arr[j-1];
			}
			arr[i]=max_val;
		}
		
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<N; i++)
			sb.append(arr[i]).append(" ");
		System.out.println(sb.toString());
	}
}
