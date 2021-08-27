package al_2주차;
import java.util.Scanner;
public class Main_백준_9461_파도반수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		long arr[] = new long [101];
		arr[1]=1;
		arr[2]=1;
		arr[3]=1;
		arr[4]=2;
		arr[5]=2;
		
		for (int i = 6; i <=100; i++) {
			arr[i]=arr[i-1]+arr[i-5];
		}
		for (int i = 1; i <=T; i++) {
			int num =sc.nextInt();
			System.out.println(arr[num]);
		}
		
	} // end of main
}// end of class
//////////////////////////////
////////관흠 코드 리뷰/////////////
//////////////////////////////
/*
 * 깔끔합니다! 
 */
