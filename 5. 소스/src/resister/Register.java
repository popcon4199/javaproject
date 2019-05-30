package resister;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Register {

	private static Register register;
	private static Scanner scan;
	private static String newPath;
	private static int count;
	private static int dirCount;
	private static int selectMenu;
	private static int orders;
	private static ArrayList<String> fileName;
	private static String dirName;
	private static long lastMonthTotal;
	private static long monthTotal;

	static {
		register = new Register();
		scan = new Scanner(System.in);
		count = 1;
		dirCount = 0;
		selectMenu = -1;
		orders = -1;
		fileName = new ArrayList<String>();
		lastMonthTotal = 0;
		monthTotal = 0;
	}

	public static void main(String[] args) {
		register.start();
		//register.memberAge();
	}// main

//-------------------------------------------------------------------------------------------------------------------------

	// 관리자메뉴 초기화면
	private void start() {
		System.out.println();
		System.out.println();
		System.out.println("==================================================");
		System.out.println("\t\t1. 로그인");
		System.out.println("\t\t2. 뒤로가기");
		System.out.println("==================================================");

		System.out.print("번호(숫자)를 입력하세요 : ");
		String input = scan.nextLine();
		System.out.println("==================================================");
		System.out.println();
		System.out.println();

		if (input.equals("1")) {
			login();
		} else if (input.equals("2")) {
			// 메인으로
		} else {
			System.out.println();
			System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.println();
    	 start();
		}

	}// start

//-------------------------------------------------------------------------------------------------------------------------

	// 로그인 화면
	private void login() {
		System.out.print("아이디 : ");
		String id = scan.nextLine();

		System.out.print("비밀번호 : ");
		String password = scan.nextLine();

		// 관리자로 로그인시 관리자메뉴로 이동
		if (id.equals("admin") && password.equals("admin")) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t\t관리자님 반갑습니다.");
			adminMenu();
			// 관리자 ID가 아닐 시
		} else {
			System.out.println();
			System.out.println();
			System.out.println("ID와 PW를 다시 확인해 주십시오.");
			System.out.println();
			System.out.println();
    	  start();
		}

	}// login

//-------------------------------------------------------------------------------------------------------------------------

	// 로그인 후 관리자화면
	private void adminMenu() {

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("==================================================");
		System.out.println("1. 회원정보 관리");
		System.out.println("2. 재고 및 매출 관리");
		System.out.println("3. 뒤로 가기");
		System.out.println("==================================================");

		System.out.print("선택(번호) : ");
		String input = scan.nextLine();
		System.out.println("==================================================");
		if (input.equals("1")) {
			memberMenu();
		} else if (input.equals("2")) {
			management();
		} else if (input.equals("3")) {
			start();
		} else {
			System.out.println();
			System.out.println("번호(숫자)를 다시 입력해 주세요.");
			System.out.println();
    	   adminMenu();
		}

	}// adminMenu()

//-------------------------------------------------------------------------------------------------------------------------

	// 1. 회원정보 관리
	private void memberMenu() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("==================================================");
		System.out.println("\t\t1. 회원정보 보기");
		System.out.println("\t\t2. 회원 조건별 검색");
		System.out.println("\t\t3. 뒤로 가기");
		System.out.println("==================================================");

		System.out.print("선택(번호) : ");
		String input = scan.nextLine();
		System.out.println("==================================================");

		if (input.equals("1")) {
			memberView();
		} else if (input.equals("2")) {
			memberSearch();
		} else if (input.equals("3")) {
			adminMenu();
		} else {
			System.out.println();
			System.out.println("번호(숫자)를 다시 입력해 주세요.");
			System.out.println();
    	   memberMenu();
		}

	}// memberMenu()

