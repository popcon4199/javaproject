package membership;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MemberRegister {

	private static Scanner scan;
	private static ArrayList<Member> list; // 회원 목록
	private static Object[] temp;
	String inputString = "희망ID(4글자이상 8글자내로 입력하세요): ";
	String duplString = "이미 사용중인 ID입니다. 다른 ID를 입력해 주세요.";

	static {
		scan = new Scanner(System.in);
		list = new ArrayList<Member>(); // 회원 목록

		
	}

//	public void startScreen() {
//		System.out.println("환영합니다.");
//		System.out.println("1");
//	}

	public MemberRegister() {
		
//		System.out.println();
//		System.out.print("1.회원등록 및 수정(번호를 입력해 주세요).\r선택:");
//		String memberJoin = scan.nextLine();
//
//		if (memberJoin.equals("1")) {
			start();
		
	}

	public void start() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("================= 환 영 합 니 다 =================");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FilePath.PATHMEMBER));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("\\|");

				Member member = new Member();
				member.setSeq(temp[0]);
				member.setId(temp[1]);
				member.setPassword(temp[2]);
				member.setName(temp[3]);
				member.setAge(Integer.parseInt(temp[4]));
				member.setGender(temp[5]);
				member.setAddress(temp[6]);
				member.setPhone(temp[7]);
				member.setRegDate(temp[8]);
				member.setPoint(Integer.parseInt(temp[9]));

				list.add(member);
			}
			reader.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("\t\t1.회원 가입");
		System.out.println("\t\t2.수정 하기");
		System.out.println("\t\t3.뒤로 가기");
		System.out.println();
		System.out.println("==================================================");
		System.out.print("번호(숫자)를 입력해주세요 : ");
		String strSelectedItem = scan.nextLine();
		System.out.println("==================================================");

		// boolean boo = true;

		// 회원가입
		if (strSelectedItem.equals("1")) {
			join();

		} else if (strSelectedItem.equals("2")) {
			memberModify();
		} else {
//			MemberRegister();
		}

	}

	private void MemberRegister() {

		System.out.println("환영합니다.");
		System.out.println();
		System.out.println("1.회원등록 및 수정(번호를 입력해 주세요).");
		String memberJoin = scan.nextLine();

		if (memberJoin.equals("1")) {
			start();
		}

	}

	/* 회원가입 */
	public void join() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("==================================================");
		System.out.println("\t\t회 원 가 입");
		System.out.println("==================================================");

		try {

			String id = "";
			System.out.println(inputString);

			while (true) {
				// 희망ID(4글자이상 8글자내로 입력하세요):
				id = scan.nextLine();

				if (!checkIDLength(id)) { // 길이안됌
					System.out.print(inputString);
					continue;
				} else if (!checkIDDuplication(id)) { // 중복임..
					System.out.println(duplString);
					continue;
				} else {
					break;
				}
			}

			// 회원가입으로 ..

			System.out.println();
			String password = "";
			while (true) {
				System.out.print("비밀번호 입력 :");
				String pass = scan.nextLine();
				System.out.print("비밀번호 재입력 :");
				String pass1 = scan.nextLine();

				Member sp = new Member();
				if (!pass.equals(pass1)) {
					System.out.println();
					System.out.println("비밀번호가 일치하지 않습니다.다시 입력해주세요.");
					System.out.print("1.재입력\n2.나가기\n선택:");
					String choice = scan.nextLine();
					if (choice.equals("1")) {

					} else {
						start();
						break;
					}

				} else {
					password = pass;
					break;
				}
			}

			System.out.println();
			System.out.println("==================================================");
			String name = "";
			// name 유효성검사..
			while (true) {
				System.out.println("\t이름에는 한글만 가능합니다.");
				System.out.print("이름 : ");
				name = scan.nextLine().trim();

				if (Pattern.matches("^[가-힣]*$", name)) {
					break;
				}
			}

			System.out.println();
			System.out.println("숫자를 입력해주세요.");

			int age = 0;
			while (true) {
				System.out.print("나이 : ");
				age = scan.nextInt();
				if (0 < age && age < 150) {
					break;
				}
			}
			// 나이 유효성
			System.out.println();
			System.out.println("1.남자\n2.여자\n숫자를 입력해주세요");
			
			scan.nextLine();
			String gender = "";
			while (true) {
				System.out.print("성별 : ");
				gender = scan.nextLine();

				if (gender.equals("1") || gender.equals("2")) {
					if (gender.equals("1")) {
						gender = "true";
					} else if(gender.equals("2")){
						gender = "false";
					}else {
						
					}
					break;
				}
			}
			// 성별 유효성 검사
			System.out.println();

			System.out.print("주소 : ");
			String address = scan.nextLine().replace(" ", "");

			System.out.println();

			System.out.print("전화번호(숫자만 입력해주세요) : ");
			String phone = scan.nextLine().replace("-", "").replace(" ", "");
			System.out.println(phone);

			// 기본값으로 자동 셋팅
			System.out.println();
			Date date = new Date();
			SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
			String regDate = simpleDate.format(date);

			System.out.println();

			int point = 0;

			Member member = new Member();

			member.setId(id);
			member.setPassword(password);
			member.setName(name);
			member.setAge(age);
			member.setGender(gender);
			member.setAddress(address);
			member.setPhone(phone);
			member.setRegDate(regDate);
			member.setPoint(point);

			info(member);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 저장..
	public void saveMember(Member member) {

		// System.out.println("저장하기 ");
		try {

//			int listSize = list.size();
//			String listSeqNo = list.get(listSize - 1).getSeq().replace("sy", "");
//			int newSeq = Integer.parseInt(listSeqNo) + 1; // 마지막줄에 번호 넣기

//			System.out.println("listSize " + listSize);
//			System.out.println("listSeqNo " + listSeqNo);
//			System.out.println("newSeq " + newSeq);                              

			BufferedWriter writer = new BufferedWriter(new FileWriter(FilePath.PATHMEMBER, true));

			// 받은 정보 이어쓰기
			// writer.write("\r\n");
			writer.write(String.format("%s|%s|%s|%s|%d|%s|%s|%s|%s|%d\r\n", "sy" + getNewSeq(), member.getId(),
					member.getPassword(), member.getName(), member.getAge(), member.getGender(), member.getAddress(),
					member.getPhone(), member.getRegDate(), member.getPoint()));

			writer.close();

			list.add(member); // 저장 !!

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void info(Member member) {

		try {

			System.out.println("==================================================");      //가입 후 첫번째 정보확인
			System.out.println("                   정보 확인하기");
			System.out.println("==================================================");
			System.out.print("이름 : " + member.getName() + "\r\n");
			System.out.print("나이 : " + member.getAge() + "\r\n");

			String man = "";
			String woman = "";
			if (member.getGender().equals("true")) {
				man = "1.남";
				System.out.print("성별 : " + man + "\r\n");
			} else if (member.getGender().equals("false")) {
				woman = "2.여";
				System.out.print("성별 : " + woman + "\r\n");
			}
			System.out.print("주소 : " + member.getAddress() + "\r\n");
			System.out.print("전화번호 : " + member.getPhone() + "\r\n");

			System.out.println();
			System.out.print("1.재입력(수정하기)\n2.정보 저장하기\n");
			System.out.print("선택 :");
			String choice = scan.nextLine();
			System.out.println();

			if (choice.equals("1")) {
				modify(member); // 다시 입력
				// break;
			}
			// else if (choice.equals("2")) {

			System.out.println();
			System.out.println();
			System.out.printf("*************'%s'님 가입을 축하드립니다.*************", member.getName());
			saveMember(member); // 저장하고 나가기
			// }

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void modify(Member member) { // 수정하기

	      try {
	         System.out.println();
	         String name = "";
	         // name 유효성검사..
	         while (true) {
	            System.out.println("==================================================");
	            System.out.println("이름에는 숫자 및 특수문자는 불가능합니다.");
	            System.out.print("이름 : ");
	            name = scan.nextLine().trim();
	            member.setName(name);

	            if (Pattern.matches("^[가-힣]*$", name)) {
	               break;
	            }
	         }

	         System.out.println();
	         System.out.println("숫자로만 입력해주세요.");

	         int age = 0;

	         while (true) {
	            System.out.print("나이 : ");
	            age = scan.nextInt();
	            member.setAge(age);
	            if (0 < age && age < 150) {
	               break;
	            }
	         }
	         // 나이 유효성

	         System.out.println();
	         System.out.println("1.남자\n2.여자\n(번호로 입력해주세요)");

	         String gender = "";

	         while (true) {
	            scan.nextLine();
	            System.out.print("성별 : ");
	            gender = scan.nextLine();

	            if (gender.equals("1") || gender.equals("2")) {
	               if (gender.equals("1")) {
	                  gender = "true";
	               } else if (gender.equals("2")) {
	                  gender = "false";
	               }else {
	                  
	               }
	               member.setGender(gender);
	               break;
	            }

	         }
	         // 성별 유효성 검사

	         System.out.println();

	         System.out.print("주소 : ");
	         String address = scan.nextLine().replace(" ", "");
	         member.setAddress(address);
	         System.out.println();

	         System.out.print("전화번호(숫자로만 입력해주세요) : ");
	         String phone = scan.nextLine().replace("-", "").replace(" ", "");
	         System.out.println(phone);
	         member.setPhone(phone);

	         System.out.println();

	         System.out.println("==================================================");
	         System.out.println("               정보 확인하기");
	         System.out.println("==================================================");
	         System.out.print("이름:" + member.getName() + "\r\n");
	         System.out.print("나이:" + member.getAge() + "\r\n");

	         String man = "";
	         String woman = "";
	         if (member.getGender().equals("true")) {
	            man = "1.남";
	            System.out.print("성별:" + man + "\r\n");
	         } else if (member.getGender().equals("false")) {
	            woman = "2.여";
	            System.out.print("성별:" + woman + "\r\n");
	         }
	         System.out.print("주소:" + member.getAddress() + "\r\n");
	         System.out.print("전화번호" + member.getPhone() + "\r\n");

	         System.out.println();

	         System.out.print("수정을 완료하시겠습니까? (y / n)\n선택:");
	         String finallyModify = scan.nextLine();

	         if (finallyModify.equals("n")) {
	            modify(member);
	         }
	      } catch (Exception e) {
	         System.out.println(e.toString());
	      }
	   }

	   /* 글자수확인 */
	   public boolean checkIDLength(String pID) {
	      //
	      int inputIdLength = pID.length(); // 입력된 ID의 길이

	      boolean checkIdLength = (4 <= inputIdLength && inputIdLength <= 8);
	      return checkIdLength;
	   }

	   /* 중복 확인 */
	   public boolean checkIDDuplication(String pID) {
	      boolean result = true;
	      for (int i = 0; i < list.size(); i++) {
	         if (pID.equals(list.get(i).getId())) { // 아이디 중복됨

	            result = false;
	            break;

	         }
	      }
	      return result;
	   }
	   
	public int getNewSeq() {
		int listSize = list.size();
		String listSeqNo = list.get(listSize - 1).getSeq().replace("sy", "");
		int newSeq = Integer.parseInt(listSeqNo) + 1; // 마지막줄에 번호 넣기
		return newSeq;
	}

	public String memberModify() {

		String total = "";
		try {

			BufferedReader reader = new BufferedReader(new FileReader(FilePath.PATHMEMBER));

			System.out.print("1.ID검색 또는 전화번호 검색:\n선택:");
			String memberSearch = scan.nextLine();

			System.out.println();
			System.out.println("==================================================");
			System.out.println("====================정보 확인=====================");
			System.out.println("==================================================");
			System.out.println();
			System.out.println();
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("\\|");
				if (line.contains(memberSearch)) {

					String man = "";
					String woman = "";

					if (temp[5].equals("true")) {
						temp[5] = "남";
					} else if (temp[5].equals("false")) {
						temp[5] = "여";
					}
					System.out.printf("이름: %s\n나이: %s\n성별:%s\n주소:%s\n전화번호:%s\n등록일:%s\n마일리지:%s\r\n", temp[3], temp[4],
							temp[5], temp[6], temp[7], temp[8], temp[9]);

					System.out.println();
					System.out.println();
					System.out.println("==================================================");
					System.out.print("1.정보 수정\n2.나가기\n선택:");
					String modifyInfo = scan.nextLine();
					System.out.println("==================================================");
					System.out.println();
					
					if (modifyInfo.equals("1")) { // 수정하기 >이름 유효성
						String newName = "";
						while (true) {
							System.out.println("이름에는 숫자 및 특수문자는 불가능합니다.");
							System.out.print("이름:");
							newName = scan.nextLine().trim();
							if (Pattern.matches("^[가-힣]*$", newName)) {
								break;
							}
						}

						int newAge = 0;
						while (true) {
							System.out.println("숫자로만 입력해주세요."); // 나이 유효성
							System.out.print("나이:");
							newAge = Integer.parseInt(scan.nextLine());
							if (0 < newAge && newAge < 150) {
								break;
							}
						}
						String newGender = "";
						while (true) { // 성별 유효성 검사
							System.out.println("1.남자\n2.여자\n번호로 입력해주세요\n");
							System.out.print("성별 :");
							newGender = scan.nextLine().trim();
							if (newGender.equals("1") || newGender.equals("2")) {
								if (newGender.equals("1")) {
									newGender = "true";
								} else if (newGender.equals("2")) {
									newGender = "false";
								}else {
									
								}
								break;
							}
						}
						System.out.print("주소 :");
						String newAddress = scan.nextLine().trim().replace(" ", ""); // 주소 유효성
						System.out.println("전화번호(숫자만 입력해주세요)");
						System.out.print("전화번호 :");
						String newPhone = scan.nextLine().trim().replace("-", "").replace(" ", ""); // 번호 유효성

						line = line.replace(temp[3], newName);
						line = line.replace(temp[4], "" + newAge);
						line = line.replace(temp[5], newGender);
						line = line.replace(temp[6], newAddress);
						line = line.replace(temp[7], newPhone);

						// sy1869|LXrhKvoz|cantbOnP|이유창|23|false|서울시북구무암동|01059574857|2019-02-15|29287
						System.out.println("==================================================");
						total += line + "\r\n";

					} 
					}else {
						total += line + "\r\n";
						//System.out.println(line);
				}

			}
			
			reader.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());

		}
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(FilePath.PATHMEMBER));
			writer.write(total);
			//System.out.println(total);
			writer.close();
			System.out.println("************정보 수정이 완료되었습니다************");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return total;
	}

}
