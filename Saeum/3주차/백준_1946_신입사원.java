package week3;

import java.util.*;

public class 백준_1946_신입사원 {

	//순위는 면접이랑 서류 모두 1~N이니까 
	//면접 서류 중 하나를 index로 설정 
	
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 

        for (int i = 0; i < t; i++) {
            int loop = sc.nextInt();
            int[] candidates = new int[loop + 1];
            for (int j = 0; j < loop; j++) {
                candidates[sc.nextInt()] = sc.nextInt();
            }

            int count = 1;
            int interviewRank = candidates[1];

            for (int k = 2; k <= loop; k++) {
                if (interviewRank >= candidates[k]) {
                    interviewRank = candidates[k];
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}

/**
 * 저는 다 입력받은 이후에 정렬했는데 한번에 인덱스로 받을 수도 있네요!
 * 
 *
 */
