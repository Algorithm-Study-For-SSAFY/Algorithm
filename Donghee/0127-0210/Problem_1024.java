import java.util.Scanner;

public class Problem_1024 {
	static int N;
	static int L;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		L=sc.nextInt();
		int x=0;
		//반례: 30 6 -> 음수발생문제, x<0 경우 if문에 추가
		while(true) {
			int sum=0;
			if(L>100) {
				break;
			}
			for(int i=1; i<L; i++) {
				sum+=i;
			}
			if((N-sum)%L==0) {
				x=(N-sum)/L;
				break;
			}
			else
				L++;
		}
		if(L>100 ||  x<0) System.out.println("-1");
		else {
			for(int i=0; i<L; i++)	
				System.out.print(x+i + " ");
		}
		
	}
}
