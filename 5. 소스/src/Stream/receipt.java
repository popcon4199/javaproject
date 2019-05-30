package Stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import etc.Item;

public class receipt {
	private static Scanner stdIn = new Scanner(System.in);
	private static int id =-1;  //왜있지
	private static int choice =-1; //선택
	private static int num = -1; //라커 번호
	public void initial() {
		
		
		
			
		
		if(inputvalidity()) {  //라커 내역 출력
			System.out.println("==================================================");
			System.out.println("이용 내역");
			System.out.println("입장권");
			String type =locker.getLockers().get(num).getType();
			String person =locker.getLockers().get(num).getPerson();
			System.out.print(type+" "+person);
			System.out.println(locker.getLockers().get(num).getCharge());
			System.out.print(locker.getLockers().get(num).getLockernum());
			System.out.println("님의 이용 내역");
			System.out.println("==================================================");
			ArrayList<Item> item = locker.getLockers().get(Item.getLockid()).getItems();
			
			int total = 0;
			for(Item i : item) {
				System.out.printf("%-20s\t menu : %-15s\t 개수 : %2s\n",i.getCategory(),i.getMenu(),(i.getEa().equals(null) ? "1":i.getEa()));				
				total += Integer.parseInt(i.getEa())*i.getPrice();
			}
			System.out.println();
			System.out.printf("총액 : %,d\n",total);
			calcualte(); //계산하기
			System.out.println("==================================================");
			
		}else {
			System.out.println("다시 입력해주세요.");
			System.out.println("==================================================");
		}
		
		
		
		
	}

	private void calcualte() {
		int inputnum =0;
		boolean loop =true;
		int cnt = 0;
		while(loop){			
			try {
				System.out.println("==================================================");
				System.out.println("1.계산하기");
				System.out.println("2.뒤로가기");
				stdIn = new Scanner(System.in);   //라커번호
				System.out.println("번호를 입력하세요.");
				System.out.println("==================================================");
				inputnum = stdIn.nextInt();
				stdIn.nextLine();
				loop =false;				
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				System.out.println("==================================================");
			}
		}
		if(inputnum == 1) { 		//회원의 경우 회원 이름 출력
			String member =locker.getLockers().get(num).getMembership();
			try {
				BufferedReader reader = new BufferedReader(new FileReader(dat.memberdata));
				String line = null;
				while((line=reader.readLine())!=null) {
					String[] temp = line.split("\\|");
					if(member.equals(temp[0])) {
						System.out.println(temp[3]+"님 ");
						System.out.println("==================================================");
					}
				}reader.close();
			} catch (Exception e) {
				System.out.println(e.toString());
			}			
			
			System.out.println("==================영수증==========================");
			
			ArrayList<Item> item = locker.getLockers().get(Item.getLockid()).getItems();
			int total = 0;
			for(Item i : item) {
				System.out.printf("%-20s\t menu : %-15s\t 개수 : %2s\n",i.getCategory(),i.getMenu(),(i.getEa().equals(null) ? "1":i.getEa()));				
				total+=Integer.parseInt(i.getEa())*i.getPrice();
			}
			System.out.println();
			System.out.printf("총액 : %,d\n",total);
			locker.getLockers().remove(num);
			
			
		}else if(inputnum==2) {
			
		}else {
			System.out.println("잘못된 입력입니다.");
			System.out.println("==================================================");
		}
		
	}

//	private void lkremove() {
//		boolean loop = true;
//		int inputnum = 0;
//		while(loop){			
//			try {
//				System.out.println("==================================================");
//				System.out.println("1.키 반납하기");
//				System.out.println("2.뒤로가기");
//				System.out.println("==================================================");
//				stdIn = new Scanner(System.in);   //라커번호
//				System.out.println("번호를 입력하세요.");
//				System.out.println("==================================================");
//				inputnum = stdIn.nextInt();
//				stdIn.nextLine();
//				loop =false;				
//			} catch (Exception e) {
//				System.out.println("잘못된 입력입니다.");
//				System.out.println("==================================================");
//			}
//		}
//		if(inputnum==1) {
//			locker.getLockers().remove(num);		//해당 라커 삭제
////			System.out.println(locker.getLockers());
//		}else if(inputnum==2) {
//			
//		}else {
//			System.out.println("잘못된 입력입니다.");
//			System.out.println("==================================================");
//		}
//		
//		
//	}

	private boolean inputvalidity() {   //라커번호 저장
		
		int inputnum =0;
		boolean loop =true;
		while(loop){			
			try {
				stdIn = new Scanner(System.in);   //라커번호입력
				System.out.print("라커번호 :");
				inputnum = stdIn.nextInt();
				stdIn.nextLine();
				loop =false;
				
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				System.out.println("==================================================");
			}
		}
			
			for(int i =0; i<locker.getLockers().size(); i++) {   //비밀번호 입력
				if(locker.getLockers().get(i).getLockernum()==inputnum) {
					System.out.print("비밀 번호 :");
					String inputpw = stdIn.nextLine();
					if(locker.getLockers().get(i).getLockerpw().equals(inputpw)) {   //라커번호 찾기
//						id=inputnum;
						receipt.num = i;
//						System.out.println(receipt.num);
						return true;
					}
					
					
				}
			}
			
		return false;
		
		
		
	}//inputvalidity

}//class recipte
