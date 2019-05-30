package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Facilities {

	public static ArrayList<Item> items = new ArrayList<Item>();

	public static void main(String[] args) throws Exception {

		facilities(); //부대시설 카테고리
		// *** 재고량을 파악하여 수량 선택 시 재고가 없다면 주문을 못 할 수 도있도록***//

	}

	public static void facilities() throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		boolean loop = true;
		while (loop) {

			System.out.println();
			System.out.println("============== 환상의 나라 부대시설 ==============");
			System.out.println();
			System.out.println("1. 황제마사지");
			System.out.println("2. 장모님의 손맛");
			System.out.println("3. 황금마차");
			System.out.println("4. 전좌석 안전벨트 PC방");
			System.out.println("5. 오빤 강남 스타일 노래방");
			System.out.println("6. 언니, 오빠 배만보면 빨래판 헬스장");
			System.out.println();
			System.out.println();
			System.out.println("7. 사용 및 구매내역 확인");
			System.out.println("8. 초기화면으로");
			System.out.println();
			System.out.println("==================================================");
			System.out.print("선택 : ");
			String choice = reader.readLine();

			if (choice.equals("1")) {
				Facilities_Massage.massage(); // 마사지

			} else if (choice.equals("2")) {
				Facilities_Restaurant.restaurant(); // 식당

			} else if (choice.equals("3")) {
				Facilities_Mart.Mart(); // 매점

			} else if (choice.equals("4")) {
				Facilities_Pc.pc(); // 피시방

			} else if (choice.equals("5")) {
				Facilities_Karaoke.karaoke(); // 노래방

			} else if (choice.equals("6")) {
				Facilities_Gym.gym(); // 헬스장

			} else if (choice.equals("7")) {
				Facilities_Cash.cash(); // 구매내역

			} else {	//잘못입력시 
				loop = false;

			}

		}
	}
}
