package March_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399_ATM {
	//N명의 사람들이 줄 서있다. 1~N까지, 3,1,4,3,2 인 경우 --> sort하면됨
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int []arr=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int num=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) {
				num+=arr[j];
			}
		}
		System.out.println(num);
	}
}
