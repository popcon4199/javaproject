package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Facilities_Mart {

	public static void main(String[] args) throws Exception {
		
		Mart();
		//매점
	}

	public static void Mart() throws Exception {
		//매점 으로 들어와 음료수, 스낵 따로 분리

		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println();
		System.out.print("==================== 황 금 마 차 =================\n");
		System.out.println();
		System.out.println("1. 스낵 \r\n2. 자판기 \r\n\n\n\n\n3. 뒤로가기");
		System.out.println("\n\n");
		System.out.println("숫자로 선택해주세요 (1 , 2 , 3)");
		System.out.println();
		System.out.println("==================================================");
		System.out.print("선택 : ");
		String choice = reader2.readLine();
		
		boolean loop = true;
		
		while(loop) {
		
		if (choice.equals("1")) {
			System.out.println();
			System.out.println("스낵을 선택하셨습니다.\n스낵코너로 이동합니다.");
			Facilities_Mart_Snack.snack();
			loop = false;
		
		} else if (choice.equals("2")) {
			System.out.println();
			System.out.println("자판기를 선택하셨습니다.\n자판기 코너로 이동합니다.");
			Facilities_Mart_Drink.drink();
			loop = false;
		
		} else if (choice.equals("3")) {
			System.out.println();
			System.out.println("뒤로가기를 선택하셨습니다.\n뒤로 이동합니다.");
			loop = false;
			
		
		
		} else {
			
			//잘못선택시.....
			while (!(choice.equals("1") || choice.equals("2") || choice.equals("3"))) {

				System.out.println();
				System.out.print("잘못된 선택입니다. 반드시 1 , 2 , 3 중에서 선택해주세요.\n\n"
									+ "선택(1 , 2 , 3) : ");
				String choice2 = reader2.readLine();
				
				if (choice2.equals("1")) {
					System.out.println();
					System.out.println("스낵을 선택하셨습니다.\n스낵코너로 이동합니다.");
					Facilities_Mart_Snack.snack();
					
					
				} else if (choice2.equals("2")) {
					System.out.println();
					System.out.println("자판기를 선택하셨습니다.\n자판기 코너로 이동합니다.");
					Facilities_Mart_Drink.drink();
					
					
				} else if (choice2.equals("3")) {
					System.out.println();
					
					choice = "3";
				}
			}
		}
		}		
		}//main
}//class
