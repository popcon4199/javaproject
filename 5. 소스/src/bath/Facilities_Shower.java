package bath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import Stream.locker;
import etc.Item;

public class Facilities_Shower {

	public static void main(String[] args) throws Exception {
	
		//부대시설 목욕탕
		//탕만 이용 고객
		if(validity()) {
			shower();
			
		}
		
}//main	

	
		private static boolean validity() {
					
			Scanner stdIn = new Scanner(System.in);
			int inputnum =0;
			boolean loop =true;
			while(loop){			
				try {
					System.out.println();
					stdIn = new Scanner(System.in);   //라커번호입력
					System.out.print("라커번호 : ");
					inputnum = stdIn.nextInt();
					stdIn.nextLine();
					loop =false;
					
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
				}
			}
				
				for(int i =0; i<locker.getLockers().size(); i++) {   //비밀번호 입력
					if(locker.getLockers().get(i).getLockernum()==inputnum) {
						System.out.print("비밀 번호 : ");
						String inputpw = stdIn.nextLine();
						if(locker.getLockers().get(i).getLockerpw().equals(inputpw)) {   //라커번호 찾기
							Item.setLockid(i); //라커번호 저장
//							System.out.println(receipt.num);
							return true;
						}
						
						
					}
				}
				
			return false;
			
	}


		public static void shower() throws Exception {
			//매점 으로 들어와 음료수, 스낵 따로 분리

			BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
			
			
			boolean loop = true;
			
			while(loop) {
				System.out.println();
				System.out.print("================ 천연 온천수 콸콸 ================\n");
				System.out.println();
				System.out.println("1. 있을건 다있소 \r\n\n"
						+ "2. 목욕후엔 바나나우유 \r\n\n"
						+ "3. 세신으로 깔끔하게..\r\n\n\n\n\n"
						+ "0. 뒤로가기");
				System.out.println("\n\n");
				System.out.println("번호(숫자)를 입력하세요 (1 , 2 , 3 , 0)");
				System.out.println();
				System.out.println();
				System.out.print("선택 : ");
	
				String choice = reader2.readLine();
				System.out.println("==================================================");
			if (choice.equals("1")) {
				System.out.println();
				System.out.println("비품을 선택 하셨습니다.\n비품 선택창으로 이동합니다.");
				Facilities_Shower_Supplies.showersupplies();
				
			
			} else if (choice.equals("2")) {
				System.out.println();
				System.out.println("목욕후엔 바나나우유를 선택 하셨습니다.\n음료 선택창으로 이동 합니다.");
				Facilities_Shower_Drink.drink();
			
			
			} else if (choice.equals("3")) {
				System.out.println();
				System.out.println("세신을 선택 하셨습니다.\n세신 코스로 이동 합니다.");
				Facilities_Shower_Ttaemiri.ttaemiri();
				
			
			} else if (choice.equals("0")){	
				System.out.println();
				System.out.println("뒤로가기를 선택하셨습니다.\n뒤로 이동합니다.");
				System.out.println();
				loop = false;
			
			} else {
				
				//잘못선택시.....
				while (!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("0"))) {

					System.out.println();
					System.out.print("잘못된 선택입니다. 반드시 1 , 2 , 3 , 0 중에서 선택 해주세요.\n\n"
										+ "선택(1 , 2 , 3, 0) : ");
					String choice2 = reader2.readLine();
					
					if (choice2.equals("1")) {
						System.out.println();
						System.out.println("있을건 다있소를 선택 하셨습니다.\n비품선택창으로 이동합니다.");
						Facilities_Shower_Supplies.showersupplies();
						
						
					} else if (choice2.equals("2")) {
						System.out.println();
						System.out.println("목욕후엔 바나나우유를 선택 하셨습니다.\n음료 선택창으로 이동합니다.");
						Facilities_Shower_Drink.drink();
						
					} else if (choice2.equals("3")){	
						System.out.println();
						System.out.println("가죽까지 벗겨드립니다를 선택 하셨습니다.\n세신 코스로 이동합니다.");
						System.out.println();
						Facilities_Shower_Ttaemiri.ttaemiri();
					
				
					
					} else if (choice2.equals("0")) {
						System.out.println();
						
						choice = "0";
					}
				}
			}
		}
	}
}
		
		
	
