package etc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Stream.locker;



public class Facilities_Restaurant {


	public static void main(String[] args) throws Exception {

		// 부대시설 식당.
		restaurant();

	}// main

	public static void restaurant() throws Exception {

		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));

		// 2번 선택시.
		System.out.println();
		   System.out.println("================== 장모님의 손맛 =================");
		System.out.println();
		   System.out.println("================== 다중선택 가능 =================\n");

		// String path = "D:\\class\\java\\JavaProject\\dat\\Restaurant.dat";
		
		String path = ".\\dat\\restaurant.dat";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));

			System.out.println("============== 메뉴를 선택 해 주세요 =============\n");

			String line = null;

			int n = 1;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("\\|");

				System.out.printf("%d. %s %s\n", n, temp[1], temp[2]);
				n++;
			}

			System.out.println();
			System.out.println("0 뒤로가기");
			System.out.println();
			System.out.println("==================================================");
			System.out.print("선택 (번호 입력) : ");
			String choice = reader2.readLine();
			System.out.println("==================================================");

			menu1(choice);

			reader.close();

		} catch (Exception e) {

		}
	}

	public static void menu1(String menu) throws Exception {

		boolean loop = true;

		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));

		while (loop) {

			if (menu.equals("1")) {
				menu = "미역국";
				food(menu, reader2,6000);
				loop = false;

			} else if (menu.equals("2")) {
				menu = "된장찌개";
				food(menu, reader2,7000);
				loop = false;

			} else if (menu.equals("3")) {
				menu = "김치찌개";
				food(menu, reader2,7000);
				loop = false;

			} else if (menu.equals("4")) {
				menu = "제육쌈밥";
				food(menu, reader2,8000);
				loop = false;

			} else if (menu.equals("5")) {
				menu = "라면";
				food(menu, reader2,4000);
				loop = false;

			} else if (menu.equals("6")) {
				menu = "떡만둣국";
				food(menu, reader2,6000);
				loop = false;

			} else if (menu.equals("7")) {
				menu = "국수";
				food(menu, reader2,6000);
				loop = false;

			} else if (menu.equals("8")) {
				menu = "우동";
				food(menu, reader2,6000);
				loop = false;

			} else if (menu.equals("9")) {
				menu = "돈까스";
				food(menu, reader2,10000);
				loop = false;

			} else if (menu.equals("10")) {
				menu = "치킨";
				food(menu, reader2,15000);
				loop = false;

			} else if (menu.equals("0")) {
				System.out.println("뒤로가기를 선택 하셨습니다.\n선택화면으로 돌아갑니다.");
				loop = false;

			} else { // 잘못입력시...

				System.out.println();
				System.out.println("잘못 입력하셧습니다.");
				System.out.println("코스 번호로 반드시 입력해 주세요.");
				System.out.println("코스 선택창으로 돌아갑니다.");
				System.out.println();
				loop = false;

			}
		}
		// else

		// 개수if

	}// restaurant

	private static void food(String menu, BufferedReader reader2,int price) throws IOException, Exception {
		System.out.print("개수 입력 : ");
		int number = Integer.parseInt(reader2.readLine());
		System.out.println();
		System.out.printf("선택하신 음식은 '%s' 수량은 %d개 입니다.\n" + "이대로 계속하시겠습니까?(y/n) : ", menu, number);
		String answer1 = reader2.readLine();

		if (answer1.equals("y") || answer1.equals("Y")) {
			System.out.println();
			System.out.printf("'%s' %d개가 추가되었습니다.\n", menu, number); // 추가 되었을 시 라커번호에 저장.

			//=================================================
			//주문내역 누적
			Item item = new Item();
			item.setCategory("장모님의 손길");
			item.setMenu(menu);
			item.setEa(number + "");
			item.setPrice(price);
			
			locker.getLockers().get(item.getLockid()).getItems().add(item);
			Facilities.items.add(item);
			//=================================================

		} else {

			while (!(answer1.equals("y") || answer1.equals("Y") || answer1.equals("n") || answer1.equals("N"))) {

				System.out.println();
				System.out.print("잘못 입력하셨습니다. 반드시 Y/N 중에서 선택 해주세요.\n" + "선택(Y/N) : ");
				answer1 = reader2.readLine();
				if (answer1.equals("y") || answer1.equals("Y")) {
					System.out.println();
					System.out.printf("'%s' %d개가 추가되었습니다.", menu, number);// 추가 되었을 시 라커번호에 저장.

					//=================================================
					//주문내역 누적
					Item item = new Item();
					item.setCategory("장모님의 손길");
					item.setMenu(menu);
					item.setEa(number+"");
					item.setPrice(price);
					
					locker.getLockers().get(item.getLockid()).getItems().add(item);
					Facilities.items.add(item);
					//=================================================
										
					
					System.out.println("메뉴 화면으로 돌아갑니다.");

				} else if (answer1.equals("n") || answer1.equals("N")) {
					System.out.print("\r\n선택이 취소 되었습니다.\r\n선택화면으로 돌아갑니다.");

				}

			}

		}
	}

	

}// class