//-------------------------------------------------------------------------------------------------------------------------

	// 1. 회원정보 관리 - 1. 회원정보 보기
	public void memberView() {

		try {

			BufferedReader reader = new BufferedReader(new FileReader(FilePath.MEMBER));
			System.out.println(
					"=====================================================================================================================================================");
			System.out.println("[회원번호] [아이디]     [비밀번호]    [이름]   [나이]    [성별]    [주소]\t\t[전화번호]\t\t[등록일]\t\t[마일리지]");

			String line = null;

			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("\\|"); // temp[0] = sy001
				System.out.printf("  %-6s     %-8s      %-8s     %-4s     %s       %s      %12s\t%s\t%s\t     %s\r\n", temp[0], temp[1], temp[2],
						temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
			}
			reader.close();

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t\t\t- 아무키나 누르면 뒤로 이동합니다.");
			String input = scan.nextLine();

			for (int i = 0; i < 40; i++) {

				System.out.println();
			}

//         System.out.println();
//         System.out.println();
//         System.out.println();
//         System.out.println();
//         System.out.println();
//         System.out.println();
//         System.out.println();
//         System.out.println();
//         System.out.println();
//         System.out.println();

			if (input != null)
				memberMenu();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}// memberView

//-------------------------------------------------------------------------------------------------------------------------

	// 1. 회원정보 관리 - 2. 회원 조건별 검색
	public void memberSearch() {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(FilePath.MEMBER));

			System.out.println();
			System.out.println("1.회원번호");
			System.out.println("2.아이디");
			System.out.println("3.이름");
			System.out.println("4.나이");
			System.out.println("5.성별(true=남,false=여)");
			System.out.println("6.주소");
			System.out.println("7.전화번호");
			System.out.println("8.등록일");
			System.out.println("9.뒤로가기");

			System.out.println();
			System.out.println("==================================================");
			System.out.print("선택(번호) : ");
			String input = scan.nextLine();
			System.out.println("==================================================");
			for (int i = 0; i < 40; i++) {
				System.out.println();
			}
			if (input.equals("1")) {
				memberNum();
			} else if (input.equals("2")) {
				memberID();
			} else if (input.equals("3")) {
				memberName();
			} else if (input.equals("4")) {
				memberAge();
			} else if (input.equals("5")) {
				memberGender();
			} else if (input.equals("6")) {
				memberAdress();
			} else if (input.equals("7")) {
				memberPhoneNum();
			} else if (input.equals("8")) {
				memberDate();
			} else if (input.equals("9")) {
				memberMenu();
			} else {
				System.out.println("번호(숫자)를 다시 입력해 주세요 ");
	            memberSearch();
			}
			reader.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}// memberSearch()

//-------------------------------------------------------------------------------------------------------------------------

	// 1. 회원정보 관리 - 2. 회원 조건별 검색 - 1. 회원 번호
	private void memberNum() {
		System.out.println();
		System.out.println();
		System.out.println(
				"=========================================================================================================================================");
		System.out.print("회원번호:");
		String input = scan.nextLine();
		System.out.println(
				"==========================================================================================================================================");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FilePath.MEMBER));

			System.out.println("[회원번호]  [아이디]     [비밀번호]    [이름]   [나이]    [성별]            [주소]\t\t[전화번호]\t[등록일]\t[마일리지]");

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split("\\|");

				if (input.equals(temp[0])) {
					System.out.printf("  %-6s     %-8s      %-8s     %-4s     %s       %s      %12s\t%s\t%s\t     %s\r\n", temp[0], temp[1], temp[2],
							temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
				}
			}
			reader.close();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t\t\t- 아무키나 누르면 뒤로 이동합니다.");
			input = scan.nextLine();

			for (int i = 0; i < 40; i++) {

				System.out.println();
			}
         if(input!=null)
        	 memberSearch();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// memberNum

