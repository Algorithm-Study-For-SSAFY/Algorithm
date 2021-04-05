import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//휴게소 세우기

//문제점: 거리가 그때 그때마다 가장 긴걸 반으로 나눠주면 문제생김
// 4등분할걸 3등분만 해도 값이 나오는 경우가 있기 때문에, 

public class Main{
	private static int N, M, L; //현재, 지으려는 휴게소, 고속도로 길이
	private static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		//처음은 0 마지막은 L로 놓고 이분탐색 시작
		//휴게소의 거리를 설정하고 , 그 거리에 충족하는 휴게소의 갯수 합이 M개가 된느지 확인
		int arr[]=new int[N+2];
		arr[0]=0;
		st=new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++)
			arr[i]=Integer.parseInt(st.nextToken());
		arr[N+1]=L;
		//처음부터 끝까지 탐색하면서 갯수가 M개 나오게끔
		Arrays.sort(arr);
		int lo=0; int hi=L;
		while(lo<=hi) {
			
			int mid=(lo+hi)/2;
			//최소인거리의 최대가 mid일때 편의점 갯수를 살펴보기
			//arr을 돌면서 mid보다 길이가 작을 때마다 ++
			int cnt=0;
			for(int i=0; i<N+1; i++) {
				int num=arr[i+1]-arr[i];
				//나누어떨어지면 1빼고 나누어 떨어지지 않으면 그대로!
				if(num%mid==0) cnt+=((num/mid)-1);
				else cnt+=((num/mid));
			}
			if(cnt>M) { //세워야하는 편의점의 갯수보다 많다면, 범위를 늘려야한다.
				lo=mid+1;
			}else hi=mid-1;
		}
		System.out.println(lo);
		
	}
}
