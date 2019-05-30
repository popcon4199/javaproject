package Stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class memberlogin {
private static String path = "";
private static BufferedReader list;
private static int choice;
private static Scanner stdIn;
static {
	choice=0;
	path = ".\\dat\\Member2.dat";
	stdIn = new Scanner(System.in);
	
}

public void initial() {   
	boolean loop = true;	 
	boolean loopchoice = true;
	while(loop) {

	while(loopchoice) {
		try {	
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("==================================================");
			System.out.println("1.로그인");
			System.out.println("2.뒤로 가기");
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
				
	while(!(choice==1 || choice==2)) {
		System.out.println("숫자를 다시 입력해주세요.");
		System.out.println("==================================================");
		choice = stdIn.nextInt();
	}
	
	if(choice==1) {
		 if(validity()) {
			 memberentrance entrance = new memberentrance();
			 entrance.initial();
			 loop = false;
		 }else {
			 loop = false;
		 }
		
		 
	}else if(choice==2) {
		loop = false;
	}
		 
	}
		 
	 }//회원 로그인 화면

private boolean validity() {  //아이디, 비밀번호 유효성 
	
	ArrayList<String>memberlist = new ArrayList<String>();
	String id="";
	String pw="";
	int cnt = 0;
	try {
		stdIn.nextLine();
		list = new BufferedReader(new FileReader(path)); 
		System.out.print("아이디를 입력해주세요 : ");
		 id = stdIn.nextLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		 pw = stdIn.nextLine();
		 System.out.println("==================================================");
		String member="";
		while((member = list.readLine())!=null) {
			memberlist.add(member);		
		}
		list.close();
	} catch (Exception e) {
		System.out.println(e.toString());
	}
	
	for(String mem : memberlist) {
		String[] temp = mem.split("\\|");
		if((id.equals(temp[1]))&&(pw.equals(temp[2]))) {
			System.out.printf("\t\t%s님 반갑습니다.\n",temp[3]);
			System.out.println("\t 계속하시려면 ENTER를 눌러주세요.");
			stdIn.nextLine();
			System.out.println();
			System.out.println();
			System.out.println();
			
			locker templocker = new locker();
			templocker.setMembership(temp[0]);
			locker.getLockers().add(templocker);   //임의의 라커 생성 
			
//			System.out.println(locker.getLockers().get(locker.getLockers().size()-1).getMembership());
			
			cnt=0;
			return true;
						
//			entrance.initial(); //회원 선택창
		}else {
					cnt++;
		}
			
	}
	
	if(cnt!=0) {
				System.out.println("아이디와 비밀번호가 틀립니다.");
				System.out.println("계속하시려면 ENTER를 눌러주세요.");
				stdIn.nextLine();
				System.out.println("==================================================");
				System.out.println();
	}
	
	return false;
		
}//validity
}
