package Stream;

import java.util.Random;
import java.util.Scanner;

public class nonmemberlogin {
	private static Scanner stdIn;
	private static int choice;

	static {
		choice=0;
		stdIn = new Scanner(System.in);
		
	}
	
	
	
	public void initial() {    
		locker temp = new locker();
		locker.getLockers().add(temp);
		locker.getLockers().get(locker.getLockers().size()-1).setMembership("비회원");
		
		boolean loop = true;
		while(loop) {
		begin();
		System.out.println("==================================================");
		System.out.println("1.목욕");
		System.out.println("2.목욕+찜질");
		System.out.println("3.뒤로가기");
		System.out.println("==================================================");
		
		Scanner stdIn = new Scanner(System.in);
		System.out.print("숫자를 선택해주세요 : ");
		int choice = stdIn.nextInt();
//		System.out.println("==================================================");
		
		switch(choice) {
		
		case 1 :
			locker.getLockers().get(locker.getLockers().size()-1).setType("목욕");
			getticketbath();
			loop=false;
			break;
		case 2 :
			locker.getLockers().get(locker.getLockers().size()-1).setType("목욕+찜질");
			getticketsauna();
			loop=false;
			break;
		case 3 :	
			loop=false;
			break;
		}
		
		}
	
		
		
	}

private void getticketsauna() {
	System.out.println("==================================================");
		System.out.println("\t   오늘의 스페셜가마 : 참숯가마");
		System.out.println("\t\t  $$보석방$$");
		System.out.println("\t\t  $$황토방$$");
		System.out.println("\t\t  $$소금방$$");
		System.out.println("\t\t  $$얼음방$$");
		System.out.println("==================================================");
		System.out.println("1. 소인(남)-만7세 이하 : 7,000");
		System.out.println("2. 소인(여)-만7세 이하 : 7,000");
		System.out.println("3. 대인(남) : 12,000");
		System.out.println("4. 대인(여) : 12,000");
		System.out.println("5. 뒤로가기");		
		System.out.println("==================================================");
		System.out.print("숫자를 선택해주세요 : ");
		locker temp = locker.getLockers().get(locker.getLockers().size()-1);
		int choice = stdIn.nextInt();
		switch(choice) {
		
		case 1 : 
			locker.getLockers().get(locker.getLockers().size()-1).setPerson("소인(남)");
			locker.getLockers().get(locker.getLockers().size()-1).setCharge(locker.getLockers().get(locker.getLockers().size()-1).getCharge()+7000);
			ticketinfo();
			break;
		case 2 :
			locker.getLockers().get(locker.getLockers().size()-1).setPerson("소인(여)");
			locker.getLockers().get(locker.getLockers().size()-1).setCharge(locker.getLockers().get(locker.getLockers().size()-1).getCharge()+7000);
			ticketinfo();
			break;
		case 3 :
			locker.getLockers().get(locker.getLockers().size()-1).setPerson("대인(남)");
			locker.getLockers().get(locker.getLockers().size()-1).setCharge(locker.getLockers().get(locker.getLockers().size()-1).getCharge()+12000);
			ticketinfo();
			break;
		case 4 :
			locker.getLockers().get(locker.getLockers().size()-1).setPerson("대인(여)");
			locker.getLockers().get(locker.getLockers().size()-1).setCharge(locker.getLockers().get(locker.getLockers().size()-1).getCharge()+12000);
			ticketinfo();
			break;
		case 5 :
			break;
		default : 
			System.out.println("잘못된 입력입니다.");
			System.out.println("==================================================");
			break;
		}
	}


