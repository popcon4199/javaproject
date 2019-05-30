package bath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import etc.Facilities;
import etc.Item;
import Stream.locker;

public class Facilities_Shower_Ttaemiri {

	public static void main(String[] args) throws Exception {

		ttaemiri();
		// 마실거
	}

	public static void ttaemiri() throws Exception {
		System.out.println();
		System.out.println("======== 세신으로 가죽까지 벗겨드립니다 ==========");
		System.out.println();

		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));

		String path = ".\\dat\\ttaemiri.dat";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));

			System.out.println("============= 코스를 선택해 주세요 ===============");
			System.out.println();
			String line = null;

			int n = 1;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("\\|");

				System.out.printf("%d %s %s\n", n, temp[1], temp[2]);
				n++;
			} // 메뉴 넘버링 누적변수

			System.out.println();
			System.out.println("0 뒤로가기");
			System.out.println();
			System.out.println("==================================================");
			System.out.println();
			System.out.print("선택 (번호 입력) : ");
			String choice = reader2.readLine();
			System.out.println();

			menu1(choice);

			reader.close();

		} catch (Exception e) {

		}
	}

	public static void menu1(String menu) throws Exception {

		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));

		boolean loop = true;

		while (loop) {

			if (menu.equals("1")) {
				menu = "세신";
				shaeshin(menu, reader2, 20000);
				loop = false;

			} else if (menu.equals("2")) {
				menu = "부분세신 (등)";
				shaeshin(menu, reader2, 8000);
				loop = false;

			} else if (menu.equals("3")) {
				menu = "후면부분세신";
				shaeshin(menu, reader2, 10000);
				loop = false;

			} else if (menu.equals("4")) {
				menu = "우유팩마사지";
				shaeshin(menu, reader2, 2000);
				loop = false;

			} else if (menu.equals("5")) {
				menu = "요플레마사지";
				shaeshin(menu, reader2, 2000);
				loop = false;

			} else { // 잘못입력시...

				System.out.println();
				System.out.println("잘못 입력하셧습니다.");
				System.out.println("코스 번호로 반드시 입력해주세요.");
				System.out.println("코스 선택창으로 돌아갑니다.");
				System.out.println();
				loop = false;

			}
		}
	}

	private static void shaeshin(String menu, BufferedReader reader2, int price) throws IOException {

		System.out.println();
		System.out.printf("선택하신 코스는 '%s' 입니다.\n" + "이대로 계속하시겠습니까?(y/n) : ", menu);
		String answer1 = reader2.readLine();

		if (answer1.equals("y") || answer1.equals("Y")) {
			System.out.println();
			System.out.printf("'%s' 코스가 추가되었습니다.\n", menu); // 추가 되었을 시 라커번호에 저장.

			// =================================================
			// 주문내역 누적
			Item item = new Item();
			item.setCategory("세신으로 깔끔하게.");
			item.setMenu(menu);
			item.setPrice(price);
			item.setEa("1");

			locker.getLockers().get(item.getLockid()).getItems().add(item);
			Facilities.items.add(item);
			// =================================================

			System.out.println();

		} else if (answer1.equals("n") || answer1.equals("N")) {
			System.out.println("\r\n선택이 취소 되었습니다.\r\n선택화면으로 돌아갑니다.");
			System.out.println("==================================================");
		} else {

			while (!(answer1.equals("y") || answer1.equals("Y") || answer1.equals("n") || answer1.equals("N"))) {

				System.out.println();
				System.out.print("잘못 입력하셨습니다. 반드시 Y/N 중에서 선택해주세요.\n" + "선택(Y/N) : ");
				answer1 = reader2.readLine();
				if (answer1.equals("y") || answer1.equals("Y")) {
					System.out.println();

					System.out.println();
					System.out.printf("'%s' 코스가 추가되었습니다.\n", menu); // 추가 되었을 시 라커번호에 저장.

					// =================================================
					// 주문내역 누적
					Item item = new Item();
					item.setCategory("세신으로 깔끔하게.");
					item.setMenu(menu);
					item.setPrice(price);
					item.setEa("1");
					locker.getLockers().get(item.getLockid()).getItems().add(item);
					Facilities.items.add(item);
					// =================================================

					System.out.println();
					System.out.println("메뉴 화면으로 이동 합니다.");
					System.out.println("==================================================");
				} else if (answer1.equals("n") || answer1.equals("N")) {
					System.out.print("\r\n선택이 취소 되었습니다.\r\n선택화면으로 돌아갑니다.");
					System.out.println("==================================================");

				}

			}
		}
	}

}
