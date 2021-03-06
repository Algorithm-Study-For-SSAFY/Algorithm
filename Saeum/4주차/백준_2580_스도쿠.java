 
import java.io.*;
import java.util.*;

public class 백준_2580_스도쿠 {

    static ArrayList<int[]> empty = new ArrayList();
    static int[][] matrix = new int[9][9];

    public static void main(String[] args){
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<9; i++){ // 입력에 따라 현재 스도쿠 판 만들기
            for(int j=0; j<9; j++){
                matrix[i][j] = sc.nextInt();
                if(matrix[i][j] == 0) empty.add(new int[]{i,j});
            }
        }

        sudoku(0);  

        try {  
            for(int i=0; i<9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(String.valueOf(matrix[i][j]));
                    bw.write(" ");
                }
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean sudoku(int count){
        if(count == empty.size()){ // 종료조건
            return true;
        }
        else{
            int[] position = empty.get(count); // 다음 빈칸의 위치 가져옴
            int n = position[0];
            int m = position[1];
            for(int i = 1; i<10; i++){  
                if(isPromising(matrix, n, m, i)){  
                    matrix[n][m] = i;
                    if (sudoku(count+1)) return true; // 끝에 도달  return true
                    else matrix[n][m] = 0; // 끝에 도달하지 못했 해당 칸 초기화
                }
            }
        }
        return false;
    }


    static boolean isPromising(int[][] matrix, int n, int m, int num){
        int length = matrix.length;
        int n_block = n / 3; //  세로 위치
        int m_block = m / 3; //   가로 위치

        for(int i =0; i<length; i++){ // 조건1: 가로세로 판단
            if(matrix[n][i] == num) return false;
            if(matrix[i][m] == num) return false;
        }

        for(int i=0; i<3; i++){ // 조건2: 같은 블록 내 판단
            for(int j=0; j<3; j++){
                if(matrix[(n_block*3)+i][(m_block*3)+j] == num)
                    return false;
            }
        }

        return true;
    }
}