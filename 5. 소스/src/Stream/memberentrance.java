package Stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class memberentrance {

	public static Scanner stdIn = new Scanner(System.in);
	public static int choice = 0;
	public void initial() {
		boolean loop = true;
		boolean loopchoice = true;
		while(loop) {
			
			while(loopchoice) {
				try {	
					begin();
					System.out.println("==================================================");
					System.out.println("1.목욕");
					System.out.println("2.목욕+찜질");
					System.out.println("3.뒤로가기");
					System.out.println("==================================================");
					
						stdIn = new Scanner(System.in);
						System.out.print("번호(숫자)를 입력하세요 : ");
						choice = stdIn.nextInt();
						System.out.println("==================================================");
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println();
						loopchoice = false;
					} catch (Exception e) {
					System.out.println("번호(숫자)가 아닙니다.");
					System.out.println("==================================================");
				}
				}
						
		
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
		
		
		boolean loopchoice = true;
		while(loopchoice) {
			try {
				System.out.println("==================================================");
				System.out.println("\t  오늘의 스페셜가마 : 참숯가마");
				System.out.println("\t\t$$보석방$$");
				System.out.println("\t\t$$황토방$$");
				System.out.println("\t\t$$소금방$$");
				System.out.println("\t\t$$얼음방$$");
				System.out.println("==================================================");
				
				System.out.println("1. 소인(남)-만7세 이하 : 7,000");
				System.out.println("2. 소인(여)-만7세 이하 : 7,000");
				System.out.println("3. 대인(남) : 12,000");
				System.out.println("4. 대인(여) : 12,000");
				System.out.println("5. 뒤로가기");
				System.out.println("==================================================");
				
					stdIn = new Scanner(System.in);
					System.out.print("번호(숫자)를 입력하세요 : ");
//					System.out.println("==================================================");
					choice = stdIn.nextInt();
					loopchoice = false;
				} catch (Exception e) {
				System.out.println("번호(숫자)가 아닙니다.");
				System.out.println("==================================================");
			}
			}
		
		locker temp = locker.getLockers().get(locker.getLockers().size()-1);
		
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

	private void getticketbath() {  //탕 티켓   - 유효성검사
		
		boolean loopchoice = true;
		while(loopchoice) {
			try {	
				System.out.println("==================================================");
				System.out.println("\t   오늘의 스페셜탕 : 아로마탕");
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
					stdIn = new Scanner(System.in);
					System.out.print("번호(숫자)를 입력하세요 : ");
					choice = stdIn.nextInt();
					System.out.println("==================================================");
					loopchoice = false;
				} catch (Exception e) {
				System.out.println("번호(숫자)가 아닙니다.");
				System.out.println("==================================================");
			}
			}		
		
		
		locker temp = locker.getLockers().get(locker.getLockers().size()-1);
		
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
		
		String milage = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(dat.memberdata));
			String list = null;
			while((list = reader.readLine())!=null) {
				String[] temp = list.split("\\|");
				if(locker.getLockers().get(locker.getLockers().size()-1).getMembership().equals(temp[0])) {
					milage = temp[9];
				}
			}
			reader.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}//멤버 읽어오기,마일리지 얻어오기
		
		
		boolean loopchoice = true;
		while(loopchoice) {
			try {	
				System.out.println("==================================================");
				System.out.printf("%s%s(을)를 선택했습니다.\n",locker.getLockers().get(locker.getLockers().size()-1).getPerson(),
						locker.getLockers().get(locker.getLockers().size()-1).getType());
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				
				System.out.println("사용할 수 있는 마일리지 "+milage);
				System.out.println("==================================================");
				System.out.println("1. 마일리지 사용");
				System.out.println("2. 마일리지 미사용");
				System.out.println("==================================================");
				
				
					stdIn = new Scanner(System.in);
					System.out.print("번호(숫자)를 입력하세요 : ");
					choice = stdIn.nextInt();
					System.out.println("==================================================");
					loopchoice = false;
				} catch (Exception e) {
				System.out.println("번호(숫자)가 아닙니다.");
				System.out.println("==================================================");
			}
			}		
				
		
		if(choice == 1) {
		
		
		System.out.print("사용할 마일리지 : ");
		int use = stdIn.nextInt();
		
		if(use>Integer.parseInt(milage)) {
			System.out.println("사용할 수 없는 마일리지입니다.");
			System.out.println("==================================================");
		}else {
			System.out.println("적립된 마일리지"+milage+"원");
			System.out.println("남은 마일리지 : "+(Integer.parseInt(milage)-use));
			System.out.println("선택 요금 : "+locker.getLockers().get(locker.getLockers().size()-1).getCharge());
			System.out.println("최종요금 : "+(locker.getLockers().get(locker.getLockers().size()-1).getCharge()-use));
			locker.getLockers().get(locker.getLockers().size()-1).setCharge(locker.getLockers().get(locker.getLockers().size()-1).getCharge()-use);
			System.out.println("==================================================");
			stdIn.nextLine();
			
			ArrayList<String>member = new ArrayList<String>();
			try {
				BufferedReader reader = new BufferedReader(new FileReader(dat.memberdata));
				String list = null;
				while((list = reader.readLine())!=null) {
					
					String[] temp = list.split("\\|");
					if(locker.getLockers().get(locker.getLockers().size()-1).getMembership().equals(temp[0])) {
						 temp[9]=(Integer.parseInt(temp[9])-use+(int)((locker.getLockers().get(locker.getLockers().size()-1).getCharge()-use)*0.05)+"");  //마일리지 5퍼 포함
						 System.out.println();
						 System.out.println("적립 후 마일리지 : " + temp[9]);  //마일리지 표시
						 System.out.println("==================================================");
					}
					member.add(temp[0]+"|"+temp[1]+"|"+temp[2]+"|"+temp[3]+"|"+temp[4]+"|"+temp[5]+"|"+temp[6]+"|"
					+temp[7]+"|"+temp[8]+"|"+temp[9]);
				}
				reader.close();
				
			} catch (Exception e) {

				System.out.println(e.toString());
			}//멤버 읽어오기,마일리지 얻어오기
			
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(dat.memberdata));
				for(String n : member) {
					writer.write(n+"\r\n");
				}
					
				writer.close();
			} catch (Exception e) { 
				System.out.println(e.toString());
				}
						
		}
		getlocker();  //라커번호 부여
		
		}//마일리지 사용
		else if(choice == 2) {
			System.out.printf("***%s %s를 선택했습니다***\n",locker.getLockers().get(locker.getLockers().size()-1).getPerson(),
					locker.getLockers().get(locker.getLockers().size()-1).getType());
			
			ArrayList<String>member = new ArrayList<String>();
			try {
				BufferedReader reader = new BufferedReader(new FileReader(dat.memberdata));
				String list = null;
				while((list = reader.readLine())!=null) {
					
					String[] temp = list.split("\\|");
					if(locker.getLockers().get(locker.getLockers().size()-1).getMembership().equals(temp[0])) {
						 temp[9]=(Integer.parseInt(temp[9])+(int)((locker.getLockers().get(locker.getLockers().size()-1).getCharge())*0.05))+"";  //마일리지 5퍼 포함
						 System.out.println("적립 후 마일리지 : " +temp[9]);  //마일리지 표시
						 System.out.println("==================================================");
					}
					member.add(temp[0]+"|"+temp[1]+"|"+temp[2]+"|"+temp[3]+"|"+temp[4]+"|"+temp[5]+"|"+temp[6]+"|"
					+temp[7]+"|"+temp[8]+"|"+temp[9]);
				}
				reader.close();
				
			} catch (Exception e) {

				System.out.println(e.toString());
			}//멤버 읽어오기,마일리지 얻어오기
			
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(dat.memberdata));
				for(String n : member) {
					writer.write(n+"\r\n");
				}
					
				writer.close();
			} catch (Exception e) { 
				System.out.println(e.toString());
				}
				
			getlocker(); //라커번호 부여
			//마일리지 미사용
		}else{ System.out.println("번호를 다시 입력해주세요.");
		System.out.println("==================================================");
		}
	}

	

	private void getlocker() {         //locker 번호 , pw 부여
		Random rnd = new Random();
		
		boolean loop = true;
		while(loop) {
			int lockid = rnd.nextInt(2000)+1;   //랜덤, 중복 라커번호 회피
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
				System.out.print("라커 번호 : ");
				System.out.println(locker.getLockers().get(locker.getLockers().size()-1).getLockernum());
				System.out.print("비밀번호 : ");
				System.out.println(locker.getLockers().get(locker.getLockers().size()-1).getLockerpw());
				System.out.println();
				loop=false;
				
			}
		}
		
		
		
	}

	public void begin() {
		System.out.println("==================================================");
		System.out.println("\t\t    추천 시설");
		System.out.println("\t$$언니 오빠 배만보면 빨래판 헬스장$$");
		System.out.println("\t$$오빤 강남스타일 노래방$$");
		System.out.println("\t$$황금마차 자판기$$");
		System.out.println("\t$$환상의 나라 황제 마사지$$");
		System.out.println("\t$$전좌석 안전벨트 PC$$");
		System.out.println("==================================================");
		
		
		
	}//시작메뉴
}
