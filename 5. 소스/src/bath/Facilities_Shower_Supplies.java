package bath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Stream.locker;
import etc.Facilities;
import etc.Item;

public class Facilities_Shower_Supplies {
	public static void main(String[] args) throws Exception {

		showersupplies();
		//탕 비품
	}

	public static void showersupplies() throws Exception {
		  System.out.println();
	      System.out.println("============== 있을건 다있소 #비품# ==============");
	   
		  System.out.println();
		 
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));


		String path = ".\\dat\\showerSupplies.dat";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));

			System.out.println("============== 메뉴를 선택해 주세요 ==============");
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
				menu = "이태리타월";
				supplies(menu, reader2,500);
				loop = false;

			} else if (menu.equals("2")) {
				menu = "린스";
				supplies(menu, reader2,1000);
				loop = false;

			} else if (menu.equals("3")) {
				menu = "바디워시";
				supplies(menu, reader2,1500);
				loop = false;

			} else if (menu.equals("4")) {
				menu = "바디로션";
				supplies(menu, reader2,1500);
				loop = false;

			} else if (menu.equals("5")) {
				menu = "면도기";
				supplies(menu, reader2,500);
				loop = false;
				
			} else if (menu.equals("6")) {
				menu = "폼클렌징";
				supplies(menu, reader2,1000);
				loop = false;

			} else if (menu.equals("7")) {
				menu = "칫솔";
				supplies(menu, reader2,1000);
				loop = false;

			} else if (menu.equals("8")) {
				menu = "양말";
				supplies(menu, reader2,2000);
				loop = false;

			} else if (menu.equals("9")) {
				menu = "속옷";
				supplies(menu, reader2,3000);
				loop = false;

			} else if (menu.equals("10")) {
				menu = "샴푸";
				supplies(menu, reader2,1000);
				loop = false;

			} else if (menu.equals("0")) {
				System.out.println("'뒤로가기'를 선택하셨습니다.\n선택화면으로 돌아갑니다.");
				loop = false;

			} else { // 잘못입력시...

				System.out.println();
				System.out.println("잘못 입력하셧습니다.");
				System.out.println("비품 번호로 반드시 입력해 주세요.");
				System.out.println("선택창으로 돌아갑니다.");
				System.out.println();
				loop = false;

			}
		}
	}

	private static void supplies(String menu, BufferedReader reader2,int price) throws IOException {

		System.out.println();
		System.out.print("개수 입력 : ");
		int number = Integer.parseInt(reader2.readLine());

		System.out.println();
		System.out.printf("선택하신 비품은 '%s', 수량은 %d개 입니다.\n" + "이대로 계속하시겠습니까?(y/n) : ", menu, number);
		String answer1 = reader2.readLine();

		if (answer1.equals("y") || answer1.equals("Y")) {
			System.out.println();
			System.out.printf("'%s' %d개가 추가되었습니다.\n", menu, number); // 추가 되었을 시 라커번호에 저장.
			
			//=================================================
			//주문내역 누적
			Item item = new Item();
			item.setCategory("있을건 다있소");
			item.setMenu(menu);
			item.setEa(number + "");
			item.setPrice(price);
			
			locker.getLockers().get(item.getLockid()).getItems().add(item);
			Facilities.items.add(item);
			//=================================================
			
			System.out.println();

		} else if (answer1.equals("n") || answer1.equals("N")) {
			System.out.println("\r\n선택이 취소되었습니다.\r\n선택화면으로 돌아갑니다.");

		} else {

			while (!(answer1.equals("y") || answer1.equals("Y") || answer1.equals("n") || answer1.equals("N"))) {

				System.out.println();
				System.out.print("잘못 입력하셨습니다. 반드시 Y/N 중에서 선택해주세요.\n" + "선택(Y/N) : ");
				answer1 = reader2.readLine();
				if (answer1.equals("y") || answer1.equals("Y")) {
					System.out.println();

					System.out.println();
					System.out.printf("'%s' %d개가 추가되었습니다.\n", menu, number); // 추가 되었을 시 라커번호에 저장.

					//=================================================
					//주문내역 누적
					Item item = new Item();
					item.setCategory("있을건다있소");
					item.setMenu(menu);
					item.setEa(number + "");
					item.setPrice(price);
					
					locker.getLockers().get(item.getLockid()).getItems().add(item);
					Facilities.items.add(item);
					//=================================================
					
					System.out.println();
					System.out.println("메뉴 화면으로 이동 합니다.");
					

				} else if (answer1.equals("n") || answer1.equals("N")) {
					System.out.print("\r\n선택이 취소 되었습니다.\r\n선택화면으로 돌아갑니다.");

				}

			}
		}
	}

}


