package etc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Stream.locker;

public class Facilities_Pc {

	public static void main(String[] args) throws Exception {
//Pc방 
		pc();
	}

	public static void pc() throws Exception {
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));

		// 1번 선택시.
		System.out.println();
		System.out.println("================ 전좌석 안전벨트 PC ==============");
		System.out.println();
		System.out.println("====================단 일 선 택===================\n");

		// String path = "D:\\class\\java\\JavaProject\\dat\\ // window

		String path = ".\\dat\\PC.dat"; // mac

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			System.out.println("==============시간을 선택 해 주세요===============");
			System.out.println();
			String line = null;

			int n = 1;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("\\|");

				System.out.printf("%d %s %s\n", n, temp[1], temp[2]);
				n++;

			}

			System.out.println();
			System.out.println("0 뒤로가기");
			System.out.println();
			System.out.println("==================================================");
			System.out.println();
			System.out.print("선택 (번호 입력) : ");

			String choice = reader2.readLine();

			menu1(choice);

			reader.close();

		} catch (Exception e) {

		}
	}

	public static void menu1(String menu) throws Exception {

		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));

		boolean loop = true;

		while(loop) {
			
		if (menu.equals("1")) {
			menu = "1시간";
			pcroom(menu, reader2,1000);
			loop = false;

		} else if (menu.equals("2")) {
			menu = "2시간";
			pcroom(menu, reader2,2000);
			loop = false;

		} else if (menu.equals("3")) {
			menu = "3시간";
			pcroom(menu, reader2,2500);
			loop = false;

		} else if (menu.equals("4")) {
			menu = "6시간";
			pcroom(menu, reader2,5000);
			loop = false;

		} else if (menu.equals("5")) {
			menu = "8시간";
			pcroom(menu, reader2,6000);
			loop = false;

		} else if (menu.equals("0")) {
			System.out.println("뒤로가기를 선택 하셨습니다.\n선택화면으로 돌아갑니다.");
			loop = false;

		} else { // 잘못입력시..

			System.out.println();
			System.out.println("잘못 입력하셧습니다.");
			System.out.println("메뉴 번호로 반드시 입력해 주세요.");
			System.out.println("메뉴 선택창으로 돌아갑니다.");
			System.out.println();
			loop = false;
		}
		}
	}

	private static void pcroom(String menu, BufferedReader reader2,int price) throws IOException, Exception {

		System.out.println();
		System.out.printf("선택하신 메뉴는 '%s' 입니다.\n" + "이대로 계속하시겠습니까?(y/n) : ", menu);
		String answer1 = reader2.readLine();

		if (answer1.equals("y") || answer1.equals("Y")) {
			System.out.println();
			System.out.printf("'%s' 이용권이 추가되었습니다.\n", menu); // 추가 되었을 시 라커번호에 저장.
			System.out.println("초기 화면으로 돌아갑니다.");
		
			//=================================================
			//주문내역 누적
			Item item = new Item();
			item.setCategory("전좌석 안전벨트 pc");
			item.setMenu(menu);
			item.setPrice(price);
			item.setEa("1");
			
			locker.getLockers().get(item.getLockid()).getItems().add(item);
			Facilities.items.add(item);
			//=================================================
			
		} else if (answer1.equals("n") || answer1.equals("N")) {
			System.out.println("\r\n선택이 취소 되었습니다.\r\n선택 화면으로 돌아갑니다.");
			System.out.println();

		} else {

			while (!(answer1.equals("y") || answer1.equals("Y") || answer1.equals("n") || answer1.equals("N"))) {

				System.out.println();
				System.out.print("잘못 입력하셨습니다. 반드시 Y/N 중에서 선택 해주세요.\n" + "선택(Y/N) : ");
				answer1 = reader2.readLine();
				if (answer1.equals("y") || answer1.equals("Y")) {
					System.out.println();
					System.out.printf("'%s' 이용권이 추가되었습니다.\n", menu);// 추가 되었을 시 라커번호에 저장.
					System.out.println("초기 화면으로 돌아갑니다.");
					
					//=================================================
					//주문내역 누적
					Item item = new Item();
					item.setCategory("전좌석 안전벨트 pc");
					item.setMenu(menu);
					item.setPrice(price);
					item.setEa("1");
					locker.getLockers().get(item.getLockid()).getItems().add(item);
					Facilities.items.add(item);
					//=================================================
					System.out.println();

				} else if (answer1.equals("n") || answer1.equals("N")) {
					System.out.print("\r\n선택이 취소 되었습니다.\r\n선택화면으로 돌아갑니다.");
					System.out.println();

				}

			}

		}
	}
	
}
