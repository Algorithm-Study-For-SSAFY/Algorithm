package al_4주차;

import java.util.Scanner;

public class Main_백준_2580_스도쿠 {
	
	public static int[][] arr = new int[9][9]; //스도쿠 배열

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = sc.nextInt();
			}
		} /////스도쿠 입력 받기 완료 ///////////

		sudo(0, 0);

	}

	public static void sudo(int row, int col) {

		// 해당 행이 다 채워졌을 경우 다음 행의 첫 번째 열부터 시작
		if (col == 9) {
			sudo(row + 1, 0);
			return;
		}

		// 행과 열이 모두 채워졌을 경우 출력 후 종료
		if (row == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

			// 출력 뒤 시스템을 종료
			System.exit(0);
		}

		//  0 이라면 1부터 9까지 중 가능한 수 탐색
		if (arr[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				// i 값이 중복되지 않는지 검사
				if (possibility(row, col, i)) {
					arr[row][col] = i;
					sudo(row, col + 1);
				}
			}
			arr[row][col] = 0;
			return;
		}

		sudo(row, col + 1);

	}

	public static boolean possibility(int row, int col, int value) {

		// 같은 행에 있는 원소들 중 겹치는 열 원소가 있는지 검사
		for (int i = 0; i < 9; i++) {
			if (arr[row][i] == value) {
				return false;
			}
		}

		// 같은 열에 있는 원소들 중 겹치는 행 원소가 있는지 검사
		for (int i = 0; i < 9; i++) {
			if (arr[i][col] == value) {
				return false;
			}
		}

		// 3*3 칸에 중복되는 원소가 있는지 검사
		int Srow = (row / 3) * 3; // value가 속한 3x3의 행의 첫 위치
		int Scol = (col / 3) * 3; // value가 속한 3x3의 열의 첫 위치

		for (int i = Srow; i < Srow + 3; i++) {
			for (int j = Scol; j < Scol + 3; j++) {
				if (arr[i][j] == value) {
					return false;
				}
			}
		}

		return true; // 중복되는 것이 없을 경우 true 반환
	}

}
