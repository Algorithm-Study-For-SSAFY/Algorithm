package algo_study_11w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj1700 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int arr[] = new int[K];
		for(int i=0; i<K; i++) {
			arr[i] = sc.nextInt();
		}
		//input end
		boolean chk[] = new boolean[K+1];
		int chk_order[] = new int[K+1];
		ArrayList<Integer> list = new ArrayList<>();
		int cnt = 0;
		int answer = 0;
		for(int i=0; i<K; i++) {
			if(cnt == N) {//멀티탭 Full
				if(!chk[arr[i]]) {//하나 빼고 새로 끼워야함
					Arrays.fill(chk_order, 0);
					//i번째 이후의 사용패턴을 확인하여 , 멀티탭에 존재하는 전자기기가 가장빨리 나올때의 순서 체크
					for(int j=i+1; j<K; j++) {
						if(chk[arr[j]]) {//true 면 멀티탭에 꽂혀져있는것
							if(chk_order[arr[j]]==0) {
								chk_order[arr[j]] = j;
							}
						}
					}
					int last_order = 0;
					int last_idx = 0;
					boolean flag = false;
					for(int j=1; j<=K; j++) {
						if(chk[j]) {
							if(chk_order[j] == 0) {//뒤에 나올일이 없다.
								chk[j] = false;
								flag = true;
								break;
							}else {
								if(last_order < chk_order[j]) {
									last_order = chk_order[j];
									last_idx = j;
								}
							}
						}
					}
					if(!flag) {
						chk[last_idx] = false;
					}
					chk[arr[i]] = true;
					answer++;
				}
			}else {
				if(!chk[arr[i]]) {
					chk[arr[i]] = true;
					list.add(arr[i]);
					cnt++;
				}
			}
		}
	System.out.println(answer);
	
	}
}
