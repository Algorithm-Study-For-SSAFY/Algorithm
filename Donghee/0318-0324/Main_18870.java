package March_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_18870 {
	private static class Pair{
		int idx, num;
		public Pair(int idx, int num) {
			super();
			this.idx = idx;
			this.num = num;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		Pair[] arr=new Pair[N];
		int [] answer=new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=new Pair(i,Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.num-o2.num;
			}
			
		});
		//가장 첫번째 꺼 부터 시작해서, 
		//idx자리에 순서대로 갯수를 넣기 시작
		int rank=0;
		int now=arr[0].num; //now는 현재 값,
		answer[arr[0].idx]=0;
		for(int i=1; i<N; i++) {
			//만약 rank랑(이전 값이랑 같다면?)
			if(now==arr[i].num) {
				answer[arr[i].idx]=rank;
			}else {
				answer[arr[i].idx]=++rank;
				now=arr[i].num;
			}
			
		}
		for(int i=0; i<N; i++)
			sb.append(answer[i]).append(" ");
		System.out.println(sb.toString());
	}
}