//-------------------------------------------------------------------------------------------------------------------------

	// 1. 회원정보 관리 - 2. 회원 조건별 검색 - 2. 아이디
	private void memberID() {

		System.out.println(
				"=========================================================================================================================================");
		System.out.print("아이디:");
		String input = scan.nextLine();
		System.out.println(
				"=========================================================================================================================================");

		try {
			BufferedReader reader = new BufferedReader(new FileReader(FilePath.MEMBER));

			System.out.println("[회원번호]  [아이디]     [비밀번호]    [이름]   [나이]    [성별]            [주소]\t\t[전화번호]\t[등록일]\t[마일리지]");

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split("\\|");

				if (input.equals(temp[1])) {

					System.out.printf("  %-6s     %-8s      %-8s     %-4s     %s       %s      %12s\t%s\t%s\t     %s\r\n", temp[0], temp[1], temp[2],
							temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
				}
			}
			reader.close();

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t\t\t- 아무키나 누르면 뒤로 이동합니다.");
			input = scan.nextLine();
			
			for(int i=0; i<40; i++) {
	        	 
	        	 System.out.println();
	         }
         if(input!=null)
        	 memberSearch();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// memberID()

//-------------------------------------------------------------------------------------------------------------------------

	// 1. 회원정보 관리 - 2. 회원 조건별 검색 - 3. 이름
	private void memberName() {

		System.out.println(
				"=========================================================================================================================================");
		System.out.print("이름:");
		String input = scan.nextLine();
		System.out.println(
				"=========================================================================================================================================");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FilePath.MEMBER));
 
			System.out.println("[회원번호]  [아이디]     [비밀번호]    [이름]   [나이]    [성별]            [주소]\t\t[전화번호]\t[등록일]\t[마일리지]");

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split("\\|");

				if (input.equals(temp[3])) {

					System.out.printf("  %-6s     %-8s      %-8s     %-4s     %s       %s      %12s\t%s\t%s\t     %s\r\n", temp[0], temp[1], temp[2],
							temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
				}
			}
			reader.close();

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t\t\t- 아무키나 누르면 뒤로 이동합니다.");
			input = scan.nextLine();
			
			for(int i=0; i<40; i++) {
	        	 
	        	 System.out.println();
	         }
         if(input!=null)
        	 memberSearch();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// memberName()

	// -------------------------------------------------------------------------------------------------------------------------

	// 1. 회원정보 관리 - 2. 회원 조건별 검색 - 4. 나이
	private void memberAge() {

		System.out.println(
				"=========================================================================================================================================");
		System.out.print("나이:");
		String input = scan.nextLine();
		System.out.println(
				"=========================================================================================================================================");

		try {
			BufferedReader reader = new BufferedReader(new FileReader(FilePath.MEMBER));

			System.out.println("[회원번호]  [아이디]     [비밀번호]    [이름]   [나이]    [성별]            [주소]\t\t[전화번호]\t[등록일]\t[마일리지]");

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split("\\|");

				if (input.equals(temp[4])) {

					System.out.printf("  %-6s     %-8s      %-8s     %-4s     %s       %s      %12s\t%s\t%s\t     %s\r\n", temp[0], temp[1], temp[2],
							temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
				}
			}
			reader.close();

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t\t\t- 아무키나 누르면 뒤로 이동합니다.");
			input = scan.nextLine();
			
			for(int i=0; i<40; i++) {
	        	 
	        	 System.out.println();
	         }
         if(input!=null)
        	 memberSearch();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// memberAge()

//-------------------------------------------------------------------------------------------------------------------------

	// 1. 회원정보 관리 - 2. 회원 조건별 검색 - 5.성별(true=남,false=여)
	private void memberGender() {

		System.out.println(
				"=========================================================================================================================================");
		System.out.print("성별:");
		String input = scan.nextLine();
		System.out.println(
				"=========================================================================================================================================");

		try {
			BufferedReader reader = new BufferedReader(new FileReader(FilePath.MEMBER));

			System.out.println("[회원번호]  [아이디]     [비밀번호]    [이름]   [나이]    [성별]            [주소]\t\t[전화번호]\t[등록일]\t[마일리지]");

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split("\\|");

				if (input.equals(temp[5])) {

					System.out.printf("  %-6s     %-8s      %-8s     %-4s     %s       %s      %12s\t%s\t%s\t     %s\r\n", temp[0], temp[1], temp[2],
							temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
				}
			}
			reader.close();

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t\t\t- 아무키나 누르면 뒤로 이동합니다.");
			input = scan.nextLine();
			
			for(int i=0; i<40; i++) {
	        	 
	        	 System.out.println();
	         }
         if(input!=null)
        	 memberSearch();

		} catch (Exception e) {
			System.out.println("입력값은 숫자 형태여야 합니다.");
		}

	}// memberGender()

//-------------------------------------------------------------------------------------------------------------------------

	// 1. 회원정보 관리 - 2. 회원 조건별 검색 - 6. 주소
	private void memberAdress() {

		System.out.println(
				"=========================================================================================================================================");
		System.out.print("주소:");
		String input = scan.nextLine();
		System.out.println(
				"=========================================================================================================================================");

		try {
			BufferedReader reader = new BufferedReader(new FileReader(FilePath.MEMBER));

			System.out.println("[회원번호]  [아이디]     [비밀번호]    [이름]   [나이]    [성별]            [주소]\t\t[전화번호]\t[등록일]\t[마일리지]");
 
			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split("\\|");

				if (input.equals(temp[6])) {
					System.out.printf("  %-6s     %-8s      %-8s     %-4s     %s       %s      %12s\t%s\t%s\t     %s\r\n", temp[0], temp[1], temp[2],
							temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
				}
			}
			reader.close();

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t\t\t- 아무키나 누르면 뒤로 이동합니다.");
			input = scan.nextLine();
			
			for(int i=0; i<40; i++) {
	        	 
	        	 System.out.println();
	         }
         if(input!=null)
        	 memberSearch();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// memberAdress()

//-------------------------------------------------------------------------------------------------------------------------   

	// 1. 회원정보 관리 - 2. 회원 조건별 검색 - 7. 전화번호
	private void memberPhoneNum() {

		System.out.println(
				"=========================================================================================================================================");
		System.out.print("전화번호:");
		String input = scan.nextLine();
		System.out.println(
				"=========================================================================================================================================");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FilePath.MEMBER));

			System.out.println("[회원번호]  [아이디]     [비밀번호]    [이름]   [나이]    [성별]            [주소]\t\t[전화번호]\t[등록일]\t[마일리지]");

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split("\\|");

				if (input.equals(temp[7])) {
					System.out.printf("  %-6s     %-8s      %-8s     %-4s     %s       %s      %12s\t%s\t%s\t     %s\r\n", temp[0], temp[1], temp[2],
							temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
				}
			}
			reader.close();

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t\t\t- 아무키나 누르면 뒤로 이동합니다.");
			input = scan.nextLine();
			
			for(int i=0; i<40; i++) {
	        	 
	        	 System.out.println();
	         }
         if(input!=null)
        	 memberSearch();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// memberPhoneNum()

//-------------------------------------------------------------------------------------------------------------------------

	// 1. 회원정보 관리 - 2. 회원 조건별 검색 - 8. 등록일
	private void memberDate() {

		System.out.println(
				"=========================================================================================================================================");
		System.out.print("등록일:");
		String input = scan.nextLine();
		System.out.println(
				"=========================================================================================================================================");

		try {
			BufferedReader reader = new BufferedReader(new FileReader(FilePath.MEMBER));

			System.out.println("[회원번호]  [아이디]     [비밀번호]    [이름]   [나이]    [성별]            [주소]\t\t[전화번호]\t[등록일]\t[마일리지]");

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split("\\|");

				if (input.equals(temp[8])) {

					System.out.printf("  %-6s     %-8s      %-8s     %-4s     %s       %s      %12s\t%s\t%s\t     %s\r\n", temp[0], temp[1], temp[2],
							temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
				}
			}
			reader.close();

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t\t\t- 아무키나 누르면 뒤로 이동합니다.");
			input = scan.nextLine();
			
			for(int i=0; i<40; i++) {
	        	 
	        	 System.out.println();
	         }
	         if(input!=null)
	        	 memberSearch();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// memberDate()

//-------------------------------------------------------------------------------------------------------------------------

   // 2. 재고 및 매출관리   
   private void management() {
      
      Scanner scan = new Scanner(System.in);
      for(int i=0; i<40; i++) {
     	 
     	 System.out.println();
      }
      System.out.println("=========================================================================================");
      System.out.println("1. 재고 현황 및 관리");
      System.out.println("2. 매출 현황");
      System.out.println("3. 뒤로 가기");
      System.out.println("=========================================================================================");
      
      System.out.print("선택(번호) : ");
       String input = scan.nextLine();
       
       if(input.equals("1")) {
          stock();  
       } else if (input.equals("2")) {
          sales();
       } else if (input.equals("3")) {
          adminMenu();
       } else {
          System.out.println();
          System.out.println("숫자를 다시 입력해 주세요.");
          System.out.println();
          management();
       }
      
   }//management

//-------------------------------------------------------------------------------------------------------------------------
   
   // 2. 재고 및 매출관리 - 1. 재고 현황 및 관리
   private void stock() {
      
      File dir = new File(FilePath.PRODUCT_DIR);
      count = 1;
      
      System.out.println("=========================================================================================");
      System.out.printf("\t\t   [물품]\t    [전일 재고]\t    [당일 출고]\t      [입고] [현 재고]\r\n");
      inventoryManagement(dir);
      newPath = FilePath.PRODUCT_DIR;
      System.out.println("=========================================================================================");
      select();
      
   }//stock
   
//-------------------------------------------------------------------------------------------------------------------------
 
   // 2. 재고 및 매출관리 - 1. 재고 현황 및 관리 - 선택메뉴
   private void select() {
      
      Scanner scan = new Scanner(System.in);
      
      System.out.println("1.입고");
      System.out.println("2.뒤로 가기");
      System.out.println();
      System.out.print("선택(번호) : ");
      String input = scan.nextLine();
      
      if (input.equals("1")) {
         order();
      } else if (input.equals("2")) {
         management();
      } else {
         System.out.println();
         System.out.println("숫자를 다시 입력해 주세요.");
         System.out.println();
         select();
      }
      System.out.println("=========================================================================================");
   }

//-------------------------------------------------------------------------------------------------------------------------
   
   // 2. 재고 및 매출관리 - 1. 재고 현황 및 관리 - 1. 입고 선택시
   private void order() {
      
      File dir = new File(FilePath.PRODUCT_DIR);
      
      try {
         Scanner scan = new Scanner(System.in);
         
         System.out.print("물품 선택 : ");
         selectMenu = scan.nextInt();
         System.out.print("개수 : ");
         orders = scan.nextInt();
         
         //물품 번호를 잘못 입력했을시
         if(!(selectMenu <= count && selectMenu > 0)) {
            System.out.printf("물품 번호는 1 ~ %d 사이의 값만 입력하실수 있습니다.\n", count-1);
            order();
            
         //개수를 잘못 입력했을시
         } else if (orders < 1) {
            System.out.println("개수는 적어도 1개 이상이어야 합니다.");
            order();
         } else {           
            System.out.println();
            System.out.printf("%s 을(를) %d개 주문하시겠습니까?(y/n)\r\n", fileName.get(selectMenu-1), orders);
            fileName.clear();
            System.out.print("입력 : ");
            String input = this.scan.nextLine();
            
            //Y 선택시 (파일 업데이트 실행)
            if (input.equals("y") | input.equals("Y")) {
               count = 1;
               update(dir);
               
            //N 선택시 (돌아가기)
            } else if (input.equals("n") | input.equals("N")) {
               System.out.println();
               System.out.println("주문을 취소했습니다.");
               select();
               
            //Y 또는 N 값을 입력하지 않았을 경우
            } else {
               System.out.println("입력값을 다시 확인해주십시오.");
               select();
            }
            
         }
         
      } catch (Exception e) {
         System.out.println("입력값은 숫자 형태여야 합니다.");
         select();
      }
      
   }//order

 //-------------------------------------------------------------------------------------------------------------------------

   // 2. 재고 및 매출관리 - 1. 재고 현황 및 관리 (리스트 불러오기 메소드)
   private void inventoryManagement(File dir) {

      //목록 가져오기
      File[] list = dir.listFiles();
      
      //파일을 발견했을 경우
      for (File file : list) {

         if (file.isFile()) {
            
            try {
               
               BufferedReader reader = new BufferedReader(new FileReader(newPath + "\\" + file.getName()));
   
               //오늘 날짜 받기 & 문자열저장
               Calendar c = Calendar.getInstance();
               String today = String.format("%tF", c);
               
               //전일 날짜 받기 & 문자열저장
               c.add(Calendar.DATE,-1);
               String yesterday = String.format("%tF", c);
               
               String line = null;
               
               System.out.printf("%d\t", count);
               
               //파일 읽기
               while ((line = reader.readLine()) != null) { 
                  
                  //물품별.dat   // 0넘버링|1당일판매개수|2당일판매금액|3재고량|4입고량|5날짜
                 
                  //[넘버] [물품] [전일재고] [당일출고] [입고] [현재고]
                  
                  
                  //파일 내 전일데이터 찾기
                  if(line.contains(yesterday)) {
                     
                     String[] temp = line.split("\\|");
                     
                     int index = (file.getName()).indexOf(".");
                     
                     String fileName = (file.getName()).substring(0, index);
                     System.out.printf("%15s\t\t%s\t\t", fileName, temp[3]);
                  }
   
                  //파일 내 당일데이터 찾기
                  if(line.contains(today)) {
                     
                     String[] temp = line.split("\\|");
                     System.out.printf("%s\t\t%s\t%s\t\n", temp[1], temp[4], temp[3]);
                  }
               }
               
            // 파일이름을 static String 배열에 static count에 따라 저장
            int index = (file.getName()).indexOf(".");
            fileName.add(count-1, (file.getName()).substring(0, index));
            count++;
            
            } catch (Exception e) {
               System.out.println(e.toString());
            }
         }
      }//for_file
      
      //자식 폴더 접근
      for (File sub : list) {
         if (sub.isDirectory()) {
            newPath = FilePath.PRODUCT_DIR + "\\" + sub.getName();
            inventoryManagement(sub);
         }
      }//for_sub
      
    }//inventoryManagement
   
//-------------------------------------------------------------------------------------------------------------------------

      // 2. 재고 및 매출관리 - 1. 재고 현황 및 관리 - 1. 입고 선택시 (데이터 파일 업데이트 메소드)
   private void update(File dir) {

      //목록 가져오기
      
      File[] list = dir.listFiles();
      
      //파일을 발견했을 경우
         for (File file : list) {

            if (file.isFile()) {
               
               try {
                  //오늘 날짜 받기 & 문자열저장
                  Calendar c = Calendar.getInstance();
                  String today = String.format("%tF", c);
                  
                  //자식파일을 돌다가 물품선택을 발견할경우
                  if (this.count == selectMenu) {
                     
                     BufferedReader reader = new BufferedReader(new FileReader(newPath + "\\" + file.getName()));
                     
                     //파일의 문자열을 받아두기 위한 배열
                     ArrayList<String> newDat = new ArrayList<String>();
                     
                     String line = null;
                     //파일 읽기
                     while ((line = reader.readLine()) != null) { 

                        //물품별.dat   // 0넘버링|1당일판매개수|2당일판매금액|3재고량|4입고량|5날짜
                       
                        //[넘버] [물품] [전일재고] [당일출고] [입고] [현재고]
                        
                        String[] temp = line.split("\\|");
                        
                        //파일 내 당일데이터 찾기
                        if(line.contains(today)) {
                           int num1 = Integer.parseInt(temp[3]) + orders;
                           int num2 = Integer.parseInt(temp[4]) + orders;
                           line = line.replace(temp[3], num1+"");
                           line = line.replace(temp[4], num2+"");
                           
                           newDat.add(line);
                        } else {
                           newDat.add(line);
                        }
                        
                     }//while
                     
                     reader.close();

                     BufferedWriter writer = new BufferedWriter(new FileWriter(newPath + "\\" + file.getName()));
                     
                     //파일 덮어 쓰기
                     for(String n : newDat) {
                        writer.write(n + "\r\n");
                     }
                     writer.close();
                     count = 1;
                     System.out.println();
                     System.out.println("주문이 완료 되었습니다.");
                     System.out.println();
                     stock();
                  }//if
               
                  //for문을 돌면서, 물품선택에서 받은 count와 일치하는 파일찾기를 위한 static count
                  this.count++;
               } catch (Exception e) {
                  System.out.println(e.toString());
               }
               
            }
            
         }//for_file
         
         //자식 폴더 접근
         for (File sub : list) {
            if (sub.isDirectory()) {
               newPath = FilePath.PRODUCT_DIR + "\\" + sub.getName();
               update(sub);
            }
         }//for_sub
      
   }//update

//-------------------------------------------------------------------------------------------------------------------------

   // 2. 재고 및 매출관리 - 2. 매출 현황
   private void sales() {
      
      File dir = new File(FilePath.PRODUCT_DIR);
      Scanner scan = new Scanner(System.in);
      //static 초기화
      lastMonthTotal = 0;
      monthTotal = 0;
      count = 1;

      System.out.println("=========================================================================================");
      System.out.printf("\t\t    [종류]\t\t     [전월 매출]\t     [당월 매출]\r\n");
      salesStatus(dir);
      newPath = FilePath.PRODUCT_DIR;
      System.out.printf("\r\n%d\t\t   뒤로가기\r\n", count);
      System.out.println("-----------------------------------------------------------------------------------------");
      System.out.printf("합계\t\t\t\t\t%,15d원\t%,15d원\r\n", lastMonthTotal, monthTotal);
      System.out.println("=========================================================================================");
      System.out.println("\t\t\t- 상세보기를 원하시면 해당번호를 선택하십시오.");
      System.out.println();
      System.out.print("선택(번호) : ");
      try {
         int num = scan.nextInt();
         selectMenu(num, dir);
      } catch (Exception e) {
         System.out.println("번호를 잘못 선택하셨습니다.");
         sales();
      }
      
   }//sales

//-------------------------------------------------------------------------------------------------------------------------

   // 2. 재고 및 매출관리 - 2. 매출 현황 - 메뉴 선택
   private void selectMenu(int num, File dir) {
      
      //뒤로가기 선택시
      if(num==count)
         management();
      
      //해당번호 선택시
      if (num<count && num>0) {
         
         //static 초기화
         lastMonthTotal = 0;
         monthTotal = 0;
         count = 1;
         
         System.out.println("=========================================================================================");
         newPath = FilePath.PRODUCT_DIR;
         details(num, dir);
         System.out.println("-----------------------------------------------------------------------------------------");
         System.out.printf("합계\t\t\t\t\t%,15d원\t%,15d원\r\n", lastMonthTotal, monthTotal);
         System.out.println("=========================================================================================");
       System.out.println();
         System.out.println("\t\t\t- 아무키나 누르면 뒤로 이동합니다.");
         String input = scan.nextLine();
         
         //총액 static 초기화
         lastMonthTotal = 0;
         monthTotal = 0;
         dirCount = 0;
         
         if(input!=null)
            sales();
      }
      
   }//selectMenu

//-------------------------------------------------------------------------------------------------------------------------

   // 2. 재고 및 매출관리 - 2. 매출 현황 (리스트 불러오기 메소드)
   private void salesStatus(File dir) {

      //목록 가져오기
      File[] list = dir.listFiles();
      
      //전월 판매액, 당월 판매액 초기화
      long lsatMonthSales = 0;
      long monthSales = 0;

      //파일을 발견했을 경우
      for (int i=0; i<list.length; i++) {

         if (list[i].isFile()) {
            
            try {
               BufferedReader reader = new BufferedReader(new FileReader(newPath + "\\" + list[i].getName()));
   
               //당월 날짜 받기 & 문자열저장
               Calendar c = Calendar.getInstance();
               
               String year = String.format("%tF", c);
               int index = year.lastIndexOf("-");
               String month = year.substring(0, index);
               
               //전월 날짜 받기 & 문자열저장
               c.add(Calendar.MONTH, -1);
               year = String.format("%tF", c);
               String lastMonth = year.substring(0, index);
               
               String line = null;
               
               //파일 읽기
               while ((line = reader.readLine()) != null) { 

                  //물품별.dat   // 0넘버링|1당일판매개수|2당일판매금액|3재고량|4입고량|5날짜
                  
                  //[종류]  [전월 매출]  [당월 매출]
                  
                  String[] temp = line.split("\\|");
                  
                  //파일 내 전월데이터 찾아서 매출 합계액 및 총액에 더하기
                  if(line.contains(lastMonth)) {
                     lsatMonthSales += Integer.parseInt(temp[2]);
                     lastMonthTotal += Integer.parseInt(temp[2]);
                  }
                  //파일 내 당월데이터 찾아서 매출 합계액 및 총액에 더하기
                  if(line.contains(month)) {
                     monthSales += Integer.parseInt(temp[2]);
                     monthTotal += Integer.parseInt(temp[2]);
                  }
               }//while
               
               //폴더내의 마지막 파일에 도달했을경우 
               if(i==list.length-1) {
                  System.out.printf("%d\t", count);
                  
                  int index2 = newPath.lastIndexOf("\\");
                  String dirName = newPath.substring(index2+1, newPath.length());
                  
                  //종류이름 및 매출액 출력
                  System.out.printf("%15s\t\t", dirName);
                  System.out.printf("%,15d원\t%,15d원\r\n", lsatMonthSales, monthSales);

                  // 종류이름을 static String 배열에 static count에 따라 저장
                  fileName.add(count-1, dirName);
                  count++;
                  
               }//if
            
            } catch (Exception e) {
               System.out.println(e.toString());
            }
         }//if
         
      }//for_file
      
      //자식 폴더 접근
      for (File sub : list) {
         if (sub.isDirectory()) {
            newPath = FilePath.PRODUCT_DIR + "\\" + sub.getName();
            salesStatus(sub);
         }
      }//for_sub
      
   }//salesStatus
   
//-------------------------------------------------------------------------------------------------------------------------

   // 2. 재고 및 매출관리 - 2. 매출 현황 - 메뉴 선택 - 상세보기 (리스트 불러오기 메소드)
   private void details(int num, File dir) {

      //목록 가져오기
      File[] list = dir.listFiles();
      
      //입력받은 num과 count가 동일할시 파일읽기
      if (num==dirCount) {
         
         System.out.printf("- %s\r\n", dirName);
         System.out.println("=========================================================================================");
         System.out.printf("\t\t    [종류]\t\t     [전월 매출]\t     [당월 매출]\r\n");
         
         int count = 1;
         
         //파일을 발견했을 경우
         for (int i=0; i<list.length; i++) {
   
            //전월 판매액, 당월 판매액 초기화
            long lsatMonthSales = 0;
            long monthSales = 0;
            
            if (list[i].isFile()) {
               
               try {
                  BufferedReader reader = new BufferedReader(new FileReader(newPath + "\\" + list[i].getName()));
      
                  //당월 날짜 받기 & 문자열저장
                  Calendar c = Calendar.getInstance();
                  
                  String year = String.format("%tF", c);
                  int index = year.lastIndexOf("-");
                  String month = year.substring(0, index);
                  
                  //전월 날짜 받기 & 문자열저장
                  c.add(Calendar.MONTH, -1);
                  year = String.format("%tF", c);
                  String lastMonth = year.substring(0, index);
                  
                  String line = null;
                  
                  //파일 읽기
                  while ((line = reader.readLine()) != null) { 
   
                     //물품별.dat   // 0넘버링|1당일판매개수|2당일판매금액|3재고량|4입고량|5날짜
                     
                     //[종류]  [전월 매출]  [당월 매출]
                     
                     String[] temp = line.split("\\|");
                     
                     //파일 내 전월데이터 찾아서 매출 합계액 및 총액에 더하기
                     if(line.contains(lastMonth)) {
                        lsatMonthSales += Integer.parseInt(temp[2]);
                        lastMonthTotal += Integer.parseInt(temp[2]);
                     }
                     //파일 내 당월데이터 찾아서 매출 합계액 및 총액에 더하기
                     if(line.contains(month)) {
                        monthSales += Integer.parseInt(temp[2]);
                        monthTotal += Integer.parseInt(temp[2]);
                     }
                  }//while
                  
                  //종류이름 및 매출액 출력
                  System.out.printf("%d\t", count);
                  
                  count++;
                  
                  int index2 = (list[i].getName()).indexOf(".");
                  String fileName = (list[i].getName()).substring(0, index2);
                  
                  System.out.printf("%15s\t\t%,15d원\t%,15d원\r\n", fileName, lsatMonthSales, monthSales);
                  
               } catch (Exception e) {
                  System.out.println(e.toString());
               }
            }//if
            
         }//for_file
      }//if
      
      //자식 폴더 접근
      for (File sub : list) {
         if (sub.isDirectory()) {
            newPath = FilePath.PRODUCT_DIR + "\\" + sub.getName();
            dirCount++;
            if (num==dirCount) {
              dirName = sub.getName();
            }
            details(num, sub);
         }
      }//for_sub
      
   }//details
   
//-------------------------------------------------------------------------------------------------------------------------


}// class
