import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 백준_11047_동전 {
public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	int moneytype = sc.nextInt(); // 돈의 종류
	int amount = sc.nextInt(); // 금액 
	int sum = 0; // 필요한 동전의 개수 합

	ArrayList<Integer> moneyList = new ArrayList<>();

	for (int i = 0; i < moneytype; i++) {
		moneyList.add(sc.nextInt());
	}
     
	Collections.sort(moneyList, Comparator.reverseOrder());

	for (int i = 0; i < moneytype; i++) {
		int money = moneyList.get(i);
		amount %= money;
        sum += amount / money;
		

	}
	System.out.println(sum);
}
    }