package etc;

import java.util.ArrayList;

import Stream.locker;

public class Facilities_Cash {

	public static void main(String[] args) {
		
		cash();
//		test();
		
	}//main
	
	public static void test() {
		//환상의 나라 황제 마사지  	 menu : 아로마다리마사지	 개수 :  1
		//황금마차 자판기       	 menu :       콜라	 개수 :  2
		//오빤 강남스타일 노래방   	 menu :      1시간	 개수 :  1
		
		ArrayList<Temp> list = new ArrayList<Temp>();
		list.add(new Temp("환상의 나라 황제 마사지", "아로마다리마사지", "1"));
		list.add(new Temp("황금마차 자판기", "콜라", "2"));
		list.add(new Temp("오빤 강남스타일 노래방", "1시간", "1"));
		
		cash2(list);
		
		
	}
	
	public static void cash2(ArrayList<Temp> list) {
		
		System.out.println();
		//System.out.printf("*=*=*=*=*=* %s 님의 이용 내역입니다. *=*=*=*=*=*",locker.getLockers().get(Item.getLockid()).getLockernum()+"");
		System.out.println();
		//System.out.println("========= 입장권 ========\n");
//		System.out.println();
//		for(Item item : Facilities.items) {
//			System.out.println(item);
//		}
//		
//		System.out.println();
//		System.out.println("라커에 따른");
		for(Temp i : list) {
			System.out.printf("%-20s\t menu : %-15s\t 개수 : %2s\n", i.getA(), i.getB(), i.getC());				
			
		}
//		System.out.println(Facilities.items); //누적값들
		
	}//cash
	

	public static void cash() {
		
		System.out.println();
		System.out.printf("*=*=*=*=*=*= %s 님의 이용 내역입니다. *=*=*=*=*=*",locker.getLockers().get(Item.getLockid()).getLockernum()+"");
		System.out.println();
		System.out.println();
//		System.out.println("========= 입장권 ========\n");
//		System.out.println();
//		for(Item item : Facilities.items) {
//			System.out.println(item);
//		}
		
//		System.out.println();
//		System.out.println("라커에 따른");
		int total = 0;
		for(Item i : locker.getLockers().get(Item.getLockid()).getItems()) {
			System.out.printf("%-20s\t menu : %-15s\t 개수 : %2s\n",i.getCategory(),i.getMenu(),(i.getEa().equals(null) ? "1":i.getEa()));				
			total += Integer.parseInt(i.getEa())*i.getPrice();
		}
		System.out.println();
		System.out.printf("총액 : %,d",total);
//		System.out.println(Facilities.items); //누적값들
		
	}//cash
	
	
}//class


class Temp {
	private String a;
	private String b;
	private String c;
	
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public Temp(String a, String b, String c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	
}