package Stream;

import java.util.ArrayList;
import membership.*;
import resister.Register;

import java.util.Scanner;

import bath.Facilities_Shower;
import etc.Facilities_Login;

public class Main {
			
	public static void main(String[] args) {
//	ArrayList<locker>lockers =new ArrayList<locker>();
//	
//	locker.setLockers(lockers);
//	locker test = new locker();
//	lockers.add(test);
	
	first();
	
	}
	
	 public static void first() {
		 
		 System.out.println("                                                       \r\n" + 
		 		"                           :                           \r\n" + 
		 		"                    r      BD     .                    \r\n" + 
		 		"                   gB     gBQ    :Br                   \r\n" + 
		 		"                  KBB    PBBE    BBd                   \r\n" + 
		 		"                 JBB1   IBQB    SBQu                   \r\n" + 
		 		"                .BBB   iBQBu   .BBB                    \r\n" + 
		 		"                2BBB   EBQBv   XBBB                    \r\n" + 
		 		"                jBBB.  .BQBQ   .BQBJ                   \r\n" + 
		 		"                 BBBg   UBRBu   vBBB:                  \r\n" + 
		 		"                 vBQB7   BBQBi   gBBB.                 \r\n" + 
		 		"             :PB. BBBB   :BQBB   :BQBg .si             \r\n" + 
		 		"          JBBBBr  5BQBr   BQBB.   BRBB .BBBBv          \r\n" + 
		 		"       iQBBB7     PBQB.   BBBB   7BBBY    iBBBS        \r\n" + 
		 		"     .BQBBr       BBBX   rBQB:   BBBS       :BBBj      \r\n" + 
		 		"    .BQBB        dQBq    BBBi   BBQr          BBBb     \r\n" + 
		 		"    gQQBr       .QBU    dQB:   EBB            JBBB:    \r\n" + 
		 		"    PBRBg       :BP     BB.    BB             RBQB:    \r\n" + 
		 		"     BBQBB7      1      Bi     K.           iBBBBD     \r\n" + 
		 		"      gBBBBBPr                           .jBBBBBS      \r\n" + 
		 		"       :gBBBBBBBg17:               .ivPQBBBBBBg.       \r\n" + 
		 		"          sBBBBBQBBBBBBBQQgMgRQBBBBBBBBBBBBBU.         \r\n" + 
		 		"             iIMBBBQBBBBBQBQBBBBBBBBBQBQqr.            \r\n" + 
		 		"                  .i7uSdEMgMggZZKUvr.                  \r\n" + 
		 		" ");                                                      
		 
		 
		 
//		 for(int i=0; i<50; i++) {
//			 System.out.println();
//		 }
//		 
		 
		 
		 
		 
		Scanner stdIn = new Scanner(System.in);
		int choice =0;	
		boolean loop = true;	
		memberlogin memlogin = new memberlogin();
		nonmemberlogin nonlogin = new nonmemberlogin();
		receipt receiptin = new receipt();
		
		while(loop) {
			stdIn.reset();
//			begin();
			boolean loopchoice = true;
			
			while(loopchoice) {
			try {	begin();
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
			switch(choice) {
		case 1: 
				memlogin.initial();		 //회원 로그인 - id,pw 맞아야 locker 생성
				break;
		case 2:
				nonlogin.initial();		//비회원 로그인  - 비회원 로그인시 locker 생성
				break;
		case 3:
			membership.MemberRegister meber = new membership.MemberRegister();
				break;
				
		case 4:
			Register.main(null);
				break;
		case 5 :
			try {
				bath.Facilities_Shower.main(null);				
			} catch (Exception e) {

				System.out.println(e.toString());
			}
			break;
		case 6:
				try {
				etc.Facilities_Login.main(null);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
		case 7:
			receiptin.initial();
			break;
		case 8:
			loop = false;
			System.out.println();
			System.out.println("\t    이용해 주셔서 감사합니다.");
			break;
		default : {
			System.out.println("잘못된 입력입니다.");
		} 
			}
			
		}
	}
	public static void begin() {
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t\t  ♨ 양 떼 목 장 ♨");
		System.out.println("==================================================");
		
		System.out.println("\t\t1. 회원 로그인 ");
		System.out.println("\t\t2. 비회원 로그인");
		System.out.println("\t\t3. 회원가입 및 정보 수정");
		System.out.println("\t\t4. 관리자");
		System.out.println();
		System.out.println();
		System.out.println("\t\t5. 탕 이용");
		System.out.println("\t\t6. 부대시설이용");
		System.out.println("\t\t7. 계산하기");
		System.out.println("\t\t8. 종료");
		System.out.println("==================================================");
	}	
}