	private void getticketbath() {  
		System.out.println("==================================================");
		System.out.println("\t    오늘의 스페셜탕 : 아로마탕");
		System.out.println("\t\t  $$가족탕$$");
		System.out.println("\t\t  $$노천온천$$");
		System.out.println("\t\t  $$녹차탕$$");
		System.out.println("\t\t  $$냉탕$$");
		System.out.println("==================================================");
		System.out.println("1. 소인(남)-만7세 이하 : 5,000");
		System.out.println("2. 소인(여)-만7세 이하 : 5,000");
		System.out.println("3. 대인(남) : 10,000");
		System.out.println("4. 대인(여) : 10,000");
		System.out.println("5. 뒤로가기");
		System.out.println("==================================================");
		locker temp = locker.getLockers().get(locker.getLockers().size()-1);
		System.out.print("숫자를 선택해주세요 : ");
		int choice = stdIn.nextInt();
		switch(choice) {
		
		case 1 : 
			locker.getLockers().get(locker.getLockers().size()-1).setPerson("소인(남)");
			locker.getLockers().get(locker.getLockers().size()-1).setCharge(locker.getLockers().get(locker.getLockers().size()-1).getCharge()+5000);
			ticketinfo();
			break;
		case 2 :
			locker.getLockers().get(locker.getLockers().size()-1).setPerson("소인(여)");
			locker.getLockers().get(locker.getLockers().size()-1).setCharge(locker.getLockers().get(locker.getLockers().size()-1).getCharge()+5000);
			ticketinfo();
			break;
		case 3 :
			locker.getLockers().get(locker.getLockers().size()-1).setPerson("대인(남)");
			locker.getLockers().get(locker.getLockers().size()-1).setCharge(locker.getLockers().get(locker.getLockers().size()-1).getCharge()+10000);
			ticketinfo();
			break;
		case 4 :
			locker.getLockers().get(locker.getLockers().size()-1).setPerson("대인(여)");
			locker.getLockers().get(locker.getLockers().size()-1).setCharge(locker.getLockers().get(locker.getLockers().size()-1).getCharge()+10000);
			ticketinfo();
			break;
		case 5 :
			break;
		default :
			System.out.println("잘못된 입력입니다.");
			System.out.println("==================================================");
			break;
		}
	}
			
	private void ticketinfo() {
		
		System.out.println();
		System.out.printf("***%s %s(을)를 선택했습니다***\n",locker.getLockers().get(locker.getLockers().size()-1).getPerson(),
				locker.getLockers().get(locker.getLockers().size()-1).getType());
		getlocker(); //라커번호 부여
		System.out.println("==================================================");
	}
		

	private void getlocker() {         //locker 번호 , pw 부여
		Random rnd = new Random();
		
		boolean loop = true;
		while(loop) {
			int lockid = rnd.nextInt(2000)+1;
			String lockpw = String.format("%04d",rnd.nextInt(10000));
			int cnt = 0;
			for(int i=0; i<locker.getLockers().size(); i++) {
				if(locker.getLockers().get(i).getLockernum()==lockid) {
					cnt++;
				}
			}
			if(cnt==0) {
				locker.getLockers().get(locker.getLockers().size()-1).setLockernum(lockid);
				locker.getLockers().get(locker.getLockers().size()-1).setLockerpw(lockpw);
				System.out.println();
				System.out.println("요금  "+locker.getLockers().get(locker.getLockers().size()-1).getCharge());
				System.out.print("라커번호  ");
				System.out.println(locker.getLockers().get(locker.getLockers().size()-1).getLockernum());
				System.out.print("비밀번호  ");
				System.out.println(locker.getLockers().get(locker.getLockers().size()-1).getLockerpw());
				loop=false;
				
			}
		}
		
		
		
	}

public void begin() {
	  	System.out.println();
	  	System.out.println();
		System.out.println("==================================================");
		System.out.println("\t\t    추천 시설");
		System.out.println("\t$$언니 오빠 배만보면 빨래판 헬스장$$");
		System.out.println("\t$$오빤 강남스타일 노래방$$");
		System.out.println("\t$$황금마차 자판기$$");
		System.out.println("\t$$환상의 나라 황제 마사지$$");
		System.out.println("\t$$전좌석 안전벨트 PC$$");
		System.out.println("==================================================");
		System.out.println();
		System.out.println();
		System.out.println();
		
	}//시작메뉴
	
	
}
