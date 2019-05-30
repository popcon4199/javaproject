package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import Stream.locker;
import Stream.receipt;


public class Facilities_Login {
	
	
	public static void main(String[] args) throws Exception {

		if(validity()) {
			Facilities.facilities();
		};
		// login(); //상민이형이랑 합 칠 부분.. 

	}// main

	private static boolean validity() {
		
		Scanner stdIn = new Scanner(System.in);
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
			}
		}
			
			for(int i =0; i<locker.getLockers().size(); i++) {   //비밀번호 입력
				if(locker.getLockers().get(i).getLockernum()==inputnum) {
					System.out.print("비밀 번호 :");
					String inputpw = stdIn.nextLine();
					if(locker.getLockers().get(i).getLockerpw().equals(inputpw)) {   //라커번호 찾기
//						id=inputnum;
						if(!locker.getLockers().get(i).getType().equals("목욕+찜질")) {
							System.out.println();
							System.out.println("\t\t목욕+찜질 입장권을 구매하셔야 합니다.");
							return false;
						}else {
							Item.setLockid(i); //라커번호 저장
//						System.out.println(receipt.num);
							return true;							
						}
					}
					
					
				}
			}
			
		return false;
		
		
	}

	public static void login() throws Exception {
		// 1번 선택 후 로그인창
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));

		System.out.println();
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		System.out.println();
		System.out.println("회원님의 정보를 확인하기 위해 로그인이 필요합니다.");
		System.out.println();
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		System.out.println();

		System.out.println("라카번호를 입력 해주세요");
		System.out.println();
		System.out.print("라카번호 : ");
		int num = Integer.parseInt(reader2.readLine());
		System.out.println("뒤로가기 : 0 ");
		String answer = reader2.readLine();
		
		System.out.println();
		
boolean loop = true;

while(loop) {
		
		if (num >= 1 && num <= 2000) { 	//라카번호 유효성  
			System.out.printf("%d 번을 입력 하셨습니다.\n", num);
			System.out.println("맞으면 1번 / 다시 입력하시려면 2 번을 입력해주세요.");
			String number = reader2.readLine(); // 라카번호 확인.
			
			ps(reader2, num);
			loop = false;
			
		} else if (answer.equals("0")) {
			System.out.println("뒤로가기를 선택하셨습니다.");
			loop = false;
			
		} else { 
			System.out.println("조건에 맞지 않는 선택을 하셨습니다.\n초기화면으로 이동합니다.");
			loop = false;
		}
			
}
	}// login

	private static void ps(BufferedReader reader2, int num) throws IOException {
		System.out.print("비밀번호 : ");
		String ps = reader2.readLine();
		
		System.out.println();
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		
		if(ps.equals(num)) {
			System.out.println("로그인 되었습니다.");
		} else {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("다시 입력해주세요.");
		}
	}

}// clss
