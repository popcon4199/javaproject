package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Facilities_Main {

	public static void main(String[] args) throws Exception {
	
		 main(); //라카번호 로그인 상민이형이랑 합칠 부분..
		
		
}

	public static void main() throws Exception {
		// 라커번호로 로그인 후 결제.
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println();
		System.out.println("부대시설을 이용, 결제하기 위해서 라커번호와 비밀번호가 필요합니다.");
		System.out.println();
		System.out.println("1. 라커 번호 및 비밀번호 입력");
		
		System.out.println("2. 뒤로가기");
		System.out.println();
		
		String choice = reader2.readLine();
		
		if (choice.equals("1")) {		//로그인
			
			
		} else if (choice.equals("2")) {	//뒤로가기
			System.out.println("뒤로가기");
		
		} else {
			System.out.println();
			System.out.println("잘못 입력하셧습니다.");
			System.out.println("선택은 번호로 반드시 입력해 주세요.");
			
			System.out.println();
			Facilities_Main.main();
		
		}
		
	}
}
